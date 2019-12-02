package com.desenvolvimentomovel.pediuuchegouu.sqlite;


import android.content.Context;
import android.database.Cursor;
import android.util.Log;


public class BDControllerCliente {

    private BDLocal db;

    public String[] autenticarCliente(Context context, String telefone, String senha){
        Cursor cursor;
        String[] cliente = null;
        db = new BDLocal(context);

        cursor = db.autenticarCliente(context,telefone,senha);

        if(cursor.getCount() > 0){
            String nome = cursor.getString(0);
            String apelido = cursor.getString(1);

            cliente = new String[] {nome,apelido};
        }

        db.close();

        return cliente;
    }

    public String[] inserirCliente(Context context, String telefone, String nome, String apelido, String senha){
        String mensagemErro;
        String erro;
        db = new BDLocal(context);

        String mensagem = db.inserirCliente(context,telefone,nome,apelido,senha);

        if(mensagem.equals("OK")){
            return new String[] {"OK","OK"};
        } else {
            //Log.d("BDLOCALcontrol",mensagem);
            if (mensagem.equals("UNIQUE constraint failed: cliente.telefone (code 1555)")) {
                erro = "TELEFONE";
                mensagemErro = "Este telefone já possui um cadastro.\nDeseja fazer login?";
            } else {
                erro = "DESCONHECIDO";
                mensagemErro = "Cadastro não realizado.\nTente mais tarde!";
            }
            return new String[] {erro,mensagemErro};
        }
    }

}
