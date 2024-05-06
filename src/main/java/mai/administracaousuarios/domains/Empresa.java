package mai.administracaousuarios.domains;

import jakarta.persistence.*;
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
    private String nome;
    @Setter
    @Column(name = "nr_cnpj", length = 14, nullable = false, unique = true)
    private String cnpj;
    @Setter
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    @Setter
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_logradouro")
    private Logradouro logradouro;
}
