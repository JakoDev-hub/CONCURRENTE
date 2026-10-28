package trabajo3.inciso7;

public class Surtidor {
        private double capacidadMaxima;
    private double litrosActuales;

    public Surtidor(double capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.litrosActuales = capacidadMaxima;
    }

    // Método sincronizado para evitar que dos autos carguen al mismo tiempo
    public synchronized boolean cargarCombustible(String patente, double litrosDeseados) {
        boolean exito = false;

        if (litrosActuales >= litrosDeseados) {
            litrosActuales -= litrosDeseados;
            System.out.println("⛽ [SURTIDOR] Auto " + patente + " cargó " + litrosDeseados 
                    + "L. | Litros restantes en el surtidor: " + String.format("%.2f", litrosActuales) + "L / " + capacidadMaxima + "L");
            exito = true;
        } else {
            System.out.println("⚠️ [SURTIDOR] Auto " + patente + " intentó cargar " + litrosDeseados 
                    + "L pero NO hay suficiente combustible. Disponible: " + String.format("%.2f", litrosActuales) + "L");
        }

        return exito;
    }

    public synchronized double getLitrosActuales() {
        return litrosActuales;
    }
}
