package trabajo4.inciso3;

import trabajo4.inciso3.Compa;

public class MainSemaforo {

    public static void main(String[] args) {

        Thread hilo1 = new Thread(new Compa("Hilo 1", 0));
        Thread hilo2 = new Thread(new Compa("Hilo 2", 1));
        Thread hilo3 = new Thread(new Compa("Hilo 3", 1));
        hilo1.start();
        hilo2.start();
        hilo3.start();

    }
}