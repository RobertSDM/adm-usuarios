package maia.administracaousuarios.repositories;

import maia.administracaousuarios.domains.cidade.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, String> {
}
