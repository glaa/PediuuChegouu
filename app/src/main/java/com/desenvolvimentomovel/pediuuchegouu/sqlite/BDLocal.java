package com.desenvolvimentomovel.pediuuchegouu.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.desenvolvimentomovel.pediuuchegouu.Endereco;
import com.desenvolvimentomovel.pediuuchegouu.sqlite.BDContrato.ClienteEntrada;
import com.desenvolvimentomovel.pediuuchegouu.sqlite.BDContrato.EnderecoEntrada;

import java.util.ArrayList;

public class BDLocal extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "bdlocal.db";
    private static final int VERSAO = 2;
    private static final String TIPO_TEXTO = " TEXT";
    private static final String TIPO_INTEIRO = " INTEGER";
    private static final String CHAVE_PRIMARIA = " PRIMARY KEY";
    private static final String SEPARADOR = ",";
    private static final String SQL_CRIAR_CLIENTE =
            "CREATE TABLE " + ClienteEntrada.TABELA_CLIENTE + "(" +
                    ClienteEntrada.CLIENTE_TELEFONE + TIPO_TEXTO + CHAVE_PRIMARIA + SEPARADOR +
                    ClienteEntrada.CLIENTE_NOME + TIPO_TEXTO + " NOT NULL" + SEPARADOR +
                    ClienteEntrada.CLIENTE_APELIDO + TIPO_TEXTO + SEPARADOR +
                    ClienteEntrada.CLIENTE_SENHA + TIPO_TEXTO + " NOT NULL" + ")";
    private static final String SQL_CRIAR_ENDERECO =
            "CREATE TABLE " + EnderecoEntrada.TABELA_ENDERECO + "(" +
                    EnderecoEntrada.ENDERECO_ID + TIPO_INTEIRO + CHAVE_PRIMARIA + SEPARADOR +
                    EnderecoEntrada.ENDERECO_FK_CLIENTE_TELEFONE + TIPO_TEXTO + " NOT NULL" + SEPARADOR +
                    EnderecoEntrada.ENDERECO_NOME + TIPO_TEXTO + " NOT NULL" + SEPARADOR +
                    EnderecoEntrada.ENDERECO_LOGRADOURO + TIPO_TEXTO + " NOT NULL" + SEPARADOR +
                    EnderecoEntrada.ENDERECO_NUMERO + TIPO_TEXTO + " NOT NULL" + SEPARADOR +
                    EnderecoEntrada.ENDERECO_BAIRRO + TIPO_TEXTO + " NOT NULL" + SEPARADOR +
                    EnderecoEntrada.ENDERECO_REFERENCIA + TIPO_TEXTO + ");";
    private static final String SQL_DELETA_CLIENTE =
            "DROP TABLE IF EXISTS " + ClienteEntrada.TABELA_CLIENTE;
    private static final String SQL_DELETA_ENDERECO =
            "DROP TABLE IF EXISTS " + EnderecoEntrada.TABELA_ENDERECO;


    public BDLocal(Context context){
        super(context,NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CRIAR_CLIENTE);
        db.execSQL(SQL_CRIAR_ENDERECO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETA_CLIENTE);
        db.execSQL(SQL_DELETA_ENDERECO);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
        onUpgrade(db, oldVersion, newVersion);
    }

    public void apagarTudo(){

    }

    /**
     * Método para inserir cliente no banco de dados
     *
     * @param context
     * @param telefone
     * @param nome
     * @param apelido
     * @return a String "OK" se inserido com sucesso caso contrário a mensagem de exceção
     */
    public String inserirCliente(Context context, String telefone, String nome, String apelido, String senha){
        BDLocal banco = new BDLocal(context);
        SQLiteDatabase db = banco.getWritableDatabase();

        ContentValues valores;
        String mensagem = "OK";

        valores = new ContentValues();
        valores.put(ClienteEntrada.CLIENTE_TELEFONE, telefone);
        valores.put(ClienteEntrada.CLIENTE_NOME, nome);
        valores.put(ClienteEntrada.CLIENTE_APELIDO, apelido);
        valores.put(ClienteEntrada.CLIENTE_SENHA, senha);
        try {
            db.insertOrThrow(ClienteEntrada.TABELA_CLIENTE, null, valores);
        } catch (SQLException e){
            mensagem = e.getMessage();
        }
        db.close();

        return mensagem;
    }

    public Cursor carregarCliente(Context context){
        BDLocal banco = new BDLocal(context);
        SQLiteDatabase db = banco.getReadableDatabase();

        Cursor cursor;
        String[] campos =  {ClienteEntrada.CLIENTE_TELEFONE,ClienteEntrada.CLIENTE_NOME,ClienteEntrada.CLIENTE_APELIDO};

        cursor = db.query(ClienteEntrada.TABELA_CLIENTE, campos, null, null,
                null, null, null, null);

        if(cursor.getCount() > 0){
            cursor.moveToFirst();
        }
        db.close();
        return  cursor;
    }

    public Cursor autenticarCliente(Context context, String telefone, String senha){
        BDLocal banco = new BDLocal(context);
        SQLiteDatabase db = banco.getReadableDatabase();
        Cursor cursor;

        String where =
            "SELECT " + ClienteEntrada.CLIENTE_NOME + SEPARADOR + ClienteEntrada.CLIENTE_APELIDO + SEPARADOR +
            ClienteEntrada.CLIENTE_SENHA + " FROM " + ClienteEntrada.TABELA_CLIENTE +
            " WHERE " + ClienteEntrada.CLIENTE_TELEFONE + " = ?" + " AND "
            + ClienteEntrada.CLIENTE_SENHA + " = ?";
        String[] values = new String[] {telefone,senha};

        cursor = db.rawQuery(where,values);

        if(cursor.getCount() > 0){
            cursor.moveToFirst();
        }
        db.close();
        return  cursor;
    }

    public String buscarCliente(Context context, String telefoneCliente){
        BDLocal banco = new BDLocal(context);
        SQLiteDatabase db = banco.getReadableDatabase();
        Cursor cursor;

        String[] campos =  {ClienteEntrada.CLIENTE_TELEFONE};
        String where = ClienteEntrada.CLIENTE_TELEFONE + "=" + telefoneCliente + " ";

        cursor = db.query(ClienteEntrada.TABELA_CLIENTE, campos, where, null,
                null, null, null, null);

        if(cursor.getCount() > 0){
            cursor.moveToFirst();
        }
        db.close();

        return String.valueOf(cursor.getCount());
    }

    /**
     * Método para inserir endereço no banco de dados
     *
     * @param context
     * @param fkTelefoneCliente
     * @param nome
     * @param logradouro
     * @param numero
     * @param bairro
     * @param referencia
     * @return a String "OK" se inserido com sucesso caso contrário a mensagem de exceção
     */
    public String inserirEndereco(Context context, String fkTelefoneCliente, String nome, String logradouro,
                                  String numero, String bairro, String referencia){
        BDLocal banco = new BDLocal(context);
        SQLiteDatabase db = banco.getWritableDatabase();

        ContentValues valores;
        String mensagem = "OK";

        valores = new ContentValues();
        valores.put(EnderecoEntrada.ENDERECO_FK_CLIENTE_TELEFONE,fkTelefoneCliente);
        valores.put(EnderecoEntrada.ENDERECO_NOME, nome);
        valores.put(EnderecoEntrada.ENDERECO_LOGRADOURO, logradouro);
        valores.put(EnderecoEntrada.ENDERECO_NUMERO, numero);
        valores.put(EnderecoEntrada.ENDERECO_BAIRRO, bairro);
        valores.put(EnderecoEntrada.ENDERECO_REFERENCIA, referencia);

        try {
            long resultado;
            resultado = db.insert(EnderecoEntrada.TABELA_ENDERECO, null, valores);
            if(resultado == -1){
                mensagem = "ERRO";
            }

        } catch (SQLException e){
            mensagem = e.getMessage();
        }
        db.close();

        return mensagem;
    }

    public ArrayList<Endereco> buscarEnderecos(Context context, String telefoneCliente){
        ArrayList<Endereco> enderecos = new ArrayList<>();
        BDLocal banco = new BDLocal(context);
        SQLiteDatabase db = banco.getReadableDatabase();
        Cursor cursor;

        String[] campos =  {EnderecoEntrada.ENDERECO_NOME,
                            EnderecoEntrada.ENDERECO_LOGRADOURO,
                            EnderecoEntrada.ENDERECO_NUMERO,
                            EnderecoEntrada.ENDERECO_BAIRRO,
                            EnderecoEntrada.ENDERECO_REFERENCIA};
        String where =  EnderecoEntrada.ENDERECO_FK_CLIENTE_TELEFONE + "= ?";
        String[] selection = {telefoneCliente} ;

        cursor = db.query(EnderecoEntrada.TABELA_ENDERECO, campos, where, selection,
                null, null, null, null);

        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            do{
                Endereco endereco = new Endereco(cursor.getString(0),
                                                cursor.getString(1),
                                                cursor.getString(2),
                                                cursor.getString(3),
                                                cursor.getString(4));
                enderecos.add(endereco);
            }while(cursor.moveToNext());
        }
        db.close();

        return enderecos;
    }

}
