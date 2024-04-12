package mai.administracaousuarios.domains.usuario;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_mai_usuario")
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

    public Usuario() {
    }

    public Usuario(String idUsuario, String login, String senha, String salt) {
        this.idUsuario = idUsuario;
        this.login = login;
        this.senha = senha;
        this.salt = salt;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
