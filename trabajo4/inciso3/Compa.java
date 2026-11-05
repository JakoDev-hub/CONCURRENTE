package trabajo4.inciso3;

import java.util.concurrent.Semaphore;

public class Compa implements Runnable {
    private String nombre;
    private int orden;

    private final Semaphore mutex = new Semaphore(1);

    public Compa(String nombre, int orden) {
        // Constructor que recibe el nombre del hilo
        this.nombre = nombre;
        this.orden = orden;
    }

    public void run() {

        try {
            if (orden == 1) {
                mutex.acquire();
                // Si es 1 el hilo se ejecuta , sino se bloquea hasta que el hilo 1 termine.
                System.out.println(nombre + " está ejecutando correctamente.");
            }
            
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();

        } finally {
            System.out.println(nombre + " ha terminado de ejecutar.");
            mutex.release();
        }
    }

}
