package trabajo0.musicaEinstrumentos;
class Guitarra extends Instrumento {
    public void tocar() {
        System.out.println("Guitarra.tocar()");
    }

    public String tipo() {
        return "Guitarra";
    }

    public void afinar() {
    }
}