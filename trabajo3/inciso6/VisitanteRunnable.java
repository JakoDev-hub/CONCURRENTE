package trabajo3.inciso6;
import java.util.Random;

public class VisitanteRunnable implements Runnable {
    private final String nombre;
    private final ParqueTematico parque;

    public VisitanteRunnable(String nombre, ParqueTematico parque) {
        this.nombre = nombre;
        this.parque = parque;
    }

    @Override
    public void run() {
        Random random = new Random();
        
        // El visitante simula la navegación y selecciona una ubicación al azar
        int areaElegida = random.nextInt(parque.getCantidadAreas());

        try {
            // Simula el tiempo que tarda en elegir y enviar la solicitud
            Thread.sleep((long) (Math.random() * 800 + 200));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Intenta realizar la reserva atómica en el sistema
        parque.reservarLugar(areaElegida, nombre);
    }
}
