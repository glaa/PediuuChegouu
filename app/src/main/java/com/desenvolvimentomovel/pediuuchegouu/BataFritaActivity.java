package com.desenvolvimentomovel.pediuuchegouu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class BataFritaActivity extends AppCompatActivity implements BatataFritaAdapter.ItemClicked {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<Produto> produtos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bata_frita);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Batata Frita");
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_left);
        setSupportActionBar(toolbar);

        //Inventando dados ----------------------------------
        produtos = new ArrayList<>();
        Produto b1 = new Produto("Batata Frita","Porção: Batata, queijo ralado e cheddar.","M",5.00,null);
        Produto b2 = new Produto("Batata Frita","Porção: Batata, queijo ralado e cheddar.","G",8.00,null);
        produtos.add(b1);
        produtos.add(b2);

        TextView descricao = findViewById(R.id.tv_conteudo_batata);
        descricao.setText(b1.getmDescricao());
        //----------------------------------------------------
        RecyclerView recyclerView = findViewById(R.id.rv_batata);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new BatataFritaAdapter(this, produtos);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onItemClicked(int index) {
        Produto produto = produtos.get(index);
        Intent intent;
        Log.i("Batata",produto.getmNome());
        intent = new Intent(BataFritaActivity.this, CarrinhoActivity.class);
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
