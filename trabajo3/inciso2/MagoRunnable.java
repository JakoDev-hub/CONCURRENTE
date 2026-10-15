package trabajo3.inciso2;

// Hilo 1: Sanador / Mago (+3 de energía)
public class MagoRunnable implements Runnable {
    private Energia energia;
    private int habilidad = 3;

    public MagoRunnable(Energia energia) {
        this.energia = energia;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            energia.modificarEnergia(habilidad);
            System.out.println("Mago revitalizó +3. Energía actual: " + energia.getCantidad());
        }
    }
}