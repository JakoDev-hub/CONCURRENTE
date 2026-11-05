package trabajo3.inciso7;

public class main {
        public static void main(String[] args) {
        // Surtidor con capacidad para 120 Litros
        Surtidor surtidor = new Surtidor(120.0);

        // Se crean 5 autos concurrentes (mínimo requerido)
        Thread auto1 = new Thread(new Auto("ABC-123", "Gol", "Volkswagen", surtidor));
        Thread auto2 = new Thread(new Auto("DEF-456", "Cronos", "Fiat", surtidor));
        Thread auto3 = new Thread(new Auto("GHI-789", "Onix", "Chevrolet", surtidor));
        Thread auto4 = new Thread(new Auto("JKL-012", "208", "Peugeot", surtidor));
        Thread auto5 = new Thread(new Auto("MNO-345", "Corolla", "Toyota", surtidor));

        auto1.start();
        auto2.start();
        auto3.start();
        auto4.start();
        auto5.start();
    }
}
