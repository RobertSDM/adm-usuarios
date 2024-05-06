package mai.administracaousuarios.domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_mai_logradouro")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Logradouro {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_logradouro", length = 50, nullable = false)
    private String idLogradouro;
    @Setter
    @Column(name = "nr_cep", length = 8, nullable = false)
    private String cep;
    @Setter
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cidade")
    private Cidade cidade;
}
