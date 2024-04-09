package maia.administracaousuarios;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_mai_logradouro")
public class Logradouro {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_logradouro", length = 50, nullable = false)
    private String idLogradouro;
    @Column(name = "nr_cep", length = 8, nullable = false)
    private String cep;
    @OneToOne(optional = false)
    @JoinColumn(name = "id_estado")
    private Estado estado;

    public Logradouro() {
    }

    public Logradouro(String idLogradouro, String cep, Estado estado) {
        this.idLogradouro = idLogradouro;
        this.cep = cep;
        this.estado = estado;
    }

    public String getIdLogradouro() {
        return idLogradouro;
    }

    public void setIdLogradouro(String idLogradouro) {
        this.idLogradouro = idLogradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
