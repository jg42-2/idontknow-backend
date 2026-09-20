package utec.idontknowbackend.mercado.model;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class MercadoUmbralCruzadoEvent extends ApplicationEvent {

    private final Mercado mercado;

    public MercadoUmbralCruzadoEvent(Object source, Mercado mercado) {
        super(source);
        this.mercado = mercado;
    }
}