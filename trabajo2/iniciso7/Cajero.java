package trabajo2.iniciso7;

public class Cajero {
    private String nombre;

    public void procesarCompra(CompraCliente compraCliente, long timeStamp) {

        System.out.println("El cajero " + this.nombre + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " + compraCliente.getNombre() + " EN EL TIEMPO: " + (System.currentTimeMillis() - timeStamp) / 1000 + " seg");
        
        for (int i = 0; i < compraCliente.getProductos().length; i++) {

            this.esperarXsegundos(compraCliente.getProductos()[i]);
            
            System.out.println("Procesado el producto " + (i + 1)+ " -> Tiempo: "+ (System.currentTimeMillis() - timeStamp) / 1000 + " seg");
        }

        System.out.println("El cajero " + this.nombre + " HA TERMINADO DE PROCESAR " + compraCliente.getNombre() + " EN EL TIEMPO: "+ (System.currentTimeMillis() - timeStamp) / 1000 + " seg");
    }

    public Cajero(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void esperarXsegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}