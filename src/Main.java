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
        boolean repetir = true;

        ContaPoupanca contaTeste = new ContaPoupanca("0", "Cleiton", 0);
        banco.adicionarConta(contaTeste.getNumero(), contaTeste);

        while (repetir) {
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
            double valor = 0;

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
                    double valorSaque = 0;
                    try {
                        System.out.println("Digite o valor a ser sacado: ");
                        valorSaque = sc.nextDouble();
                    } catch (InputMismatchException e) {
                        System.out.println(
                            "Entrada inválida! Digite um número."
                        );
                        break;
                    }
                    usuarioConta.sacar(valorSaque);
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
                    try {
                        double valorDeposito = sc.nextDouble();
                        usuarioContaDeposito.depositar(valorDeposito);
                    } catch (InputMismatchException e) {
                        System.out.println(
                            "Entrada inválida! Digite um número."
                        );
                        sc.nextLine();
                    }
                    break;
                case 4:
                    if (!contaRegistrada) {
                        System.out.println(
                            "Você precisa criar uma conta antes de sacar."
                        );
                        break;
                    }
                    System.out.println("O quanto você quer transferir?");
                    try {
                        double valorTransferencia = sc.nextDouble();

                        try {
                            banco.realizarTransferencia(
                                contaAtiva,
                                "0",
                                valorTransferencia
                            );
                        } catch (SaldoInsuficienteException e) {
                            System.out.println(
                                "Transferência falhou: " + e.getMessage()
                            );
                        }
                        System.out.println(contaTeste.getSaldo());
                    } catch (InputMismatchException e) {
                        System.out.println(
                            "Entrada inválida! Digite um número."
                        );
                        sc.nextLine();
                    }
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
                    repetir = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        sc.close();
    }
}
