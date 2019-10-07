package com.desenvolvimentomovel.pediuuchegouu;

public class Produto {

    private String mNome;
    private String mFoto;

    public Produto(){ }

    public Produto(String nome, String foto){
        this.mNome = nome;
        this.mFoto = foto;
    }

    public String getmNome() {
        return mNome;
    }

    public void setmNome(String mNome) {
        this.mNome = mNome;
    }

    public String getmFoto() {
        return mFoto;
    }

    public void setmFoto(String mFoto) {
        this.mFoto = mFoto;
    }
}
