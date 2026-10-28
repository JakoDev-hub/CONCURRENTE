package trabajo3.inciso3;

public class Hamaca {
    public synchronized void descansar(String nombre) {// esta es la seccion critica, solo un hamster puede usar la hamaca a la vez

        System.out.println("😴 " + nombre + " EMPIEZA a descansar en la hamaca.");

        try {
            Thread.sleep(2000);// Simula el tiempo de descanso de 2 segundos

        } catch (InterruptedException e) { // Manejo de la interrupción si el hilo es interrumpido por otro hilo mientras duerme

            Thread.currentThread().interrupt();// aca el hilo se interrumpe y se sale del metodo
        }
        System.out.println( nombre + " TERMINÓ de descansar.");
    }
}
