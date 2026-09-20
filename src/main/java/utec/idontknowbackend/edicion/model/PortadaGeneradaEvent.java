package utec.idontknowbackend.edicion.model;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class PortadaGeneradaEvent extends ApplicationEvent {

    private final Edicion edicion;

    public PortadaGeneradaEvent(Object source, Edicion edicion) {
        super(source);
        this.edicion = edicion;
    }
}