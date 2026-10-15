package trabajo2.inciso4;

public class mainejemplo {
    public static void main(String[] args) {
        System.out.println("Hilo principal iniciando.");

        hilos hc = new hilos("maria");
        Thread nuevoHilo = new Thread(hc);

        nuevoHilo.start(); // Inicia la ejecución concurrente

        for (int i = 0; i < 10; i++) {
            System.out.println("Hilo principal en ejecución... " + (i + 1));
            try {
                Thread.sleep(100); // Pausa dentro del bucle del hilo principal
            } catch (InterruptedException exc) {
                System.out.println("Hilo principal interrumpido");
            }
        }

        try {
            nuevoHilo.join(); // Espera a que el hilo secundario finalice antes de terminar main
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Hilo principal finalizado.");
    }
}