package trabajoUno.AlquilerDeEspaciosParaAviones;

import java.util.Date;

public class Avion {
    private  String matricula;
    private int envergadura;
    private Date fechaFabricacion;

        public int calcularValor(){
           return envergadura*20;
    }
}
