package trabajo3.inciso3;

public class MainHamsters {
    public static void main(String[] args) {
        // Se instancian los recursos compartidos únicos
        Plato platoCompartido = new Plato();
        Rueda ruedaCompartida = new Rueda();
        Hamaca hamacaCompartida = new Hamaca();

        // Se crean varios hámsters compartiendo los mismos recursos

        int cantidadHamsters = 4;

        for (int i = 1; i <= cantidadHamsters; i++) {// aca se crea un bucle para crear varios hámsters, cada uno con un nombre único y compartiendo los mismos recursos (plato, rueda y hamaca)
            Hamster h = new Hamster("Hámster-" + i, platoCompartido, ruedaCompartida, hamacaCompartida);

            Thread hilo = new Thread(h);// Se crea un hilo para cada hámster, pasando la instancia del hámster al constructor del hilo

            hilo.start();// Se inicia la ejecución del hilo, lo que provoca que el método run() del hámster se ejecute en paralelo con otros hilos
        }
    }
}

