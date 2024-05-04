package mai.administracaousuarios.repositories;

import mai.administracaousuarios.domains.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, String> {
}
