package utec.idontknowbackend.polymarket;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import utec.idontknowbackend.mercado.infrastructure.MercadoRepository;
import utec.idontknowbackend.mercado.model.Mercado;
import utec.idontknowbackend.mercado.model.MercadoService;
import utec.idontknowbackend.snapshot.model.SnapshotService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PolymarketIngestService {

    private final PolymarketClient polymarketClient;
    private final MercadoRepository mercadoRepository;
    private final MercadoService mercadoService;
    private final SnapshotService snapshotService;

    public List<MovimientoMercado> sincronizar() {
        List<PolymarketMarketDTO> mercadosExternos = polymarketClient.obtenerMercadosActivos();
        List<MovimientoMercado> movimientos = new ArrayList<>();

        for (PolymarketMarketDTO dto : mercadosExternos) {
            try {
                BigDecimal nuevaProbabilidad = dto.getProbabilidadSi();
                if (nuevaProbabilidad == null) continue;

                Mercado mercado = mercadoRepository.findByPolymarketId(dto.getId())
                        .orElseGet(() -> crearMercado(dto));

                BigDecimal anterior = mercado.getProbabilidadActual();

                mercadoService.actualizarProbabilidad(mercado, nuevaProbabilidad);
                snapshotService.registrar(mercado, nuevaProbabilidad);

                movimientos.add(new MovimientoMercado(mercado, anterior, nuevaProbabilidad));
            } catch (Exception ex) {
                log.error("Error sincronizando mercado {}: {}", dto.getId(), ex.getMessage());
            }
        }
        return movimientos;
    }

    private Mercado crearMercado(PolymarketMarketDTO dto) {
        Mercado nuevo = Mercado.builder()
                .polymarketId(dto.getId())
                .preguntaOriginal(dto.getQuestion())
                .probabilidadActual(BigDecimal.ZERO)
                .fechaResolucionEstimada(dto.getEndDateAsLocalDateTime())
                .resuelto(false)
                .build();
        return mercadoRepository.save(nuevo);
    }
}