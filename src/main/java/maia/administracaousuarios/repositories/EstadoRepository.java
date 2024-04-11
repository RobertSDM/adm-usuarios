package maia.administracaousuarios.repositories;

import maia.administracaousuarios.domains.estado.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, String> {
}
