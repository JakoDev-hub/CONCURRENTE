package trabajo3.inciso2;

// Hilo 2: Criatura Oscura (-3 de energía)
public class CriaturaRunnable implements Runnable {
    private Energia energia;
    private int habilidad = 3;

    public CriaturaRunnable(Energia energia) {
        this.energia = energia;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            energia.modificarEnergia(-habilidad);
            System.out.println("Criatura drenó -3. Energía actual: " + energia.getCantidad());
        }
    }
}
