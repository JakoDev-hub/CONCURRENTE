package trabajo3.inciso4;


    public class Trabajador implements Runnable {

    private String nombre;
    private CajaHerramientas caja;
    private int[] misHerramientas;

    public Trabajador(String nombre, CajaHerramientas caja, int[] herramientasPermitidas) {
        this.nombre = nombre;
        this.caja = caja;
        this.misHerramientas = herramientasPermitidas;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) { // Cada trabajador realiza 3 labores
            // Selecciona aleatoriamente una de las herramientas que sabe usar
            int herramienta = misHerramientas[(int) (Math.random() * misHerramientas.length)];

            // 1. Toma la herramienta de la caja
            caja.tomarHerramienta(herramienta, nombre);

            // 2. Trabaja con la herramienta durante un lapso de tiempo
            try {
                System.out.println("🔨 " + nombre + " está trabajando...");
                Thread.sleep((long) (Math.random() * 1500 + 500));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            // 3. Devuelve la herramienta a la caja
            caja.devolverHerramienta(herramienta, nombre);

            // Pausa breve antes de la siguiente labor
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("el trabajador " + nombre + " completó su jornada.");
    }
}

