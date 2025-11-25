package src;

import java.util.HashMap;
import java.util.Map;

public class Banco {


    private Map<String, Conta> contas = new HashMap<>();

    public void adicionarConta(String nome, Conta conta) {
        contas.put(nome, conta);
    }

    public boolean existeConta(String numero) {
        return contas.containsKey(numero);
    }

    public void removerConta(String numero) {
        contas.remove(numero);
    }

    // nunca sei se essas throw new Exception dão certo
    public Conta buscarConta(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome da conta invalido");
        }
        if (!contas.containsKey(nome)) {
            throw new IllegalArgumentException("Conta não encontrada");
        }
        return contas.get(nome);
    }
    public void transferenciaContas(Conta depositante,Conta depositado,double valor){
        depositante.saldo-=valor;
        depositado.saldo+=valor;
    }
}
