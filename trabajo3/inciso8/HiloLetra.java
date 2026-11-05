package trabajo3.inciso8;


public class HiloLetra implements Runnable {
    private char letra;
    private int miTurno;
    private int repeticionesEnTurno;
    private int siguienteTurno;
    private int ciclosTotales;
    private ControladorTurnos controlador;

    public HiloLetra(char letra, int miTurno, int repeticionesEnTurno, int siguienteTurno, int ciclosTotales, ControladorTurnos controlador) {
        this.letra = letra;
        this.miTurno = miTurno;
        this.repeticionesEnTurno = repeticionesEnTurno;
        this.siguienteTurno = siguienteTurno;
        this.ciclosTotales = ciclosTotales;
        this.controlador = controlador;
    }

    @Override
    public void run() {
        // Ejecuta la secuencia la cantidad de ciclos especificados
        for (int i = 0; i < ciclosTotales; i++) {
            for (int r = 0; r < repeticionesEnTurno; r++) {
                controlador.imprimir(letra, miTurno, repeticionesEnTurno, siguienteTurno);
            }
        }
    }
}