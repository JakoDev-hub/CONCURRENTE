package trabajo2.iniciso7;

public class CompraCliente {
    private String nombre;
    private int[] productos;

    public CompraCliente(String nombre, int[] productos) {
        this.nombre = nombre;
        this.productos = productos;
    }

    public String getNombre() {
        return nombre;
    }

    public int[] getProductos() {
        return productos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setProductos(int[] productos) {
        this.productos = productos;
    }

}