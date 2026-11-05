package trabajo4.inciso1;

public class ContadorSincronico {
    private int valor = 0;

    // el metodo incrementar es sincronizado, lo que significa que solo un hilo
    // puede acceder a él a la vez, evitando condiciones de carrera y
    // garantizando la consistencia del valor del contador
    public synchronized void incrementar() {
        valor++;
    }

    public void decrementar() {
        valor--;
    }

    // el metodo getValor es sincronizado, lo que significa que solo un hilo puede
    // acceder a él a la vez, evitando condiciones de carrera y garantizando la
    // consistencia del valor del contador
    public synchronized int getValor() {
        return valor;
    }
}
