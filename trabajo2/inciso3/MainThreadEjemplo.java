package trabajo2.inciso3;

public class MainThreadEjemplo {
    public static void main(String[] args) {
        new ThreadEjemplo("Maria Jose").start();
        new ThreadEjemplo("Jose Maria").start();

        System.out.println("Termina thread main");
    }
}