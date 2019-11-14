package com.desenvolvimentomovel.pediuuchegouu.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class BDLocal extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "bdlocal.db";
    protected static final String TABELA_CLIENTE = "cliente";
    protected static final String CLIENTE_TELEFONE = "telefone";
    protected static final String CLIENTE_NOME = "nome";
    protected static final String CLIENTE_APELIDO = "apelido";
    private static final int VERSAO = 1;

    private static final String TABELA_ENDERECO = "endereco";
    private static final String ENDERECO_IDENTIFICACAO = "identificacao";
    private static final String ENDERECO_LOGRADOURO = "logradouro";
    private static final String ENDERECO_NUMERO = "numero";
    private static final String ENDERECO_BAIRRO = "bairro";
    private static final String ENDERECO_REFERENCIA = "referencia";

    public BDLocal(Context context){
        super(context,NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABELA_CLIENTE + "("
                + CLIENTE_TELEFONE + " text primary key,"
                + CLIENTE_NOME + " text,"
                + CLIENTE_APELIDO + " text"
                +")";
        db.execSQL(sql);

        sql = "CREATE TABLE " + TABELA_ENDERECO + "("
                + ENDERECO_IDENTIFICACAO + " text primary key,"
                + ENDERECO_LOGRADOURO + " text,"
                + ENDERECO_NUMERO + " text,"
                + ENDERECO_BAIRRO + " text,"
                + ENDERECO_REFERENCIA + " text"
                + ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_CLIENTE);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_ENDERECO);
        onCreate(db);
    }
}
