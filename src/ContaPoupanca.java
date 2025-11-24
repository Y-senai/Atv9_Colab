package src;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(int numero, String titular, double saldo) {
        super(numero, titular, saldo);
    }

    public void sacar(double valor) {
        if (valor > getSaldo()) {
            System.out.println("Saldo insuficiente");
        }
        this.saldo -= valor;
    }
}
