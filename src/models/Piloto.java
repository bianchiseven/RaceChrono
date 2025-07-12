package models;

public class Piloto {
    private String nome;
    private int habilidade;
    private double agressividade;
    private double combustivel;

    public Piloto(String nome, int habilidade, double agressividade) {
        this.nome = nome;
        this.habilidade = habilidade;
        this.agressividade = agressividade;
        this.combustivel = 100.0;
    }

    public String getNome() { return nome; }
    public int getHabilidade() { return habilidade; }
    public double getAgressividade() { return agressividade; }

    public double getCombustivel() {
        return combustivel;
    }

    public void consumirCombustivel() {
        combustivel -= 1.2 + (agressividade * 0.3);
    }
}
