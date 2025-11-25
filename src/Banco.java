package src;

import java.util.HashMap;
import java.util.Map;

public class Banco {

    private Map<String, Conta> contas = new HashMap<>();
    int qtdContas = 0;

    public void adicionarConta(String numero, Conta conta) {
        contas.put(numero, conta);
        qtdContas++;
    }

    public boolean existeConta(String numero) {
        return contas.containsKey(numero);
    }

    public void removerConta(String numero) {
        contas.remove(numero);
    }

    // nunca sei se essas throw new Exception dão certo
    public Conta buscarConta(String numero) {
        if (numero == null || numero.isEmpty()) {
            throw new IllegalArgumentException("Nome da conta invalido");
        }
        if (!contas.containsKey(numero)) {
            throw new IllegalArgumentException("Conta não encontrada");
        }
        return contas.get(numero);
    }

    public void transferenciaContas(
        Conta depositante,
        Conta depositado,
        double valor
    ) {
        depositante.saldo -= valor;
        depositado.saldo += valor;
    }

    public void realizarTransferencia(
        String origem,
        String destino,
        double valor
    ) throws SaldoInsuficienteException {
        Conta contaOrigem = buscarConta(origem);
        Conta contaDestino = buscarConta(destino);

        if (contaOrigem == null) {
            throw new IllegalArgumentException(
                "Conta de origem não encontrada."
            );
        }
        if (contaDestino == null) {
            throw new IllegalArgumentException(
                "Conta de destino não encontrada."
            );
        }

        if (valor <= 0) {
            throw new IllegalArgumentException(
                "O valor da transferência deve ser positivo."
            );
        }

        contaOrigem.sacar(valor);
        contaDestino.depositar(valor);
    }
}
