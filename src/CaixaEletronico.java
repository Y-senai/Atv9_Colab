package src;

class CaixaEletronico {

    public static void main(String[] args) {
        Banco banco = new Banco();

        ContaPoupanca conta1 = new ContaPoupanca(1000, "Joao", 0);
        banco.adicionarConta(conta1.getTitular(), conta1);

        System.out.println(banco.buscarConta("Joao").getTitular());

        conta1.depositar(500);

        conta1.depositar(500);

        conta1.depositar(500);

        conta1.sacar(200);
        System.out.println("Saldo da conta1: " + conta1.getSaldo());
        conta1.mostrarTransacoes();
    }
}
