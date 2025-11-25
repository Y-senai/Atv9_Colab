package src;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(String numero, String titular, double saldo) {
        super(numero, titular, saldo);
    }

    // também vai ter que arrumar o SaldoInsuficienteException aqui.
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
        if (valor > getSaldo()) {
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
