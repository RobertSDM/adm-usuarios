package mai.administracaousuarios.domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "tb_mai_cidade")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_cidade", length = 50)
    private String idCidade;
    @Setter
    @Column(name = "nm_cidade", length = 50)
    private String nome;
    @Setter
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_estado", nullable = false)
    private Estado estado;
}
