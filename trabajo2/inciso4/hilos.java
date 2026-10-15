package trabajo2.inciso4;

public class hilos implements Runnable {
    private String nombre;

    public hilos(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        System.out.println("\nHilo " + nombre + " iniciando.");
        
        for (int i = 0; i < 10; i++) { // Se ejecuta 10 veces imprimiendo el nombre
            System.out.println("Hilo secundario: " + nombre + " (iteración " + (i + 1) + ")");
            try {
                Thread.sleep(100); // Pausa de 100ms dentro del bucle para dar tiempo al otro hilo
            } catch (InterruptedException exc) {
                System.out.println("Hilo " + nombre + " interrumpido");
            }
        }
        
        System.out.println("Hilo " + nombre + " finalizado.");
    }
}