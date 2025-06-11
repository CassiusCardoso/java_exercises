package model;

public class Pedido {
    private int unidade;
    private double preco;
    private boolean processado;

    public Pedido(int unidade, double preco, boolean processado) {
        this.unidade = unidade;
        this.preco = preco;
        this.processado = processado;
    }
    public int getUnidade() {
        return unidade;
    }
    public void setUnidade(int unidade) {
        this.unidade = unidade;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public boolean isProcessado() {
        return processado;
    }
    public void setProcessado(boolean processado) {
        this.processado = processado;
    }
}
