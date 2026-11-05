package trabajo4.inciso1;

public class ContadorObjetosSincronico {

    private int valor = 0;

    public void incrementar() {// el metodo incrementar es sincronizado, lo que significa que solo un hilo puede acceder 
    // a él a la vez, evitando condiciones de carrera y garantizando la consistencia del valor del contador
        synchronized ((Integer) valor) {
            valor++;
        }
    }

    public void decrementar() {// el metodo decrementar es sincronizado, lo que significa que solo un hilo puede acceder a él a la vez, 
    // evitando condiciones de carrera y garantizando la consistencia del valor del contador
        synchronized (this) {
            // especificamos que el objeto a sincronizar es el mismo objeto que contiene el valor del contador,
            // lo que garantiza que solo un hilo puede acceder a la sección crítica a la vez,
            // evitando condiciones de carrera y garantizando la consistencia del valor del contador.
            valor--;
        }
    }


    public synchronized int getValor() {
        return valor;
    }


    /*en este caso el sistema se encarga de sincronizar el acceso al objeto y sin generar problemas
    de concurrencia */
}
