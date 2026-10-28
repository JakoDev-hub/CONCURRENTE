package trabajo3.inciso3;

public class Rueda {
    public synchronized void rodar(String nombre) { // esta es la seccion critica, solo un hamster puede usar la rueda a la vez
        System.out.println("hamster" + nombre + " EMPIEZA a correr en la rueda.");
        try {
            Thread.sleep(3000); // Simula el tiempo de correr en la rueda de 3 segundos
            System.out.println("hamster " + nombre + " está corriendo en la rueda.");
            
        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();// aca el hilo se interrumpe y se sale del metodo
        }
        System.out.println( nombre + " TERMINÓ de correr.");
    }
}