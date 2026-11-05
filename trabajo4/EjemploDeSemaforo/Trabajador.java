package trabajo4.EjemploDeSemaforo;

public class Trabajador implements Runnable {
    private final ContadorSemaforo contadorCompartido;
    private final String nombre;

    public Trabajador(String nombre, ContadorSemaforo contador) {
        this.nombre = nombre;
        this.contadorCompartido = contador;
    }

    public void run() {
        for (int i = 0; i < 2; i++) {
            contadorCompartido.incrementar(nombre);
            try {
                Thread.sleep(7500); // Pausa entre intentos
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}