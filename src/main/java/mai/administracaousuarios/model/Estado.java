package mai.administracaousuarios.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_mai_estado")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_estado", length = 50)
    private String idEstado;
    @Setter
    @Column(name = "sg_estado", length = 2, nullable = false)
    @NotEmpty(message = "The attribute sigla cannot be null or blank")
    @Size(max = 2, min = 2, message = "The cep size must be 2")
    private String sigla;
    @Setter
    @Column(name = "nm_estado", length = 30, nullable = false)
    @NotEmpty(message = "The attribute nome cannot be null or blank")
    @Size(max = 30, min = 4, message = "The nome size must be between 4 and 30")
    private String nome;

}
