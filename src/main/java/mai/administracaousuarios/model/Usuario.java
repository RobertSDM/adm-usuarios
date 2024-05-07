package mai.administracaousuarios.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_mai_usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_usuario", length = 50)
    private String idUsuario;
    @Column(name = "login", length = 30, nullable = false, unique = true)
    private String login;
    @Column(name = "senha", nullable = false)
    private String senha;
    @Column(name = "salt", length = 50)
    private String salt;
}
