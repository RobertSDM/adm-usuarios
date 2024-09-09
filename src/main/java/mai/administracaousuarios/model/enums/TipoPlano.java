package mai.administracaousuarios.model.enums;

public enum TipoPlano {
    BASICO("BASICO"),
    PREMIUM("PREMIUM");

    private String tipo;
    TipoPlano(String tipo) {
        this.tipo = tipo;
    }
    public String getTipo() {
        return tipo;
    }
}
