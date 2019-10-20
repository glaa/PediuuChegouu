package com.desenvolvimentomovel.pediuuchegouu;

public class CachorroQuente {

    private String tamanho;
    private double preco;
    private String conteudo;

    public CachorroQuente(){}

    public CachorroQuente(String tamanho, double preco, String conteudo) {
        this.tamanho = tamanho;
        this.preco = preco;
        this.conteudo = conteudo;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}
