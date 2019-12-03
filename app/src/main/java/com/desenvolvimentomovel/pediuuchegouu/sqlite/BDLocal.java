package com.desenvolvimentomovel.pediuuchegouu.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.desenvolvimentomovel.pediuuchegouu.Acai;
import com.desenvolvimentomovel.pediuuchegouu.Endereco;
import com.desenvolvimentomovel.pediuuchegouu.Extra;
import com.desenvolvimentomovel.pediuuchegouu.Produto;
import com.desenvolvimentomovel.pediuuchegouu.sqlite.BDContrato.ClienteEntrada;
import com.desenvolvimentomovel.pediuuchegouu.sqlite.BDContrato.EnderecoEntrada;
import com.desenvolvimentomovel.pediuuchegouu.sqlite.BDContrato.ProdutoEntrada;
import com.desenvolvimentomovel.pediuuchegouu.sqlite.BDContrato.ExtraEntrada;
import com.desenvolvimentomovel.pediuuchegouu.sqlite.BDContrato.AcaiEntrada;
import com.desenvolvimentomovel.pediuuchegouu.sqlite.BDContrato.CompraEntrada;
import com.desenvolvimentomovel.pediuuchegouu.sqlite.BDContrato.ItemEntrada;


import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

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
    private static final String SQL_CRIAR_PRODUTO =
            "CREATE TABLE " + ProdutoEntrada.TABELA_PRODUTO + "("+
                    ProdutoEntrada.PRODUTO_ID + TIPO_INTEIRO + CHAVE_PRIMARIA + SEPARADOR +
                    ProdutoEntrada.PRODUTO_NOME + TIPO_TEXTO + " NOT NULL" + SEPARADOR +
                    ProdutoEntrada.PRODUTO_DESCRICAO + TIPO_TEXTO + SEPARADOR +
                    ProdutoEntrada.PRODUTO_TAMANHO+ TIPO_TEXTO + SEPARADOR +
                    ProdutoEntrada.PRODUTO_PRECO + " REAL" + SEPARADOR +
                    ProdutoEntrada.PRODUTO_FOTO + TIPO_TEXTO + ");";
    private static final String SQL_CRIAR_EXTRA =
            "CREATE TABLE " + ExtraEntrada.TABELA_EXTRA + "(" +
                    ExtraEntrada.EXTRA_ID + TIPO_INTEIRO + CHAVE_PRIMARIA + SEPARADOR +
                    ExtraEntrada.EXTRA_TIPO + TIPO_TEXTO + SEPARADOR +
                    ExtraEntrada.EXTRA_NOME + TIPO_TEXTO + SEPARADOR +
                    ExtraEntrada.EXTRA_PRECO + " REAL" + SEPARADOR +
                    ExtraEntrada.EXTRA_QUANTIDADE + TIPO_INTEIRO + ");";
    private static final String SQL_CRIAR_ACAI =
            "CREATE TABLE " + AcaiEntrada.TABELA_ACAI + "(" +
                    AcaiEntrada.ACAI_ID + TIPO_INTEIRO + CHAVE_PRIMARIA + SEPARADOR +
                    AcaiEntrada.ACAI_FK_ID_PRODUTO + TIPO_INTEIRO + SEPARADOR +
                    AcaiEntrada.ACAI_RECIPIENTE + TIPO_TEXTO + SEPARADOR +
                    AcaiEntrada.ACAI_VOLUME + TIPO_TEXTO + SEPARADOR +
                    AcaiEntrada.ACAI_QTDCOMPLEMENTO + TIPO_INTEIRO + SEPARADOR +
                    AcaiEntrada.ACAI_QTDFRUTA + TIPO_INTEIRO + SEPARADOR +
                    AcaiEntrada.ACAI_QTDCALDA + TIPO_INTEIRO + SEPARADOR +
                    AcaiEntrada.ACAI_QTDADICIONAL + TIPO_INTEIRO + SEPARADOR +
                    AcaiEntrada.ACAI_SABOR + TIPO_TEXTO + ");";
    private static final String SQL_CRIAR_COMPRA =
            "CREATE TABLE " + CompraEntrada.TABELA_COMPRA + "(" +
                    CompraEntrada.COMPRA_ID + TIPO_INTEIRO + CHAVE_PRIMARIA + SEPARADOR +
                    CompraEntrada.COMPRA_DATA + TIPO_TEXTO + SEPARADOR +
                    CompraEntrada.COMPRA_FK_CLIENTE_TELEFONE + TIPO_TEXTO + SEPARADOR +
                    CompraEntrada.COMPRA_VALOR + " REAL" + ");";
    private static final String SQL_CRIAR_ITEM =
            "CREATE TABLE " + ItemEntrada.TABELA_ITEM + "(" +
                    ItemEntrada.ITEM_ID + TIPO_INTEIRO + CHAVE_PRIMARIA + SEPARADOR +
                    ItemEntrada.ITEM_FK_ID_COMPRA + TIPO_INTEIRO + SEPARADOR +
                    ItemEntrada.ITEM_FK_ID_PRODUTO + TIPO_INTEIRO + SEPARADOR +
                    ItemEntrada.ITEM_FK_ID_ACAI + TIPO_INTEIRO + SEPARADOR +
                    ItemEntrada.ITEM_FK_ID_EXTRA + TIPO_INTEIRO + ");";

    private static final String SQL_DELETA_CLIENTE =
            "DROP TABLE IF EXISTS " + ClienteEntrada.TABELA_CLIENTE;
    private static final String SQL_DELETA_ENDERECO =
            "DROP TABLE IF EXISTS " + EnderecoEntrada.TABELA_ENDERECO;
    private static final String SQL_DELETA_PRODUTO =
            "DROP TABLE IF EXISTS " + ProdutoEntrada.TABELA_PRODUTO;
    private static final String SQL_DELETA_EXTRA =
            "DROP TABLE IF EXISTS " + ExtraEntrada.TABELA_EXTRA;
    private static final String SQL_DELETA_ACAI =
            "DROP TABLE IF EXISTS " + AcaiEntrada.TABELA_ACAI;
    private static final String SQL_DELETA_COMPRA =
            "DROP TABLE IF EXISTS " + CompraEntrada.TABELA_COMPRA;
    private static final String SQL_DELETA_ITEM =
            "DROP TABLE IF EXISTS " + ItemEntrada.TABELA_ITEM;

    public BDLocal(Context context){
        super(context,NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CRIAR_CLIENTE);
        db.execSQL(SQL_CRIAR_ENDERECO);
        db.execSQL(SQL_CRIAR_PRODUTO);
        db.execSQL(SQL_CRIAR_EXTRA);
        db.execSQL(SQL_CRIAR_ACAI);
        db.execSQL(SQL_CRIAR_COMPRA);
        db.execSQL(SQL_CRIAR_ITEM);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETA_CLIENTE);
        db.execSQL(SQL_DELETA_ENDERECO);
        db.execSQL(SQL_DELETA_PRODUTO);
        db.execSQL(SQL_DELETA_EXTRA);
        db.execSQL(SQL_DELETA_ACAI);
        db.execSQL(SQL_DELETA_COMPRA);
        db.execSQL(SQL_DELETA_ITEM);
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

    public String inserirProduto(Context context, Produto produto){
        BDLocal banco = new BDLocal(context);
        SQLiteDatabase db = banco.getWritableDatabase();

        ContentValues valores;
        String mensagem = "OK";

        valores = new ContentValues();
        valores.put(ProdutoEntrada.PRODUTO_NOME, produto.getmNome());
        valores.put(ProdutoEntrada.PRODUTO_DESCRICAO, produto.getmDescricao());
        valores.put(ProdutoEntrada.PRODUTO_TAMANHO, produto.getmTamanho());
        valores.put(ProdutoEntrada.PRODUTO_PRECO, produto.getmPreco());
        valores.put(ProdutoEntrada.PRODUTO_FOTO, produto.getmFoto());

        try {
            long resultado;
            resultado = db.insertOrThrow(ProdutoEntrada.TABELA_PRODUTO, null, valores);
            if(resultado == -1){
                mensagem = "ERRO";
            }

        } catch (SQLException e){
            mensagem = e.getMessage();
        }
        db.close();

        return mensagem;
    }

    public String recuperarIDProduto(Context context, Produto produto){
        BDLocal banco = new BDLocal(context);
        SQLiteDatabase db = banco.getReadableDatabase();
        Cursor cursor;
        String id = null;

        String[] campo = {ProdutoEntrada.PRODUTO_ID};

        String where = ProdutoEntrada.PRODUTO_NOME + "= ? AND " +
                ProdutoEntrada.PRODUTO_DESCRICAO + " = ? AND " +
                ProdutoEntrada.PRODUTO_PRECO + "= ?" ;

        String[] selection = {produto.getmNome(), produto.getmDescricao(), String.valueOf(produto.getmPreco())};

        cursor = db.query(ProdutoEntrada.TABELA_PRODUTO, campo, where, selection,
                null, null, null, null);

        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            id = cursor.getString(0);
        }
        db.close();

        return id;
    }

    public Produto recuperarProdutoPorID(Context context, int id){
        BDLocal banco = new BDLocal(context);
        SQLiteDatabase db = banco.getReadableDatabase();
        Cursor cursor;
        Produto produto = null;
        //String id = null;

        String[] campo = {ProdutoEntrada.PRODUTO_NOME, ProdutoEntrada.PRODUTO_DESCRICAO,
                ProdutoEntrada.PRODUTO_TAMANHO, ProdutoEntrada.PRODUTO_PRECO};

        String where = ProdutoEntrada.PRODUTO_ID + "= ?";

        String[] selection = {String.valueOf(id)};

        cursor = db.query(ProdutoEntrada.TABELA_PRODUTO, campo, where, selection,
                null, null, null, null);

        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            do{
                produto = new Produto(cursor.getString(0),cursor.getString(1),
                        cursor.getString(2),Double.parseDouble(cursor.getString(3)),null);
            } while(cursor.moveToNext());
        }
        db.close();

        return produto;
    }

    public String inserirExtra(Context context, Extra extra){
        BDLocal banco = new BDLocal(context);
        SQLiteDatabase db = banco.getWritableDatabase();

        ContentValues valores;
        String mensagem = "OK";

        valores = new ContentValues();

        valores.put(ExtraEntrada.EXTRA_TIPO, extra.getTipo());
        valores.put(ExtraEntrada.EXTRA_NOME, extra.getNome());
        valores.put(ExtraEntrada.EXTRA_PRECO, extra.getPreco());
        valores.put(ExtraEntrada.EXTRA_QUANTIDADE, extra.getQuantidade());

        try {
            long resultado;
            resultado = db.insertOrThrow(ExtraEntrada.TABELA_EXTRA, null, valores);
            if(resultado == -1){
                mensagem = "ERRO";
            }

        } catch (SQLException e){
            mensagem = e.getMessage();
        }
        db.close();

        return mensagem;
    }

    public String inserirAcai(Context context, Acai acai, int fk_id_produto){
        BDLocal banco = new BDLocal(context);
        SQLiteDatabase db = banco.getWritableDatabase();

        ContentValues valores;
        String mensagem = "OK";

        valores = new ContentValues();

        valores.put(AcaiEntrada.ACAI_FK_ID_PRODUTO, fk_id_produto);
        valores.put(AcaiEntrada.ACAI_RECIPIENTE, acai.getRecipiente());
        valores.put(AcaiEntrada.ACAI_VOLUME, acai.getVolume());
        valores.put(AcaiEntrada.ACAI_QTDCOMPLEMENTO, acai.getQtdComplemento());
        valores.put(AcaiEntrada.ACAI_QTDFRUTA, acai.getQtdFruta());
        valores.put(AcaiEntrada.ACAI_QTDCALDA, acai.getQtdCalda());
        valores.put(AcaiEntrada.ACAI_QTDADICIONAL, acai.getQtdAdicionais());
        valores.put(AcaiEntrada.ACAI_SABOR, acai.getSabor());

        try {
            long resultado;
            resultado = db.insertOrThrow(AcaiEntrada.TABELA_ACAI, null, valores);
            if(resultado == -1){
                mensagem = "ERRO";
            }

        } catch (SQLException e){
            mensagem = e.getMessage();
        }
        db.close();

        return mensagem;
    }

    public String inserirCompra(Context context, double valor, String telefone_cliente){
        Date atual = new Date();
        String dStr = java.text.DateFormat.getDateInstance(DateFormat.SHORT).format(atual);

        BDLocal banco = new BDLocal(context);
        SQLiteDatabase db = banco.getWritableDatabase();

        ContentValues valores;
        String mensagem = "OK";

        valores = new ContentValues();

        valores.put(CompraEntrada.COMPRA_DATA, dStr);
        valores.put(CompraEntrada.COMPRA_FK_CLIENTE_TELEFONE, telefone_cliente);
        valores.put(CompraEntrada.COMPRA_VALOR, valor);

        try {
            long resultado;
            resultado = db.insertOrThrow(CompraEntrada.TABELA_COMPRA, null, valores);

            if(resultado == -1){
                mensagem = "ERRO";
            }

        } catch (SQLException e){
            mensagem = e.getMessage();
        }
        db.close();

        return mensagem;
    }

    public String inserirItem(Context context, int fk_id_compra, int fk_id_produto,
                              int fk_id_acai, int fk_id_extra){
        BDLocal banco = new BDLocal(context);
        SQLiteDatabase db = banco.getWritableDatabase();

        ContentValues valores;
        String mensagem = "OK";

        valores = new ContentValues();

        valores.put(ItemEntrada.ITEM_FK_ID_COMPRA, fk_id_compra);
        valores.put(ItemEntrada.ITEM_FK_ID_PRODUTO, fk_id_produto);
        valores.put(ItemEntrada.ITEM_FK_ID_ACAI, fk_id_acai);
        valores.put(ItemEntrada.ITEM_FK_ID_EXTRA, fk_id_extra);

        try {
            long resultado;
            resultado = db.insertOrThrow(ItemEntrada.TABELA_ITEM, null, valores);
            if(resultado == -1){
                mensagem = "ERRO";
            }

        } catch (SQLException e){
            mensagem = e.getMessage();
        }
        db.close();

        return mensagem;
    }

    public String recuperarIDCompraPorCompra(Context context, double valor, String telefone_cliente){
        BDLocal banco = new BDLocal(context);
        SQLiteDatabase db = banco.getReadableDatabase();
        Cursor cursor;
        String id = null;
        Date atual = new Date();
        String dStr = java.text.DateFormat.getDateInstance(DateFormat.SHORT).format(atual);

        String[] campo = {CompraEntrada.COMPRA_ID};

        String where = CompraEntrada.COMPRA_DATA + "= ? AND " +
                CompraEntrada.COMPRA_FK_CLIENTE_TELEFONE + "= ? AND " +
                CompraEntrada.COMPRA_VALOR + " = ?";

        String[] selection = {dStr, telefone_cliente, String.valueOf(valor)};

        cursor = db.query(CompraEntrada.TABELA_COMPRA, campo, where, selection,
                null, null, null, null);

        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            id = cursor.getString(0);
        }
        db.close();

        return id;
    }

    public ArrayList<String[]> recuperarTodasComprasPorCliente(Context context, String telefone_cliente){
        BDLocal banco = new BDLocal(context);
        SQLiteDatabase db = banco.getReadableDatabase();
        Cursor cursor;
        ArrayList<String[]> indices = new ArrayList<>();

        String [] campo = {CompraEntrada.COMPRA_ID,CompraEntrada.COMPRA_DATA};

        String where = CompraEntrada.COMPRA_FK_CLIENTE_TELEFONE + " = ? ";

        String[] selection = {telefone_cliente};

        cursor = db.query(CompraEntrada.TABELA_COMPRA, campo, where, selection,
                null, null, null, null);

        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            do{
                String [] s = {String.valueOf(cursor.getInt(0)),cursor.getString(1)};
                indices.add(s);
            }while(cursor.moveToNext());
        }

        db.close();

        return indices;
    }

    public ArrayList<Produto> recuperarProdutosPorCompra(Context context, int id_compra){
        BDLocal banco = new BDLocal(context);
        SQLiteDatabase db = banco.getReadableDatabase();
        Cursor cursor;
        ArrayList<Produto> produtos = new ArrayList<>();

        String[] campo = {ItemEntrada.ITEM_FK_ID_PRODUTO};

        String where = ItemEntrada.ITEM_FK_ID_COMPRA + " = ? ";

        String[] selection = {String.valueOf(id_compra)};

        cursor = db.query(ItemEntrada.TABELA_ITEM, campo, where, selection,
                null, null, null, null);

        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            do{
                Produto p = recuperarProdutoPorID(context,cursor.getInt(0));
                if(p != null){
                    produtos.add(p);
                }
            }while(cursor.moveToNext());
        }

        return produtos;
    }

}
