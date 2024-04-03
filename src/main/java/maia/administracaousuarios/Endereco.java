package maia.administracaousuarios;

import jakarta.persistence.*;

@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private Long idEndereco;
    @Column(name = "logradouro")
    private String logradouro;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "estado")
    private String estado;

    public Endereco() {
    }

    public Endereco(Long idEndereco, String logradouro, String cidade, String estado) {
        this.idEndereco = idEndereco;
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Long getId() {
        return idEndereco;
    }

    public void setId(Long id) {
        this.idEndereco = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
