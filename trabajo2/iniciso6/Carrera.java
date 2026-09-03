package trabajo2.iniciso6;

public class Carrera {
    public static void main(String[] args) {

        Corredor corredor1 = new Corredor("Corredor1", 0);
        Corredor corredor2 = new Corredor("Corredor2", 0);

        Thread hilo1 = new Thread(corredor1);
        Thread hilo2 = new Thread(corredor2);

        hilo1.start();
        hilo2.start();

        try {
            hilo1.join();
            hilo2.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
