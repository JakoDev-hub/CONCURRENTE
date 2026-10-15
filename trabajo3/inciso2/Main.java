package trabajo3.inciso2;

public class Main {
    public static void main(String[] args) {
        // Recurso compartido
        Energia energiaCompartida = new Energia();

        // Se crean las tareas pasando el mismo recurso compartido
        MagoRunnable mago = new MagoRunnable(energiaCompartida);
        CriaturaRunnable criatura = new CriaturaRunnable(energiaCompartida);

        // Se crean y lanzan los hilos concurrentes
        Thread hiloMago = new Thread(mago, "Sanador");
        Thread hiloCriatura = new Thread(criatura, "CriaturaOscura");

        hiloMago.start();
        hiloCriatura.start();
    }
}