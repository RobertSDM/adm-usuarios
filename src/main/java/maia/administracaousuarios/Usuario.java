package maia.administracaousuarios;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_usuario")
    private String idUsuario;
    @Column(name = "nome")
    private String nome;
    @Column(name="cnpj")
    private String cnpj;
    @Column(name = "contato")
    private String contato;
    @Column(name = "login")
    private String login;
    @Column(name = "senha")
    private String senha;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    public Usuario() {
    }

    public Usuario(String idUsuario, String nome, String cnpj, String contato) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.cnpj = cnpj;
        this.contato = contato;
    }

    public String getId() {
        return idUsuario;
    }

    public void setId(String id) {
        this.idUsuario = id;
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
}
