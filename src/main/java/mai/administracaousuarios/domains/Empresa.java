package mai.administracaousuarios.domains;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_mai_empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_empresa", length = 50, nullable = false)
    private String idEmpresa;
    @Column(name = "nm_empresa", length = 30, nullable = false, unique = true)
    private String nome;
    @Column(name = "nr_cnpj", length = 14, nullable = false, unique = true)
    private String cnpj;
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_logradouro")
    private Logradouro logradouro;

    public Empresa() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Logradouro getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(Logradouro logradouro) {
        this.logradouro = logradouro;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
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
}
