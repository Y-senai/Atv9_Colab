package src;

import java.util.Scanner;

public class CaixaEletronico {

    Scanner sc = new Scanner(System.in);

    public ContaPoupanca criarContaP(Banco banco) {
        sc.nextLine();
        System.out.println("Digite seu nome: ");
        String nome = sc.nextLine();
        String numero = String.valueOf(banco.qtdContas);
        return new ContaPoupanca(numero, nome, 0);
    }

    public ContaCorrente criarContaC(Banco banco, double ChequeEspecial) {
        sc.nextLine();
        System.out.println("Digite seu nome: ");
        String nome = sc.nextLine();
        String numero = String.valueOf(banco.qtdContas);
        return new ContaCorrente(numero, nome, 0, 0);
    }

    public void registrarConta(Banco banco) {
        System.out.println("Você deseja uma corrente ou poupança?");
        System.out.println("1 - poupança\n2 - corrente");
        try {
            int opcao = sc.nextInt();
            if (opcao == 1) {
                ContaPoupanca contaP = criarContaP(banco);
                String numero = String.valueOf(banco.qtdContas);
                banco.adicionarConta(numero, contaP);
            } else if (opcao == 2) {
                System.out.println("Digite o limite do cheque especial: ");
                double limite = sc.nextDouble();
                ContaCorrente contaC = criarContaC(banco, limite);
                String numero = String.valueOf(banco.qtdContas);
                banco.adicionarConta(numero, contaC);
            } else {
                System.out.println("Opção inválida");
            }
        } catch (Exception e) {
            System.out.println("Opção inválida");
        }
    }
}
