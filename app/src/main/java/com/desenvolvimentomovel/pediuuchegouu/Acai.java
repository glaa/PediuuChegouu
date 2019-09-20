package com.desenvolvimentomovel.pediuuchegouu;

public class Acai extends Produto{

    private String recipiente;
    private String volume;
    private int qtdComplemento;
    private int qtdFruta;
    private int qtdCalda;

    public Acai(){}

    public Acai(String recipiente, String tamanho, String volume, double preco, String descricao,
                int qtdComplemento, int qtdFruta, int qtdCalda) {
        super("Açai", descricao, tamanho, preco, null);
        this.recipiente = recipiente;
        this.volume = volume;
        this.qtdComplemento = qtdComplemento;
        this.qtdFruta = qtdFruta;
        this.qtdCalda = qtdCalda;
    }

    public String getRecipiente() {
        return recipiente;
    }

    public void setRecipiente(String recipiente) {
        this.recipiente = recipiente;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public int getQtdComplemento() {
        return qtdComplemento;
    }

    public void setQtdComplemento(int qtdComplemento) {
        this.qtdComplemento = qtdComplemento;
    }

    public int getQtdFruta() {
        return qtdFruta;
    }

    public void setQtdFruta(int qtdFruta) {
        this.qtdFruta = qtdFruta;
    }

    public int getQtdCalda() {
        return qtdCalda;
    }

    public void setQtdCalda(int qtdCalda) {
        this.qtdCalda = qtdCalda;
    }
}
