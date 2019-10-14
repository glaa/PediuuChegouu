package com.desenvolvimentomovel.pediuuchegouu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
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

        //Inventando dados ----------------------------------
        Produto acai = new Produto("Açaí","Descrição do açai","G",13,"acai");
        Produto cachorroQuante = new Produto("Cachorro Quente","Descrição do cachorro quente","M",5,"cachorroQuente");
        Produto batataFrita = new Produto("Batata Frita","Descrição da batata","G",8,"batataFrita");
        Produto nuggets = new Produto("Nuggets","Descrição dos nuggets","M",7, "nuggets");

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

    @Override
    public void onItemClicked(int index) {
        Intent intent;

        switch (index){
            case 0:
                intent = new Intent(ProdutosActivity.this, PedirAcaiActivity.class);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(ProdutosActivity.this, PedirAcaiActivity.class);
                //startActivity(intent);
                break;
            case 2:
                intent = new Intent(ProdutosActivity.this, PedirAcaiActivity.class);
                //startActivity(intent);
                break;
            case 3:
                intent = new Intent(ProdutosActivity.this, PedirAcaiActivity.class);
                //startActivity(intent);
                break;

        }
        Toast.makeText(this, String.valueOf(index), Toast.LENGTH_SHORT).show();
    }
}
