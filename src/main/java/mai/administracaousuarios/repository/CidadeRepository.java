package mai.administracaousuarios.repository;

import mai.administracaousuarios.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, String> {
}
