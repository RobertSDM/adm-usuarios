package mai.administracaousuarios.domains.estado;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_mai_estado")
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_estado", length = 50)
    private String idEstado;
    @Column(name = "sg_estado", length = 2, nullable = false)
    private String sigla;
    @Column(name = "nm_estado", length = 30, nullable = false)
    private String nome;

    public Estado() {
    }

    public Estado(String idEstado, String sigla, String nome) {
        this.idEstado = idEstado;
        this.sigla = sigla;
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(String idEstado) {
        this.idEstado = idEstado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
