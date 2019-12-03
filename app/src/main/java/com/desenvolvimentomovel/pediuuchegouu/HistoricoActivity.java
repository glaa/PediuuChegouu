package com.desenvolvimentomovel.pediuuchegouu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.desenvolvimentomovel.pediuuchegouu.sqlite.BDControllerCarrinho;

import java.util.ArrayList;

public class HistoricoActivity extends AppCompatActivity implements HistoricoAdapter.ItemClicked{

    private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Histórico");
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_left);
        setSupportActionBar(toolbar);

        ArrayList<Produto> produtos = new ArrayList<>();
        produtos = new BDControllerCarrinho().recuperarProdutos(getBaseContext());

        RecyclerView recyclerView = findViewById(R.id.rv_historico);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new HistoricoAdapter(this, produtos,"");
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onItemClicked(int index) {
        /*Produto produto = produtos.get(index);
        Intent intent;
        Log.i("Batata",produto.getmNome());
        intent = new Intent(BataFritaActivity.this, CarrinhoActivity.class);
        intent.putExtra("Produto", produto);
        startActivity(intent);
        Toast.makeText(this, String.valueOf(index), Toast.LENGTH_SHORT).show();*/
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
