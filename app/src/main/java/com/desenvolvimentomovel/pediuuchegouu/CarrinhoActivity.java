package com.desenvolvimentomovel.pediuuchegouu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.desenvolvimentomovel.pediuuchegouu.sqlite.BDControllerCarrinho;
import com.desenvolvimentomovel.pediuuchegouu.sqlite.BDControllerEndereco;

import java.io.Serializable;
import java.util.ArrayList;

public class CarrinhoActivity extends AppCompatActivity implements CarrinhoAdapter.ItemClicked{

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private TextView tvValor;
    private LinearLayout layoutComprar;
    private LinearLayout layoutTroco;
    private CheckBox troco;
    Compra compra = new Compra();
    private ArrayList<Produto> favoritos;
    private Button btPedir;
    static final int PICK_CONTACT_REQUEST = 1;
    private double valorCompra = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);

        favoritos = new ArrayList<>();
        //Log.d("CAR0", String.valueOf(new BDControllerCarrinho().salvarCompra(getBaseContext(),15.50)[1]));
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Carrinho");
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_left);
        setSupportActionBar(toolbar);

        tvValor = findViewById(R.id.tv_valor_carrinho);
        btPedir = findViewById(R.id.bt_pedir_carrinho);

        //Recebendo dados da activity anterior
        Produto c = (Produto) getIntent().getSerializableExtra("Produto");
        compra.adicionarProduto(c);


        recyclerView = findViewById(R.id.rv_carrinho);
        recyclerView.setHasFixedSize(false);

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new CarrinhoAdapter(this,compra.getCarrinho(),favoritos);
        recyclerView.setAdapter(mAdapter);

        layoutComprar = findViewById(R.id.layout_continuar_comprando_carrinho);

        layoutComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CarrinhoActivity.this,ProdutosActivity.class);
                startActivity(intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        troco = findViewById(R.id.cb_carrinho);
        layoutTroco = findViewById(R.id.layout_troco_carrinho);
        troco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(troco.isChecked()){
                    //Toast.makeText(CarrinhoActivity.this,"ativo" + String.valueOf(layoutTroco.getHeight()),Toast.LENGTH_SHORT).show();
                    layoutTroco.setVisibility(View.VISIBLE);

                } else {
                    //Toast.makeText(CarrinhoActivity.this,"ativo" + String.valueOf(layoutTroco.getHeight()),Toast.LENGTH_SHORT).show();
                    layoutTroco.setVisibility(View.GONE);

                }
            }
        });

        calcularValor();

        btPedir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog alertDialog = new AlertDialog.Builder(CarrinhoActivity.this).create();
                alertDialog.setCanceledOnTouchOutside(false);
                if(verificarUsuarioLogado()){
                    //Usuario está logado
                    ArrayList<Endereco> enderecos = new BDControllerEndereco().buscarEnderecos(getBaseContext(),Preferencias.buscarTelefoneUsuario());
                    if(enderecos.isEmpty()){
                        //usuario não possui endereço cadastrado
                        alertDialog.setMessage("Você não possui um endereço cadastrado.\nCadastrar um endereço agora!");
                        alertDialog.setButton(DialogInterface.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(CarrinhoActivity.this,CadastroEnderecoActivity.class);
                                startActivity(intent);
                            }
                        });
                        alertDialog.show();
                    } else {
                        //Usa o unico endereço que está cadastrado
                        if(enderecos.size() == 1){
                            //Salvando no banco de dados
                            salvarCompra(enderecos.get(0));
                        } else {
                            //Escolhe entre os endereços que estão cadastrado
                            Intent intent = new Intent(CarrinhoActivity.this,MeusEnderecosActivity.class);
                            startActivityForResult(intent,PICK_CONTACT_REQUEST);
                            
                        }
                    }
                } else {
                    alertDialog.setMessage("Você não está logado.\nRealize o cadastro ou faça o login!");
                    alertDialog.setButton(DialogInterface.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(CarrinhoActivity.this,InicialActivity.class);
                            startActivity(intent);
                        }
                    });
                    alertDialog.show();
                }
            }
        });
    }

    private void calcularValor(){
        double valor = 0;
        for(Produto p : compra.getCarrinho()){
            valor += p.getmPreco();
        }
        tvValor.setText(String.valueOf(valor));
        valorCompra = valor;
    }

    //Método para excluir um item do recycleview apartir de um click no icone delete do item_carrinho
    @Override
    public void excluirItem(int index) {
        compra.removerProduto(index);
        calcularValor();
        //Remove um item da lista
        mAdapter.notifyItemRemoved(index);
        if(compra.getCarrinho().size() == 0){
            onSupportNavigateUp();
        }
    }

    @Override
    public void ativarFavorito(int index){
        Toast.makeText(this,"Incluído nos favoritos",Toast.LENGTH_SHORT).show();
        favoritos.add(compra.recuperarProduto(index));
    }

    @Override
    public void desativarFavorito(int index){
        Toast.makeText(this,"Excluído dos favoritos",Toast.LENGTH_SHORT).show();
        favoritos.remove(compra.recuperarProduto(index));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private boolean verificarUsuarioLogado(){
        boolean logado = true;
        if(!Preferencias.preferencias.contains("logado")){
            logado = false;
        }
        return logado;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_CONTACT_REQUEST) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                Endereco endereco = (Endereco) data.getSerializableExtra("Endereco");
                //Salvando no banco de dados
                salvarCompra(endereco);
            }
        }
    }

    private void salvarCompra(Endereco endereco){
        /*
        if(gravarPedido()){
            AlertDialog alertDialog = new AlertDialog.Builder(CarrinhoActivity.this).create();
            alertDialog.setTitle("Pedido realizado!");
            alertDialog.setMessage(
                    "O pedido será entregue no indereço identificado como:\n" +
                            endereco.getTipo().toUpperCase());

            alertDialog.setButton(DialogInterface.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(CarrinhoActivity.this, InicialActivity.class);
                    startActivity(intent);
                }
            });

            alertDialog.show();
        }*/
        if(gravarPedido()){
            final AlertDialog alertDialog = new AlertDialog.Builder(CarrinhoActivity.this).create();
            alertDialog.setTitle("Pedido realizado!");
            alertDialog.setMessage(
                    "O pedido será entregue no indereço identificado como:\n" +
                            endereco.getTipo().toUpperCase());

            alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "SIM", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    compra.esvaziarCarrinho();
                    Intent intent = new Intent(CarrinhoActivity.this,InicialActivity.class);
                    startActivity(intent);
                }
            });
            alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "NÃO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    alertDialog.dismiss();
                }
            });

            alertDialog.show();
            //compra.esvaziarCarrinho();
        }
    }

    private boolean gravarPedido(){
        boolean gravou = true;
        String[] mensagem = new String[]{};

        mensagem = new BDControllerCarrinho().salvarCompra(getBaseContext(),compra.getCarrinho(),valorCompra);
        /*
        for (Produto p: compra.getCarrinho()) {
            if(p.getmNome().equals("Açaí")){
                mensagem = new BDControllerCarrinho().salvarAcai(getBaseContext(),(Acai) p);
            } else {
                mensagem = new BDControllerCarrinho().salvarProduto(getBaseContext(),p);
            }
        }*/
        if(!mensagem[0].equals("OK")){
            gravou = false;
            AlertDialog alertDialog = new AlertDialog.Builder(CarrinhoActivity.this).create();
            alertDialog.setMessage(mensagem[1]);
            alertDialog.show();
        }
        return gravou;
    }
}
