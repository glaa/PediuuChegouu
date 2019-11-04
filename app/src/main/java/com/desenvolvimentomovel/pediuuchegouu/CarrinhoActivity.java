package com.desenvolvimentomovel.pediuuchegouu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
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
}
