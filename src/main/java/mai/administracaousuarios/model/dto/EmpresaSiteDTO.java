package mai.administracaousuarios.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mai.administracaousuarios.model.Empresa;
import mai.administracaousuarios.model.interfaces.InterfaceDTOMapper;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaSiteDTO implements InterfaceDTOMapper<Empresa, EmpresaSiteDTO> {

    @NotBlank
    @Size(min = 10, message = "The min size is 10")
    private String site;

    @Override
    public void toEntity(EmpresaSiteDTO empresaSiteDTO, Empresa empresa) {
        empresa.setSite(empresaSiteDTO.getSite());
    }
}
