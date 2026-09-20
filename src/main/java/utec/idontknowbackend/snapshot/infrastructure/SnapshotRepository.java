// snapshot/infrastructure/SnapshotRepository.java
package utec.idontknowbackend.snapshot.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import utec.idontknowbackend.snapshot.model.Snapshot;

import java.util.List;

public interface SnapshotRepository extends JpaRepository<Snapshot, Long> {
    List<Snapshot> findByMercadoIdOrderByFechaAsc(Long mercadoId);
}