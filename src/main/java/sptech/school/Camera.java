package sptech.school;

public class Camera {

    private Integer identificador;
    private String agencia;
    private Boolean ativa;
    private String cenario = """
            |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
            | REC º                           |
            |                                 |
            |                                 |
            |                                 |
            |                                 |
            |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
            """;

    public Camera(Integer identificador, String agencia, Boolean ativa) {
        this.identificador = identificador;
        this.agencia = agencia;
        this.ativa = ativa;
    }
    public Integer getIdentificador() {
        return identificador;
    }
    public String getAgencia() {
        return agencia;
    }
    public Boolean getAtiva() {
        return ativa;
    }
    public void setAtiva(Boolean ativa){
        this.ativa = ativa;
    }
    public String getCenario() {
        return cenario;
    }
    public void setCenario(String cenario){
        this.cenario = cenario;
    }
}
