package src;

abstract class Conta {

    protected String numero;
    protected String titular;
    protected double saldo;
    protected Transacao[] transacoes;

    //  ter um limite de transações registraveis é uma anomalia mas não sei se é facil implementar um array dinamico em java
    protected int tamanhoTrans = 100;

    protected int qtdTransacoes;

    public Conta(String numero, String titular, double saldo) {
        if (saldo < 0) {
            throw new IllegalArgumentException("Saldo não pode ser negativo");
        }
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
        this.transacoes = new Transacao[tamanhoTrans];
        this.qtdTransacoes = 0;
    }

    public String getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void depositar(double valor) {
        ////// Verificações //////

        if (this.transacoes == null) {
            System.out.println("Transações não inicializadas");
            return;
        }

        if (this.qtdTransacoes == this.tamanhoTrans) {
            System.out.println("Limite de transações atingido");
            return;
        }

        if (valor < 0) {
            System.out.println("Valor não pode ser negativo");
            return;
        }

        ///// Execução //////

        this.saldo += valor;

        if (valor > 0) {
            this.transacoes[qtdTransacoes] = new Transacao("Depósito", valor);
            this.qtdTransacoes++;
        }
    }

    abstract void sacar(double valor);

    public void mostrarTransacoes() {
        for (int i = 0; i < qtdTransacoes; i++) {
            System.out.print("Transação " + (i + 1) + ": ");
            transacoes[i].imprimirTransacao();
        }
    }
}
