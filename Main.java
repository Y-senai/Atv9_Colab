import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        CaixaEletronico ce = new CaixaEletronico();
        Banco banco = new Banco();
        Scanner sc = new Scanner(System.in);

        ContaPoupanca sexo = new ContaPoupanca(
            "1923237812",
            "Sexo da silva jr",
            0
        );
        banco.adicionarConta("Sexo", sexo);
        System.out.println(banco.qtdContas);
        System.out.println("Bem-vindo ao Caixa Eletrônico!");

        System.out.println("Escolha uma opção:");
        System.out.println("1 - Criar uma conta");
        System.out.println("2 - Sacar dinheiro");
        System.out.println("3 - Depositar dinheiro");
        System.out.println("4 - Transferir dinheiro");
        System.out.println("5 - Consultar saldo");
        System.out.println("6 - Exibir extrato");
        System.out.println("7 - Sair");

        int opcao = 0;

        while (true) {
            System.out.println("Escolha uma opção entre 1 e 7");
            try {
                opcao = sc.nextInt();

                if (opcao < 1 || opcao > 7) {
                    System.out.println("Opção inválida!");
                    continue;
                }

                break;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida!");
                sc.nextLine();
            }
            System.out.println("Opção inválida!");

            switch (opcao) {
                case 1:
                    System.out.println("Criando uma conta...");
                    ce.registrarConta(banco);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.out.println("Obrigado, tenha um bom dia!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        sc.close();
    }
}
