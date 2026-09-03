package trabajo2.iniciso6;

import java.util.concurrent.ThreadLocalRandom;

public class Corredor implements Runnable {

    private String nombre;
    private int distancia;

    public Corredor(String nombre, int distancia) {
        this.nombre = nombre;
        this.distancia = distancia;
    }

    @Override
    public void run() {
        int numeroDistancia = ThreadLocalRandom.current().nextInt(1, 11);
        distancia = distancia + numeroDistancia;
        // Implementation for the run method
    }

    public String getNombre() {
        return nombre;
    }

    public int getDistancia() {
        return distancia;
    }

    /*
     * realizado el paso debe descansar. Una vez alcanzado los 100 pasos, el
     * corredor termina.
     */
    public void Descansar() {
        try {
            if (distancia > 100) {

                Thread.sleep(1000); // Simulate rest for 1 second
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
