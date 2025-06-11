package model;

public class Tarefa {
    private String descricao;
    private int prioridade;
    private boolean concluida;

    public Tarefa(String descricao, int prioridade, boolean concluida){
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.concluida = concluida;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }
}
