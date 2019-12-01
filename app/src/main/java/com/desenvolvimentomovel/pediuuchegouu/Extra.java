package com.desenvolvimentomovel.pediuuchegouu;

import android.util.Log;

import java.util.ArrayList;

public class Extra {

    private int id;
    private String tipo;
    private String nome;
    private double preco;
    private int quantidade;

    private static ArrayList<Extra> extras = new ArrayList();

    public Extra(){}

    public Extra(int id, String tipo, String nome, double preco, int quantidade){
        this.id = id;
        this.tipo = tipo; //Complemento, Fruta, Calda e Adicional
        this.nome = nome;
        this.preco = preco; //Preço cobrado pelo excesso
        this.quantidade = quantidade;
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
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

    public int existeExtra(int id){
        int indice = -1;
        for(int i = 0; i < extras.size(); i++){
            if(extras.get(i).id == id){
                indice = i;
                break;
            }
        }
        return indice;
    }

    public void atualizar(Extra extra){
        int indice = existeExtra(extra.id);
        if(extra.quantidade > 0){
            //Caso não exista nos extras
            if(indice == -1){
                incluirExtra(extra);
            } else {
                excluirExtra(indice);
                incluirExtra(extra);
            }
        } else {
            if(extra.quantidade == 0 && indice != -1){
                excluirExtra(indice);
            }
        }
        imprimir();
    }

    private void imprimir(){
        String a = "";
        for (Extra e:extras) {
            a = a + "," + e.nome + "(" + e.quantidade + ")";
        }
        Log.d("EXTRA0",a);
    }
}
