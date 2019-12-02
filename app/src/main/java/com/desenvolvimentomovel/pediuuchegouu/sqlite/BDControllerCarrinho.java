package com.desenvolvimentomovel.pediuuchegouu.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.desenvolvimentomovel.pediuuchegouu.Acai;
import com.desenvolvimentomovel.pediuuchegouu.Extra;
import com.desenvolvimentomovel.pediuuchegouu.Produto;

import java.util.ArrayList;

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

    public String recuperarIDProduto(Context context, Produto produto){
        db = new BDLocal((context));
        String mensagem = db.recuperarIDProduto(context,produto);

        if(mensagem == null){
            return "ERRO";
        }
        return mensagem;
    }

    public String[] salvarExtra(Context context, Extra extra){
        db = new BDLocal(context);

        String mensagem = db.inserirExtra(context,extra);

        if(mensagem.equals("OK")) {
            return new String[]{"OK", "OK"};
        } else {
            return new String[] {"ERRO","Não foi possível salvar banco de dados!"};
        }
    }

    public String[] salvarAcai(Context context, Acai acai){
        db = new BDLocal(context);
        String[] resultado = {"OK","OK"};

        Produto produto = new Produto("Açai",acai.getmDescricao(),acai.getmTamanho(),acai.getmPreco(),"null");

        String recuperado = salvarProduto(context,produto)[1];
        if(recuperado.equals("OK")){
            String id = recuperarIDProduto(context,produto);
            if(id.equals("ERRO")){
                resultado = new String[] {"ERRO","Não foi possível salvar banco de dados0!"};
            } else {
                String mensagem = db.inserirAcai(context,acai,Integer.parseInt(id));
                if(!mensagem.equals("OK")) {
                    resultado = new String[] {"ERRO","Não foi possível salvar banco de dados1!"};
                }
            }

        } else {
            resultado = new String[] {"ERRO","Não foi possível salvar banco de dados2!"};
        }
        return resultado;
    }

    public String[] salvarCompra(Context context, ArrayList<Produto> produtos, double valor){
        db = new BDLocal(context);
        String idCompra = "";
        String mensagem = db.inserirCompra(context, valor);
        String[] mensagemRetorno = {"ERRO","Não foi possível salvar banco de dados!"};

        //Recuperar ID Compra
        if(mensagem.equals("OK")) {
            idCompra = recuperarIDCompra(context,valor);
            //Salvar produtos
            if(!idCompra.equals("ERRO")){
                for(int i = 0; i < produtos.size(); i++){
                    String mensProduto[];
                    mensProduto = salvarProduto(context,produtos.get(i));
                    //Recuperar ID Produto
                    if(mensProduto[0].equals("OK")){
                        String idProduto;
                        idProduto = recuperarIDProduto(context,produtos.get(i));
                        //Salvar item
                        if(!idProduto.equals("ERRO")){
                            String mensItem[];
                            mensItem = salvarItem(context,Integer.parseInt(idCompra),Integer.parseInt(idProduto),-1,-1);
                            if(mensItem[0].equals("OK")){
                                mensagemRetorno[0] = "OK";
                                mensagemRetorno[1] = "OK";
                            } else {
                                mensagemRetorno[0] = "ERRO";
                                mensagemRetorno[1] = "Não foi possível salvar item";
                            }
                            Log.d("CONTR05",mensagemRetorno[0] + " " + mensagemRetorno[1]  + mensItem[1]);
                        } else {
                            mensagemRetorno[0] = "ERRO";
                            mensagemRetorno[1] = "Erro no ID do produto no banco de dados";
                        }
                        Log.d("CONTR04",mensagemRetorno[0] + " " + mensagemRetorno[1] + " idPro: " + idProduto);
                    } else {
                        mensagemRetorno[0] = "ERRO";
                        mensagemRetorno[1] = "Não foi possível salvar produto no banco de dados";
                    }
                    Log.d("CONTR04",mensagemRetorno[0] + " " + mensagemRetorno[1] + " qtdPro: " + produtos.size());
                }
                Log.d("CONTR03",mensagem + " " + mensagemRetorno[1]);
            } else {
                mensagemRetorno[0] = "ERRO";
                mensagemRetorno[1] = "Erro no ID da compra no banco de dados";
            }
            Log.d("CONTR01",mensagem + " " + mensagemRetorno[1] + " idCompra: " + idCompra);
        }
        Log.d("CONTR00",mensagemRetorno + " " + mensagemRetorno[1]);
        return mensagemRetorno;
    }

    public String[] salvarItem(Context context, int fk_id_compra, int fk_id_produto,
                               int fk_id_acai, int fk_id_extra){
        db = new BDLocal(context);

        String mensagem = db.inserirItem(context,fk_id_compra,fk_id_produto,fk_id_acai,fk_id_extra);

        if(mensagem.equals("OK")) {
            return new String[]{"OK", "OK"};
        } else {
            return new String[] {"ERRO",mensagem};
        }
    }

    public String recuperarIDCompra(Context context, double valor){
        db = new BDLocal((context));
        String mensagem = db.recuperarIDCompra(context,valor);

        if(mensagem == null){
            return "ERRO";
        }
        return mensagem;
    }

    public ArrayList<Produto> recuperarProdutos(Context context){
        db = new BDLocal(context);
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        String data;
        ArrayList<String[]> n = db.recuperarTodasCompras(context);
        ArrayList<Object> objects = new ArrayList<>();

        for(int i=0; i<1; i++){
            data = n.get(i)[1];
            int idCompra = Integer.parseInt(n.get(i)[0]);
            ArrayList<Produto> ps = new ArrayList<Produto>();
            ps = db.recuperarProdutosPorCompra(context,idCompra);

            for (Produto p : ps) {
                produtos.add(p);
            }
            Object[] objeto = {produtos,data};
            objects.add(objeto);
            //Limpar os dados
            //produtos.clear();

        }
        return produtos;
    }

    public void teste(Context context){
        db = new BDLocal(context);
        ArrayList<String[]> n = db.recuperarTodasCompras(context);
        for (String[] s : n) {
            Log.d("CONTR47", s[0] + " - " + s[1]);
        }
    }
}
