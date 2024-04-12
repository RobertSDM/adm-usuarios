package mai.administracaousuarios.repositories;

import mai.administracaousuarios.domains.empresa.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, String> {
}
