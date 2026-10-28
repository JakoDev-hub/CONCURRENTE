package trabajo3.inciso4;

public class CajaHerramientas {
    
    // Constantes para identificar cada herramienta
    public static final int CUCHARA = 0;
    public static final int BUSCAPOLOS = 1;
    public static final int LLAVE_CANO = 2;
    public static final int NIVEL = 3;
    public static final int CINTA_METRICA = 4;

    private final String[] nombres = {
        "Cuchara de albañil", "Buscapolos", "Llave de caño", "Nivel", "Cinta métrica"
    };

    // true = disponible en la caja, false = en uso
    private final boolean[] disponibles = {true, true, true, true, true};

    // Método sincronizado para tomar una herramienta
    public synchronized void tomarHerramienta(int idHerramienta, String trabajador) {
        try {
            // Espera guardada: si la herramienta no está disponible, se suspende
            while (!disponibles[idHerramienta]) {
                System.out.println("⏳ " + trabajador + " espera por: " + nombres[idHerramienta]);
                this.wait();
            }
            // Toma la herramienta
            disponibles[idHerramienta] = false;
            System.out.println("🔧 " + trabajador + " TOMÓ la herramienta: " + nombres[idHerramienta]);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Método sincronizado para devolver la herramienta
    public synchronized void devolverHerramienta(int idHerramienta, String trabajador) {
        disponibles[idHerramienta] = true;
        System.out.println("✅ " + trabajador + " DEVOLVIÓ: " + nombres[idHerramienta]);
        // Se notifica a todos los trabajadores en espera para que reevalúen la condición
        this.notifyAll();
    }
}

