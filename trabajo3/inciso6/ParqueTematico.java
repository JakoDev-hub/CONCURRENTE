package trabajo3.inciso6;

public class ParqueTematico {
    private final String[] nombresAreas;
    private final int[] cuposDisponibles;
    private int contadorComprobante = 1000;

    public ParqueTematico(String[] nombresAreas, int[] cuposIniciales) {
        this.nombresAreas = nombresAreas;
        this.cuposDisponibles = cuposIniciales;
    }

    public int getCantidadAreas() {
        return nombresAreas.length;
    }

    // Método atómico y sincronizado: verifica y reserva en una sola operación
    public synchronized boolean reservarLugar(int idArea, String visitante) {
        boolean exito = false;

        if (idArea >= 0 && idArea < cuposDisponibles.length) {
            // Sección crítica: verificación y modificación atómica
            if (cuposDisponibles[idArea] > 0) {
                cuposDisponibles[idArea]--; // Descuenta el cupo
                contadorComprobante++;
                
                System.out.println("✅ RESERVA EXITOSA | " + visitante 
                        + " reservó en [" + nombresAreas[idArea] 
                        + "] | Lugares restantes: " + cuposDisponibles[idArea] 
                        + " | Comprobante N°: PRK-" + contadorComprobante);
                
                exito = true;
            } else {
                System.out.println("❌ RESERVA RECHAZADA | " + visitante 
                        + " intentó reservar en [" + nombresAreas[idArea] 
                        + "] pero NO hay lugares disponibles.");
            }
        }
        return exito;
    }

    public synchronized void mostrarEstadoParque() {
        System.out.println("\n===== ESTADO FINAL DE OCUPACIÓN DEL PARQUE =====");
        for (int i = 0; i < nombresAreas.length; i++) {
            System.out.println("Área: " + nombresAreas[i] + " -> Cupos restantes: " + cuposDisponibles[i]);
        }
        System.out.println("===============================================\n");
    }
}

