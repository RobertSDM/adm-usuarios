package maia.administracaousuarios.repositories;

import maia.administracaousuarios.domains.logradouro.Logradouro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogradouroRepository extends JpaRepository<Logradouro, String> {
}
