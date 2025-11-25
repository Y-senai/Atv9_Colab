package src;

public class ContaCorrente extends Conta {

    private double limiteChequeEspecial;

    public ContaCorrente(
        String numero,
        String titular,
        double saldo,
        double limiteChequeEspecial
    ) {
        super(numero, titular, saldo);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    // sujeito a mudança.  ----  vai ter que botar o SaldoInsuficienteException e também poderia mostrar o saldo inicial + o saldo real pro usuário,
    // mas isso poderia ser em um decorador ou em outra função
    public void sacar(double valor) {
        if (this.transacoes == null) {
            System.out.println("Transações não inicializadas");
            return;
        }

        if (this.qtdTransacoes == this.tamanhoTrans) {
            System.out.println("Limite de transações atingido");
            return;
        }

        if (valor <= 0) {
            System.out.println("Valor inválido");
            return;
        }
        if (valor > (getSaldo() + limiteChequeEspecial)) {
            System.out.println("Saldo insuficiente");
            return;
        }
        this.saldo -= valor;

        if (valor > 0) {
            this.transacoes[qtdTransacoes] = new Transacao("Saque", valor);
            this.qtdTransacoes++;
        }
    }
}
