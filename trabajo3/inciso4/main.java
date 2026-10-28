package trabajo3.inciso4;

public class main {
     public static void main(String[] args) {
        CajaHerramientas caja = new CajaHerramientas();

        // Herramientas según el oficio:
        // Albañil: Cuchara, Nivel o Cinta métrica
        int[] herramientasAlbanil = {
            CajaHerramientas.CUCHARA,
            CajaHerramientas.NIVEL,
            CajaHerramientas.CINTA_METRICA
        };

        // Electricista: Buscapolos o Cinta métrica
        int[] herramientasElectricista = {
            CajaHerramientas.BUSCAPOLOS,
            CajaHerramientas.CINTA_METRICA
        };

        // Gasista: Llave de caño o Nivel
        int[] herramientasGasista = {
            CajaHerramientas.LLAVE_CANO,
            CajaHerramientas.NIVEL
        };

        // Instanciación de los 4 operarios
        Thread albanil1 = new Thread(new Trabajador("Albañil 1", caja, herramientasAlbanil));
        Thread albanil2 = new Thread(new Trabajador("Albañil 2", caja, herramientasAlbanil));
        Thread electricista = new Thread(new Trabajador("Electricista", caja, herramientasElectricista));
        Thread gasista = new Thread(new Trabajador("Gasista", caja, herramientasGasista));

        // Inicio de la ejecución concurrente
        albanil1.start();
        albanil2.start();
        electricista.start();
        gasista.start();
    }
}

