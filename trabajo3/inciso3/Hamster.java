package trabajo3.inciso3;

import java.util.Random;

/**
 * Hamster
 */
public class Hamster implements Runnable { // Implementa la interfaz Runnable para permitir que los hámsters se ejecuten en hilos separados
    private String nombre;
    private Plato plato;
    private Rueda rueda;
    private Hamaca hamaca;

    public Hamster(String nom, Plato pla, Rueda laRueda, Hamaca unaHamaca) {// declaración del constructor de la clase Hamster, que recibe el nombre del hámster, el plato, la rueda y la hamaca como parámetros
        this.nombre = nom;
        this.plato = pla;
        this.rueda = laRueda;
        this.hamaca = unaHamaca;
    }

    @Override
    public void run() { // Implementación del método run() de la interfaz Runnable, que define el comportamiento del hámster cuando se ejecuta en un hilo separado

        System.out.println("--- Hámster " + nombre + " ingresa a la jaula ---");

        // El hámster realiza las tres actividades
        plato.comer(nombre);
        rueda.rodar(nombre);
        hamaca.descansar(nombre);

        System.out.println("=== Hámster " + nombre + " completó todas sus actividades ===");
    }
}
