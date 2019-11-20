package com.desenvolvimentomovel.pediuuchegouu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class ProdutosActivity extends AppCompatActivity implements ProdutoAdapter.ItemClicked {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Produto> produtos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtos);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Cardápio");
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_left);
        setSupportActionBar(toolbar);

        //Inventando dados ----------------------------------
        Produto acai = new Produto("Açaí","Descrição do açai","G",13, null);
        Produto cachorroQuante = new Produto("Cachorro Quente de Pote","Descrição do cachorro quente","M", 5,null);
        Produto batataFrita = new Produto("Batata Frita","Descrição da batata","G",8,null);
        Produto nuggets = new Produto("Nuggets","Descrição dos nuggets","M",7,null);

        produtos = new ArrayList<>();
        produtos.add(acai);
        produtos.add(cachorroQuante);
        produtos.add(batataFrita);
        produtos.add(nuggets);
        //--------------------------------------------------

        recyclerView = findViewById(R.id.rv_produtos);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new ProdutoAdapter(this,produtos);
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onItemClicked(int index) {
        Intent intent;

        switch (index){
            case 0:
                intent = new Intent(ProdutosActivity.this, AcaiActivity.class);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(ProdutosActivity.this, CachorroQuenteActivity.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(ProdutosActivity.this, BataFritaActivity.class);
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(ProdutosActivity.this, NuggetsAcitivity.class);
                startActivity(intent);
                break;

        }
        //Toast.makeText(this, String.valueOf(index), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
