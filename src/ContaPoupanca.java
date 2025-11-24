package src;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(int numero, String titular, double saldo) {
        super(numero, titular, saldo);
    }

    // também vai ter que botar o SaldoInsuficienteException aqui.
    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido");
            return;
        }
        if (valor > getSaldo()) {
            System.out.println("Saldo insuficiente");
        }
        this.saldo -= valor;
    }
}
