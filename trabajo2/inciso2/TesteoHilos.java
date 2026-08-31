package trabajo2.inciso2;

public class TesteoHilos {
    public static void main(String[] args) {
        Thread miHilo = new Hilo();
        miHilo.start();

        System.out.println("En el main");
    }
}
