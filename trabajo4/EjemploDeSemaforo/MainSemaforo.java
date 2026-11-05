package trabajo4.EjemploDeSemaforo;

/**
 * MainSemaforo
 */
public class MainSemaforo {

    public static void main(String[] args) {
        ContadorSemaforo contador = new ContadorSemaforo();

        // Se crean 3 hilos competidores
        Thread h1 = new Thread(new trabajo4.EjemploDeSemaforo.Trabajador("Hilo-1", contador));
        Thread h2 = new Thread(new trabajo4.EjemploDeSemaforo.Trabajador("Hilo-2", contador));
        Thread h3 = new Thread(new trabajo4.EjemploDeSemaforo.Trabajador("Hilo-3", contador));

        h1.start();
        h2.start();
        h3.start();

        try {
            h1.join();
            h2.join();
            h3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("=== VALOR FINAL DEL CONTADOR: " + contador.getContador() + " ===");
    }
}
