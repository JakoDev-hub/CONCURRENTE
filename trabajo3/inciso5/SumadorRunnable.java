package trabajo3.inciso5;

public class SumadorRunnable implements Runnable {
    private final RecursoArreglo recurso;
    private final int inicio;
    private final int fin;
    private final int idHilo;

    public SumadorRunnable(RecursoArreglo recurso, int inicio, int fin, int idHilo) {
        this.recurso = recurso;
        this.inicio = inicio;
        this.fin = fin;
        this.idHilo = idHilo;
    }

    @Override
    public void run() {
        long sumaParcial = 0; // Suma local sin bloquear el recurso dentro del bucle
        for (int i = inicio; i < fin; i++) {
            sumaParcial += recurso.getElemento(i);
        }
        System.out.println("Hilo #" + idHilo + " sumó el rango [" + inicio + ", " + (fin - 1) + "] -&gt; Suma parcial: "
                + sumaParcial);
        // Se acumula la suma parcial de forma atómica en el recurso compartido
        // recurso.acumularSumaParcial(sumaParcial);
    }
}
