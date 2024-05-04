package mai.administracaousuarios.domains;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_mai_cidade")
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_cidade", length = 50)
    private String idCidade;
    @Column(name = "nm_cidade", length = 50)
    private String nome;
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_estado", nullable = false)
    private Estado estado;

    public Cidade() {
    }

    public Cidade(String idCidade, String nome, Estado estado) {
        this.idCidade = idCidade;
        this.nome = nome;
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(String idCidade) {
        this.idCidade = idCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
