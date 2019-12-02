package com.desenvolvimentomovel.pediuuchegouu;

import java.util.ArrayList;

public class Compra {

    private static ArrayList<Produto> carrinho = new ArrayList<>();

    public Compra(){ }

    public void adicionarProduto(Produto p){
        carrinho.add(p);
    }

    public ArrayList<Produto> getCarrinho(){
        return carrinho;
    }

    public void removerProduto(int index){
        carrinho.remove(index);
    }

    public Produto recuperarProduto(int index){ return carrinho.get(index); }

    public void esvaziarCarrinho(){
        carrinho.clear();
    }
}
