package trabajo3.inciso5;

public class main {

public static void main(String[] args) {
        final int TAMANIO = 50000;
        final int K_HILOS = 5; // Cantidad de hilos trabajadores

        // 1. Se crea el recurso compartido (arreglo de 50.000 elementos)
        RecursoArreglo recurso = new RecursoArreglo(TAMANIO);

        // Opcional: Verificación secuencial para comprobar la exactitud del resultado
        long sumaSecuencialVerificacion = 0;
        for (int i = 0; i < TAMANIO; i++) {
            sumaSecuencialVerificacion += recurso.getElemento(i);
        }

        Thread[] hilos = new Thread[K_HILOS];
        int tamanioSegmento = TAMANIO / K_HILOS;

        // 2. Se dividen los rangos y se crean los k hilos
        for (int i = 0; i < K_HILOS; i++) {
            int inicio = i * tamanioSegmento;
            // El último hilo absorbe cualquier residuo si el tamaño no fuera divisible exactamente
            int fin = (i == K_HILOS - 1) ? TAMANIO : inicio + tamanioSegmento;

            SumadorRunnable tarea = new SumadorRunnable(recurso, inicio, fin, i + 1);
            hilos[i] = new Thread(tarea);
        }

        long tiempoInicio = System.currentTimeMillis();

        // 3. Se inician todos los hilos
        for (int i = 0; i < K_HILOS; i++) {
            hilos[i].start();
        }

        // 4. El hilo principal espera a que todos los hilos completen su labor
        for (int i = 0; i < K_HILOS; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        long tiempoFin = System.currentTimeMillis();

        // 5. Muestra el resultado final
        System.out.println("\n==========================================");
        System.out.println("Suma total concurrente: " + recurso.getSumaTotal());
        System.out.println("Suma de verificación : " + sumaSecuencialVerificacion);
        System.out.println("Tiempo de procesamiento : " + (tiempoFin - tiempoInicio) + " ms");
        System.out.println("==========================================");
    }
}



