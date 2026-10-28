package trabajo3.inciso3;

public class Plato {
    public synchronized void comer(String nombre) {
        System.out.println("hamster " + nombre + " EMPIEZA a comer del plato.");
        try {
            
            Thread.sleep(1000); // Simula el tiempo de comer de 1 segundo

            System.out.println("hamster " + nombre + " está comiendo del plato.");
            
        } catch (InterruptedException e) {// Manejo de la interrupción si el hilo es interrumpido por otro hilo mientras duerme

            Thread.currentThread().interrupt(); // aca el hilo se interrumpe y se sale del metodo
        }
        System.out.println( nombre + " TERMINÓ de comer."); //sin interrupciones, el hamster termina de comer y se sale del metodo
    }
}