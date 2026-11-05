package trabajo3.inciso8;

public class ControladorTurnos {
    // 1 = Turno A, 2 = Turno B, 3 = Turno C
    private int turnoActual = 1;
    private int contadorImpresiones = 0;

    // Método genérico y sincronizado para coordinar la secuencia de impresión
    public synchronized void imprimir(char letra, int miTurno, int repeticionesRequeridas, int siguienteTurno) {
        // Espera guardada: mientras no sea su turno, se suspende
        while (this.turnoActual != miTurno) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Imprime el carácter correspondiente
        System.out.print(letra);
        contadorImpresiones++;

        // Si ya imprimió la cantidad de veces requerida en su turno, pasa el turno al siguiente
        if (contadorImpresiones == repeticionesRequeridas) {
            this.turnoActual = siguienteTurno;
            this.contadorImpresiones = 0; // Reinicia el contador para el nuevo turno
        }

        // Notifica a los demás hilos para que verifiquen si cambió el turno
        this.notifyAll();
    }
}

