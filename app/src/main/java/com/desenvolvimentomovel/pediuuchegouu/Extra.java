package com.desenvolvimentomovel.pediuuchegouu;

import java.util.ArrayList;

public class Extra {

    private int id;
    private String tipo;
    private String nome;
    private double preco;

    private static ArrayList<Extra> extras = new ArrayList();

    public Extra(){}

    public Extra(int id, String tipo, String nome, double preco){
        this.id = id;
        this.tipo = tipo; //Complemento, Fruta, Calda e Adicional
        this.nome = nome;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void incluirExtra(Extra e){
        extras.add(e);
    }

    public void excluirExtra(int id){
        extras.remove(id);
    }

    public ArrayList<Extra> pegarExtra(){
        return extras;
    }
}
