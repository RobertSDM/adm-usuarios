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
    @Size(max = 30, min = 4, message = "The login size must be between 4 and 30")
    @NotEmpty(message = "The attribute login cannot be null or blank")
    private String login;
    @Column(name = "senha",length = 100, nullable = false)
    private String senha;
    @Column(name = "salt", length = 20, nullable = false)
    private String salt;
}
