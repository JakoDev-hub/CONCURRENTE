package trabajo4.EjemploDeSemaforo;

import java.util.concurrent.Semaphore;

/**
 * ContadorSemaforo
 */
public class ContadorSemaforo {
    private int contador = 0;
    // Semáforo binario inicializado en 1 (1 permiso disponible)
    private final Semaphore mutex = new Semaphore(1);

    public void incrementar(String nombreHilo) {
        try {
            // Solicita el permiso. Si está ocupado (0), el hilo se bloquea.
            mutex.acquire();

            // --- INICIO DE SECCIÓN CRÍTICA ---
            int temp = contador;// este valor es incializado en 0, y se incrementa en 1 cada vez que un hilo entra a la sección crítica
            System.out.println("🟢 " + nombreHilo + " ingresó a la sección crítica. Valor actual: " + temp);
            // ademas el hilo no resetea el valor del contador, sino que lo incrementa en 1 cada vez que entra a la sección crítica
            
            // Simula un procesamiento dentro de la sección crítica
            Thread.sleep(10000); 
            contador = temp + 1;
            
            System.out.println("✏️ " + nombreHilo + " incrementó el contador a: " + contador);
            // --- FIN DE SECCIÓN CRÍTICA ---

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            // Garantiza que el permiso siempre se devuelva al semáforo
            mutex.release();
            System.out.println("🔴 " + nombreHilo + " liberó el semáforo.\n");
        }
    }

    public int getContador() {
        return contador;
    }
}
    