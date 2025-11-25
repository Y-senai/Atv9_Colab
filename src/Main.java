package src;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Banco banco = new Banco();
        CaixaEletronico ce = new CaixaEletronico();
        boolean contaRegistrada = false;
        String contaAtiva = String.valueOf(banco.qtdContas);

        ContaPoupanca contaTeste = new ContaPoupanca("0", "Cleiton", 0);
        banco.adicionarConta(contaTeste.getNumero(), contaTeste);

        while (true) {
            System.out.println("\n===== MENU DO BANCO =====");
            System.out.println("1. Criar Conta");
            System.out.println("2. Sacar");
            System.out.println("3. Depositar");
            System.out.println("4. Transferir");
            System.out.println("5. Consultar Saldo");
            System.out.println("6. Exibir Extrato");
            System.out.println("7. Sair");
            System.out.print("Escolha: ");

            int opcao = 0;

            try {
                opcao = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite um número.");
                sc.nextLine();
                continue;
            }
            switch (opcao) {
                case 1:
                    ce.registrarConta(banco);
                    contaRegistrada = true;
                    break;
                case 2:
                    if (!contaRegistrada) {
                        System.out.println(
                            "Você precisa criar uma conta antes de sacar."
                        );
                        break;
                    }

                    Conta usuarioConta = banco.buscarConta(contaAtiva);
                    System.out.println(
                        "O seu saldo é de : " + usuarioConta.getSaldo()
                    );
                    System.out.println("Digite o valor a ser sacado: ");
                    double valor = sc.nextDouble();
                    usuarioConta.sacar(valor);
                    break;
                case 3:
                    if (!contaRegistrada) {
                        System.out.println(
                            "Você precisa criar uma conta antes de sacar."
                        );
                        break;
                    }
                    Conta usuarioContaDeposito = banco.buscarConta(contaAtiva);

                    System.out.println("Digite o valor a ser depositado: ");
                    valor = sc.nextDouble();
                    usuarioContaDeposito.depositar(valor);
                    break;
                case 4:
                    // resto a se fazer a partir daqui
                    if (!contaRegistrada) {
                        System.out.println(
                            "Você precisa criar uma conta antes de sacar."
                        );
                        break;
                    }
                    System.out.println("O quanto você quer transferir?");
                    valor = sc.nextDouble();

                    try {
                        banco.realizarTransferencia(contaAtiva, "0", valor);
                    } catch (SaldoInsuficienteException e) {
                        System.out.println(
                            "Transferência falhou: " + e.getMessage()
                        );
                    }
                    System.out.println(contaTeste.getSaldo());
                    break;
                case 5:
                    if (!contaRegistrada) {
                        System.out.println(
                            "Você precisa criar uma conta antes de sacar."
                        );
                        break;
                    }
                    System.out.println();
                    System.out.println(
                        "O seu saldo é " +
                            banco.buscarConta(contaAtiva).getSaldo()
                    );
                    break;
                case 6:
                    if (!contaRegistrada) {
                        System.out.println(
                            "Você precisa criar uma conta antes de sacar."
                        );
                        break;
                    }
                    banco.buscarConta(contaAtiva).mostrarTransacoes();
                    break;
                case 7:
                    System.out.println("Obrigado por usar nosso sistema!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
