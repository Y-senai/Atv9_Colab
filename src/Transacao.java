package src;

public class Transacao {

    private String tipo;
    private double valor;

    public Transacao(String tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public void imprimirTransacao() {
        System.out.println("Tipo: " + tipo + ", Valor: " + valor);
    }
}
