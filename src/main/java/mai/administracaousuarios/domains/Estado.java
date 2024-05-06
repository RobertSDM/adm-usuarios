package mai.administracaousuarios.domains;

import jakarta.persistence.*;
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
    private String sigla;
    @Setter
    @Column(name = "nm_estado", length = 30, nullable = false)
    private String nome;

}
