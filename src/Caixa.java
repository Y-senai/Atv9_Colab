package src;

class Caixa {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        ContaPoupanca conta1 = new ContaPoupanca(1000, "Joao", 0);
        conta1.depositar(-500);
        conta1.depositar(500);

        conta1.depositar(500);

        conta1.depositar(500);

        conta1.sacar(200);
        System.out.println("Saldo da conta1: " + conta1.getSaldo());
        conta1.mostrarTransacoes();
    }
}
