package trabajo3.inciso3;

public class jaula {
    private Object comedero = false;
    private Object amaca = false;
    private Object rueda = false;

    public jaula(Object come, Object entrena, Object descanza) {
        this.comedero = come;
        this.amaca = descanza;
        this.rueda = entrena;
    }

    public synchronized void amacaBlock(Object resul) {
        amaca = resul;
    }

    public  synchronized void comederoBlock(Object resul){
        comedero = resul;
    }
    public synchronized void ruedaBLock(Object resul){
        rueda = resul;
    } 

}
    