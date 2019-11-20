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

public class NuggetsAcitivity extends AppCompatActivity implements NuggetsAdapter.ItemClicked{

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<Produto> produtos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuggets_acitivity);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Nuggets");
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_left);
        setSupportActionBar(toolbar);

        //Inventando dados ----------------------------------
        produtos = new ArrayList<>();
        Produto b0 = new Produto("Nuggets","Nuggets","P",5.00,null);
        Produto b1 = new Produto("Nuggets","Nuggets","M",7.00,null);
        Produto b2 = new Produto("Nuggets","Nuggets","G",12.00,null);

        produtos.add(b0);
        produtos.add(b1);
        produtos.add(b2);

        TextView descricao = findViewById(R.id.tv_conteudo_nuggets);
        descricao.setText(b1.getmDescricao());
        //----------------------------------------------------
        recyclerView = findViewById(R.id.rv_nuggets);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new NuggetsAdapter(this, produtos);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onItemClicked(int index) {
        Produto produto = produtos.get(index);
        Intent intent;
        Log.i("Cachorro",produto.getmNome());
        intent = new Intent(NuggetsAcitivity.this, CarrinhoActivity.class);
        intent.putExtra("Produto", produto);
        startActivity(intent);
        Toast.makeText(this, String.valueOf(index), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
