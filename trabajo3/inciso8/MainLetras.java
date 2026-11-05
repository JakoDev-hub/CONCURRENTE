package trabajo3.inciso8;


    public class MainLetras {
    public static void main(String[] args) {
        ControladorTurnos controlador = new ControladorTurnos();
        int ciclos = 5; // Imprimirá la secuencia completa ABBCCC 5 veces

        // Configuración de los turnos:
        // Hilo A: Turno 1, imprime 'A' 1 vez, pasa al Turno 2
        Thread hiloA = new Thread(new HiloLetra('A', 1, 1, 2, ciclos, controlador), "Hilo-A");

        // Hilo B: Turno 2, imprime 'B' 2 veces, pasa al Turno 3
        Thread hiloB = new Thread(new HiloLetra('B', 2, 2, 3, ciclos, controlador), "Hilo-B");

        // Hilo C: Turno 3, imprime 'C' 3 veces, vuelve al Turno 1
        Thread hiloC = new Thread(new HiloLetra('C', 3, 3, 1, ciclos, controlador), "Hilo-C");

        System.out.println("🔤 Secuencia generada:");
        hiloA.start();
        hiloB.start();
        hiloC.start();
    }
}

