package maia.administracaousuarios.repositories;

import maia.administracaousuarios.domains.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
}
