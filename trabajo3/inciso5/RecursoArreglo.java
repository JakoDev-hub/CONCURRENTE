package trabajo3.inciso5;

import java.util.Random;

public class RecursoArreglo {
    private final int[] arreglo;
    private long sumaTotal;

    public RecursoArreglo(int tamanio) {
        this.arreglo = new int[tamanio];
        this.sumaTotal = 0;
        this.llenarArreglo();
    }

    // Inciso a: Llena el arreglo con enteros aleatorios entre 1 y 10
    private void llenarArreglo() {
        Random random = new Random();
        for (int i = 0; i < arreglo.length; i++) {
            this.arreglo[i] = random.nextInt(10) + 1; // Genera valores de 1 a 10
        }
    }

    public int getElemento(int indice) {
        return this.arreglo[indice];
    }

    public int getTamanio() {
        return this.arreglo.length;
    }

    // Inciso d: Acumula la suma parcial de forma sincronizada
    public synchronized void acumularSumaParcial(long sumaParcial) {
        this.sumaTotal += sumaParcial;
    }

    public synchronized long getSumaTotal() {
        return this.sumaTotal;
    }
}
