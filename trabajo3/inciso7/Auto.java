package trabajo3.inciso7;
public class Auto implements Runnable {
    private String patente;
    private String modelo;
    private String marca;
    private double kmRecorridos;
    private double combustibleTanque; // Capacidad máxima del tanque del auto
    private Surtidor surtidor;

    public Auto(String patente, String modelo, String marca, Surtidor surtidor) {
        this.patente = patente;
        this.modelo = modelo;
        this.marca = marca;
        this.kmRecorridos = 0;
        this.combustibleTanque = 40.0; // Tanque lleno de 40L
        this.surtidor = surtidor;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) { // Realiza 3 viajes
            // 1. Simula andar y consumir combustible
            try {
                System.out.println("🚗 Auto " + patente + " (" + marca + " " + modelo + ") recorriendo la ciudad...");
                Thread.sleep((long) (Math.random() * 1500 + 500));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            kmRecorridos += 150;
            System.out.println("🔴 Auto " + patente + " llegó a la reserva (Km recorridos: " + kmRecorridos + "). Va a cargar combustible.");

            // 2. Intenta cargar el tanque completo en el surtidor
            boolean cargo = surtidor.cargarCombustible(patente, combustibleTanque);
            if (!cargo) {
                System.out.println("❌ Auto " + patente + " se queda esperando o buscando otra estación.");
                break;
            }
        }
        System.out.println("🏁 Auto " + patente + " finalizó su recorrido.");
    }
}