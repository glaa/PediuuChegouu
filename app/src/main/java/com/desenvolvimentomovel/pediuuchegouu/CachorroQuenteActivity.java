package com.desenvolvimentomovel.pediuuchegouu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class CachorroQuenteActivity extends AppCompatActivity implements CachorroQuenteAdapter.ItemClicked{

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<Produto> produtos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cachorro_quente);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Cachorro Quente de Pote");
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_left);
        setSupportActionBar(toolbar);

        //Inventando dados ----------------------------------
        produtos = new ArrayList<>();
        Produto b1 = new Produto("Cachorro Quente de Pote","Pão, molho gourmet de salsicha, milho, ervilha, batata palha, queijo ralado e azeitona.","M",5.00,"",null);
        Produto b2 = new Produto("Cachorro Quente de Pote"," ","G",7.00,"",null);
        produtos.add(b1);
        produtos.add(b2);

        TextView descricao = findViewById(R.id.tv_conteudo_cachorro);
        descricao.setText(b1.getmDescricao());
        //----------------------------------------------------
        recyclerView = findViewById(R.id.rv_cachorro);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new CachorroQuenteAdapter(this, produtos);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onItemClicked(int index) {
        Produto produto = produtos.get(index);
        Intent intent;
        intent = new Intent(CachorroQuenteActivity.this, CarrinhoActivity.class);
        intent.putExtra("Produto", produto);
        startActivity(intent);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
