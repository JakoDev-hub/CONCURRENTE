package trabajo0.AlquilerDeEspaciosParaAviones;

import java.util.Date;

public class Avion {
    private String matricula;
    private int envergadura;
    private Date fechaFabricacion;

    public int calcularValor() {
        return envergadura * 20;
    }

    public String ArrancarMotor() {
        return "Arrancando motor";
    }

    public String ApagarMotor() {
        return "Apagando motor";

    }

    public int getEnvergadura() {
        return envergadura;
    }

    public int calculoAlquiler() {
        return envergadura * 20;
    }
}
