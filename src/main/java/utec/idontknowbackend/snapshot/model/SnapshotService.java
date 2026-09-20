package utec.idontknowbackend.snapshot.model;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import utec.idontknowbackend.mercado.model.Mercado;
import utec.idontknowbackend.snapshot.infrastructure.SnapshotRepository;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class SnapshotService {

    private final SnapshotRepository snapshotRepository;

    // se llama una vez al día por mercado, desde el job de sincronización
    public void registrar(Mercado mercado, BigDecimal probabilidad) {
        Snapshot snapshot = Snapshot.builder()
                .mercado(mercado)
                .probabilidad(probabilidad)
                .fecha(LocalDate.now())
                .build();

        snapshotRepository.save(snapshot);
    }
}