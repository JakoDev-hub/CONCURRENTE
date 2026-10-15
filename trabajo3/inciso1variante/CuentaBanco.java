package trabajo3.inciso1variante;

public class CuentaBanco {
    private int balance;

    public CuentaBanco(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return this.balance;
    }

    public boolean hacerRetiro(int cantidad)
            throws InterruptedException {
        boolean puedeRetirar = this.balance >= cantidad;
        if (puedeRetirar) {
            System.out.println(Thread.currentThread().getName() +
                    " está realizando un retiro de: " + cantidad);
            Thread.sleep(1000);
            this.balance -= cantidad;
            System.out.println(Thread.currentThread().getName() +
                    ": Retiro realizado");
            System.out.println(Thread.currentThread().getName() +
                    ": Los fondos son de: " + this.balance);
        } else {
            System.out.println("No hay suficiente dinero en la cuenta"
                    + " para realizar el retiro Sr. "
                    + Thread.currentThread().getName());
            System.out.println("Su saldo actual es de: "
                    + this.balance);
            Thread.sleep(1000);

        }
        return puedeRetirar;

    }

}
