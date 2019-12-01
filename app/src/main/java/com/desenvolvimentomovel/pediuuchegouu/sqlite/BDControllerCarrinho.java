package com.desenvolvimentomovel.pediuuchegouu.sqlite;

import android.content.Context;
import android.database.Cursor;

import com.desenvolvimentomovel.pediuuchegouu.Produto;

public class BDControllerCarrinho {

    private BDLocal db;

    public String[] salvarProduto(Context context, Produto produto){
        db = new BDLocal(context);

        String  mensagem = db.inserirProduto(context,produto);

        if(mensagem.equals("OK")) {
            return new String[]{"OK", "OK"};
        } else {
            return new String[] {"ERRO","Não foi possível salvar banco de dados!"};
        }
    }

}
