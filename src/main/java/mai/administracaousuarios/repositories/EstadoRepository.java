package mai.administracaousuarios.repositories;

import mai.administracaousuarios.domains.estado.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, String> {
}