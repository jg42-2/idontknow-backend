// user/infrastructure/UsuarioRepository.java
package utec.idontknowbackend.user.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import utec.idontknowbackend.categoria.model.Categoria;
import utec.idontknowbackend.user.model.Usuario;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
    boolean existsByEmail(String email);
    @Query("select distinct u from Usuario u join u.categoriasSeguidas c where c in :categorias")
    List<Usuario> findSeguidoresDeCategorias(@Param("categorias") Set<Categoria> categorias);
}