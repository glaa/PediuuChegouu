package com.desenvolvimentomovel.pediuuchegouu.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BDController {

    private SQLiteDatabase db;
    private BDLocal banco;

    public BDController(Context context){
        banco = new BDLocal(context);
    }

    public String inserirCliente(String telefone, String nome, String apelido){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(BDLocal.CLIENTE_TELEFONE, telefone);
        valores.put(BDLocal.CLIENTE_NOME, nome);
        valores.put(BDLocal.CLIENTE_APELIDO, apelido);

        resultado = db.insert(BDLocal.TABELA_CLIENTE, null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }

    public Cursor carregarCliente(){
        Cursor cursor;
        String[] campos =  {banco.CLIENTE_TELEFONE,banco.CLIENTE_NOME,banco.CLIENTE_APELIDO};

        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA_CLIENTE, campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return  cursor;
    }
}
