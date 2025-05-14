package fiap.tds.models;

public enum TypeEvent {
    CONFLITO_ENTRE_PASSAGEIROS("Segurança"),
    FUSIVEL_QUEBRADO("Técnico Manutenção"),
    ESCADA_ROLANTE_QUEBRADA("Técnico Manutenção"),
    PORTA_DE_EMERGENCIA_QUEBRADA("Técnico Manutenção"),
    VIDRO_QUEBRADO("Limpeza"),
    LIXEIRA_VAZANDO("Limpeza");


    private final String cargoResponsavel;

    TypeEvent(String cargoResponsavel) {
        this.cargoResponsavel = cargoResponsavel;
    }

    public String getCargoResponsavel() {
        return cargoResponsavel;
    }


}
