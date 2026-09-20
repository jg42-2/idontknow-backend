package utec.idontknowbackend.edicion.model;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import utec.idontknowbackend.edicion.DTO.EdicionResponseDTO;
import utec.idontknowbackend.edicion.DTO.EdicionSummaryDTO;
import utec.idontknowbackend.edicion.infrastructure.EdicionRepository;
import utec.idontknowbackend.exceptions.ResourceNotFoundException;
import utec.idontknowbackend.titular.DTO.TitularResponseDTO;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class EdicionService {

    private final EdicionRepository edicionRepository;
    private final ModelMapper modelMapper;

    public EdicionResponseDTO getDeHoy() {
        return getPorFecha(LocalDate.now());
    }

    public EdicionResponseDTO getPorFecha(LocalDate fecha) {
        Edicion edicion = edicionRepository.findByFecha(fecha)
                .orElseThrow(() -> new ResourceNotFoundException("No hay portada para " + fecha));

        EdicionResponseDTO dto = modelMapper.map(edicion, EdicionResponseDTO.class);
        dto.setTitulares(
                edicion.getTitulares().stream()
                        .map(t -> modelMapper.map(t, TitularResponseDTO.class))
                        .toList()
        );
        return dto;
    }

    public Page<EdicionSummaryDTO> listArchivo(Pageable pageable) {
        return edicionRepository.findAll(pageable)
                .map(e -> EdicionSummaryDTO.builder()
                        .id(e.getId())
                        .fecha(e.getFecha())
                        .cantidadTitulares(e.getTitulares().size())
                        .build());
    }
}