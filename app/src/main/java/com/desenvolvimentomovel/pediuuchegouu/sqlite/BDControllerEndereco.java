package com.desenvolvimentomovel.pediuuchegouu.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.desenvolvimentomovel.pediuuchegouu.Endereco;

import java.util.ArrayList;

public class BDControllerEndereco {

    private BDLocal db;

    public String[] inserirEndereco(Context context, String telefoneCliente, String nome,
                                    String logradouro, String numero, String bairro, String referencia){
        String mensagemErro;
        String erro;
        db = new BDLocal(context);

        String mensagem = db.inserirEndereco(context,telefoneCliente,nome,logradouro,numero,bairro,referencia);

        if(mensagem.equals("OK")){
            return new String[] {"OK","OK"};
        } else {
            erro = "ERRO";
            mensagemErro = "Erro ao salvar no banco de dados!";
            return new String[] {erro,mensagemErro};
        }
    }

    public ArrayList<Endereco> buscarEnderecos(Context context, String telefoneCliente){
        ArrayList<Endereco> enderecos = new ArrayList<>();
        db = new BDLocal(context);

        enderecos = db.buscarEnderecos(context,telefoneCliente);

        return enderecos;
    }
}
