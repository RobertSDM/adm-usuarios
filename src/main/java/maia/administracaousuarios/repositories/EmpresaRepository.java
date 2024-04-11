package maia.administracaousuarios.repositories;

import maia.administracaousuarios.domains.empresa.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, String> {
}
