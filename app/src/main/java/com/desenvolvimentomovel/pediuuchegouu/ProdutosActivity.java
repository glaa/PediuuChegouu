package com.desenvolvimentomovel.pediuuchegouu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import java.util.ArrayList;

public class ProdutosActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Produto> produtos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtos);

        //Inventando dados ----------------------------------
        Produto acai = new Produto("Açaí","acai");
        Produto cachorroQuante = new Produto("Cachorro Quente","cachorroQuente");
        Produto batataFrita = new Produto("Batata Frita","batataFrita");
        Produto nuggets = new Produto("Nuggets", "nuggets");

        produtos = new ArrayList<>();
        produtos.add(acai);
        produtos.add(cachorroQuante);
        produtos.add(batataFrita);
        produtos.add(nuggets);
        //--------------------------------------------------

        RecyclerView recyclerView = findViewById(R.id.rv_produtos);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new ProdutoAdapter(this,produtos);
        recyclerView.setAdapter(mAdapter);

    }
}
