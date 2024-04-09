package maia.administracaousuarios;

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

    public Cidade() {
    }

    public Cidade(String idCidade, String nome) {
        this.idCidade = idCidade;
        this.nome = nome;
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
