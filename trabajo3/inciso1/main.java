package trabajo3.inciso1;

public class main {
        public static void main(String[] args) {
            CuentaBanco cb = new CuentaBanco(50);
            VerificarCuenta vcL = new VerificarCuenta(cb);
            VerificarCuenta vcJ = new VerificarCuenta(cb);
            Thread lucas = new Thread(vcL, "Lucas");
            Thread jere = new Thread(vcJ, "Jere");
            lucas.start();
            jere.start();
        }
    }
