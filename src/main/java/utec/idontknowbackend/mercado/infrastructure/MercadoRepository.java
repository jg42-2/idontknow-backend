// mercado/infrastructure/MercadoRepository.java
package utec.idontknowbackend.mercado.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import utec.idontknowbackend.mercado.model.Mercado;

import java.util.Optional;

public interface MercadoRepository extends JpaRepository<Mercado, Long> {
    Optional<Mercado> findByPolymarketId(String polymarketId);
}