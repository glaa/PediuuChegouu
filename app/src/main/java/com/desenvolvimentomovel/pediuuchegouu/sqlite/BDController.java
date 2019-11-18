package com.desenvolvimentomovel.pediuuchegouu.sqlite;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class BDController {

    private SQLiteDatabase db;
    private BDLocal banco;

    public BDController(Context context){
        banco = new BDLocal(context);
    }


    /**
     * Método para inserir cliente no banco de dados
     *
     * @param telefone
     * @param nome
     * @param apelido
     * @return a String "OK" se inserido com sucesso caso contrário a mensagem de exceção
     */
    public String inserirCliente(String telefone, String nome, String apelido, String senha){
        ContentValues valores;
        String mensagem = "OK";
        db = banco.getWritableDatabase();

        valores = new ContentValues();
        valores.put(BDLocal.CLIENTE_TELEFONE, telefone);
        valores.put(BDLocal.CLIENTE_NOME, nome);
        valores.put(BDLocal.CLIENTE_APELIDO, apelido);
        valores.put(BDLocal.CLIENTE_SENHA, senha);
        try {
            db.insertOrThrow(BDLocal.TABELA_CLIENTE, null, valores);
        } catch (SQLException e){
            mensagem = e.getMessage();
        }
        db.close();

        return mensagem;
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

    public Cursor autenticarCliente(String telefone, String senha){
        Cursor cursor;
        String where = "SELECT " + BDLocal.CLIENTE_NOME + "," + BDLocal.CLIENTE_APELIDO +  ","
                                + BDLocal.CLIENTE_SENHA + " FROM " + BDLocal.TABELA_CLIENTE
                                + " WHERE " + BDLocal.CLIENTE_TELEFONE + " = ?" + " AND "
                                + BDLocal.CLIENTE_SENHA + " = ?";
        String[] values = new String[] {telefone,senha};

        db = banco.getReadableDatabase();
        cursor = db.rawQuery(where,values);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return  cursor;
    }

    public String consultarCliente(String telefone){
        Cursor cursor;
        String[] campos =  {banco.CLIENTE_TELEFONE};
        String where = BDLocal.CLIENTE_TELEFONE + "=" + telefone + " ";

        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA_CLIENTE, campos, where, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();

        return String.valueOf(cursor.getCount());
    }
}
