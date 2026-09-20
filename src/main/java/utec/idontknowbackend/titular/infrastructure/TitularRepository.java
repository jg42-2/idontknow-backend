// titular/infrastructure/TitularRepository.java
package utec.idontknowbackend.titular.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import utec.idontknowbackend.titular.model.Titular;

public interface TitularRepository extends JpaRepository<Titular, Long> {
}