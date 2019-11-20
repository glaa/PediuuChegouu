package com.desenvolvimentomovel.pediuuchegouu;

import java.io.Serializable;

public class Produto implements Serializable {

    private String mNome;
    private String mDescricao;
    private String mTamanho;
    private double mPreco;
    private String mFoto;

    public Produto(){ }

    public Produto(String nome, String descricao, String tamanho, double preco, String foto){
        this.mNome = nome;
        this.mDescricao = descricao;
        this.mTamanho = tamanho;
        this.mPreco = preco;
        this.mFoto = foto;
    }

    public String getmNome() {
        return mNome;
    }

    public void setmNome(String mNome) {
        this.mNome = mNome;
    }

    public String getmDescricao() {
        return mDescricao;
    }

    public void setmDescricao(String mDescricao) {
        this.mDescricao = mDescricao;
    }

    public String getmTamanho() {
        return mTamanho;
    }

    public void setmTamanho(String mTamanho) {
        this.mTamanho = mTamanho;
    }

    public double getmPreco() {
        return mPreco;
    }

    public void setmPreco(double mPreco) {
        this.mPreco = mPreco;
    }

    public String getmFoto() {
        return mFoto;
    }

    public void setmFoto(String mFoto) {
        this.mFoto = mFoto;
    }
}
