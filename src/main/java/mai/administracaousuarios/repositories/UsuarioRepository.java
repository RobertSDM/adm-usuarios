package mai.administracaousuarios.repositories;

import mai.administracaousuarios.domains.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
}
