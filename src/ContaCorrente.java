package src;

public class ContaCorrente extends Conta {

    private double limiteChequeEspecial;

    public ContaCorrente(
        int numero,
        String titular,
        double saldo,
        double limiteChequeEspecial
    ) {
        super(numero, titular, saldo);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    public void sacar(double valor) {
        if (valor > getSaldo()) {
            System.out.println("Saldo insuficiente");
        }
    }
}
