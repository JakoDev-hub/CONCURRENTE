
class Instrumento {
    public void tocar() {
        System.out.println("Instrumento.tocar()");
    }

    public String tipo() {
        return "Instrumento";
    }

    public void afinar() {
    }
}

// este modulo se encarga de que los instrumentos se afinen y toquen, donde son llamados por el modulo Musica
