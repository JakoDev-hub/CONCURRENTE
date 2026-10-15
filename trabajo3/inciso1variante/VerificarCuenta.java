package trabajo3.inciso1variante;

import java.util.logging.Level;
import java.util.logging.Logger;

public class VerificarCuenta implements Runnable {
    private CuentaBanco cb;

    public VerificarCuenta(CuentaBanco unaCuenta) {
        this.cb = unaCuenta;
    }

    public void run() {
        for (int i = 0; i <= 3; i++) {
            try {
                if (!cb.hacerRetiro(10)) {

                    System.out.println("Cuenta está sobregirada");
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(VerificarCuenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}