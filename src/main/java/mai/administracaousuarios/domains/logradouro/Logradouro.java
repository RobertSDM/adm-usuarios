package mai.administracaousuarios.domains.logradouro;

import jakarta.persistence.*;
import mai.administracaousuarios.domains.cidade.Cidade;

@Entity
@Table(name = "tb_mai_logradouro")
public class Logradouro {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_logradouro", length = 50, nullable = false)
    private String idLogradouro;
    @Column(name = "nr_cep", length = 8, nullable = false)
    private String cep;
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cidade")
    private Cidade cidade;

    public Logradouro() {
    }

    public Logradouro(String idLogradouro, String cep, Cidade cidade) {
        this.idLogradouro = idLogradouro;
        this.cep = cep;
        this.cidade = cidade;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
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

}
