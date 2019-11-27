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
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);

        favoritos = new ArrayList<>();

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
                AlertDialog alertDialog = new AlertDialog.Builder(CarrinhoActivity.this).create();
                alertDialog.setCanceledOnTouchOutside(false);
                if(verificarUsuarioLogado()){
                    ArrayList<Endereco> enderecos = new Endereco().pegarEnderecos();
                    if(enderecos.isEmpty()){
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
                        alertDialog.setTitle("Pedido realizado!");
                        alertDialog.setMessage("O pedido será entregue em " + enderecos.get(0).getTipo() +
                                            "\n" + enderecos.get(0).getLogradouro() + ", " + enderecos.get(0).getNumero() +
                                            "\n" + enderecos.get(0).getBairro() +
                                            "\n" + enderecos.get(0).getReferencia());
                        alertDialog.setButton(DialogInterface.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(CarrinhoActivity.this,InicialActivity.class);
                                startActivity(intent);
                            }
                        });
                        alertDialog.show();
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
        if(!InicialActivity.preferencias.contains("logado")){
            logado = false;
        }
        return logado;
    }
}
