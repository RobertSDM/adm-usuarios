package mai.administracaousuarios.repositories;

import mai.administracaousuarios.domains.Logradouro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogradouroRepository extends JpaRepository<Logradouro, String> {
}
