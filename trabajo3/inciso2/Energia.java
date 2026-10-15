package trabajo3.inciso2;

public class Energia {
    private int cantidad = 10;

    public synchronized int getCantidad() {
        return cantidad;
    }

    // Método sincronizado para garantizar exclusión mutua
    public synchronized void modificarEnergia(int valor) {
        int actual = this.cantidad;
        actual = actual + valor;
        this.cantidad = actual;
    }

    
}