// user/infrastructure/UsuarioRepository.java
package utec.idontknowbackend.user.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import utec.idontknowbackend.user.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
    boolean existsByEmail(String email);
}