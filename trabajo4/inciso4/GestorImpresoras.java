package trabajo4.inciso4;

import java.util.concurrent.Semaphore;

public class GestorImpresoras {
    // true = libre, false = ocupada
    private final boolean[] impresoras;
    
    // Semáforo con K permisos: representa cuántas impresoras libres hay en total
    private final Semaphore semImpresorasDisponibles;
    
    // Semáforo binario (mutex = 1): protege la búsqueda en el arreglo de impresoras
    private final Semaphore mutex;

    public GestorImpresoras(int cantidadImpresoras) {
        this.impresoras = new boolean[cantidadImpresoras];
        for (int i = 0; i < cantidadImpresoras; i++) {
            this.impresoras[i] = true; // Todas arrancan disponibles
        }
        this.semImpresorasDisponibles = new Semaphore(cantidadImpresoras, true); // true para FIFO
        this.mutex = new Semaphore(1);
    }

    // Solicita una impresora libre (bloqueante si están todas ocupadas)
    public int solicitarImpresora(String cliente) throws InterruptedException {
        // 1. Espera a que haya al menos una impresora libre
        semImpresorasDisponibles.acquire();

        // 2. Entra en exclusión mutua para buscar cuál es la impresora que está libre
        mutex.acquire();
        int idImpresoraAsignada = -1;
        try {
            for (int i = 0; i < impresoras.length; i++) {
                if (impresoras[i]) {
                    impresoras[i] = false; // La marca como ocupada
                    idImpresoraAsignada = i;
                    break;
                }
            }
            System.out.println("🖨️ " + cliente + " tomó la Impresora #" + idImpresoraAsignada);
        } finally {
            // Siempre se libera el mutex
            mutex.release();
        }

        return idImpresoraAsignada;
    }

    // Libera la impresora utilizada
    public void liberarImpresora(int idImpresora, String cliente) throws InterruptedException {
        // 1. Entra en exclusión mutua para marcar la impresora como libre
        mutex.acquire();
        try {
            impresoras[idImpresora] = true;
            System.out.println("✅ " + cliente + " LIBERÓ la Impresora #" + idImpresora);
        } finally {
            mutex.release();
        }

        // 2. Devuelve un permiso al semáforo general para despertar a un cliente en espera
        semImpresorasDisponibles.release();
    }
}

