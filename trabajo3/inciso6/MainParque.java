package trabajo3.inciso6;

public class MainParque {
     public static void main(String[] args) {
        // Áreas del parque y capacidad máxima de vacantes por área
        String[] areas = {"Montaña Rusa Spook", "Zona de Juegos Acuáticos", "Espectáculo de Magia", "Safari Virtual"};
        int[] cupos = {3, 2, 4, 2}; // Número limitado de espacios

        ParqueTematico parque = new ParqueTematico(areas, cupos);

        int totalVisitantes = 15; // Más visitantes que cupos para probar la resistencia
        Thread[] hilosVisitantes = new Thread[totalVisitantes];

        System.out.println("🚀 INICIANDO SISTEMA DE RESERVAS DEL PARQUE TEMÁTICO...\n");

        for (int i = 0; i < totalVisitantes; i++) {
            VisitanteRunnable tarea = new VisitanteRunnable("Visitante-" + (i + 1), parque);
            hilosVisitantes[i] = new Thread(tarea);
            hilosVisitantes[i].start();
        }

        // Se aguarda la finalización de todas las solicitudes de reserva
        for (int i = 0; i < totalVisitantes; i++) {
            try {
                hilosVisitantes[i].join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Muestra el balance final de lugares en el parque
        parque.mostrarEstadoParque();
    }
}

