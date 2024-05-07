package mai.administracaousuarios.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_mai_empresa")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_empresa", length = 50, nullable = false)
    private String idEmpresa;
    @Setter
    @Column(name = "nm_empresa", length = 30, nullable = false, unique = true)
    @NotEmpty(message = "The attribute nome cannot be null or blank")
    @Size(max = 50, min = 4, message = "The name size must be between 4 and 50")
    private String nome;
    @Setter
    @Column(name = "nr_cnpj", length = 14, nullable = false, unique = true)
    @NotEmpty(message = "The attribute cnpj cannot be null or blank")
    @Size(max = 14, min = 14, message = "The cnpj size must be 14")
    private String cnpj;
    @Setter
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    @NotNull(message = "The attribute usuario cannot be null")
    private Usuario usuario;
    @Setter
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_logradouro")
    @NotNull(message = "The attribute logradouro cannot be null")
    private Logradouro logradouro;
}
