package maia.administracaousuarios;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_usuario", nullable = false)
    private String idUsuario;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name="cnpj", nullable = false)
    private String cnpj;
    @Column(name = "contato", nullable = false)
    private String contato;
    @Column(name = "login", nullable = false)
    private String login;
    @Column(name = "senha")
    private String senha;
    @Column(name = "salt")
    private String salt;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco", nullable = false)
    private Endereco endereco;

    public Usuario() {
    }

    public Usuario(String idUsuario, String nome, String cnpj, String contato) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.cnpj = cnpj;
        this.contato = contato;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
