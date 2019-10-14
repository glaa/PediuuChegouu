package com.desenvolvimentomovel.pediuuchegouu;

public class Acai {

    private String recipiente;
    private String tamanho;
    private String quatidade;
    private double preco;
    private String descricao;

    public Acai(){}

    public Acai(String recipiente, String tamanho, String quatidade, double preco, String descricao) {
        this.recipiente = recipiente;
        this.tamanho = tamanho;
        this.quatidade = quatidade;
        this.preco = preco;
        this.descricao = descricao;
    }

    public String getRecipiente() {
        return recipiente;
    }

    public void setRecipiente(String recipiente) {
        this.recipiente = recipiente;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getQuatidade() {
        return quatidade;
    }

    public void setQuatidade(String quatidade) {
        this.quatidade = quatidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
