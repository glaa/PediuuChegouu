package com.desenvolvimentomovel.pediuuchegouu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class CachorroQuenteActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<CachorroQuente> cachorroQuentes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cachorro_quente);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Cachorro Quente de Pote");
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_left);
        setSupportActionBar(toolbar);

        //Inventando dados ----------------------------------
        cachorroQuentes = new ArrayList<>();
        CachorroQuente b1 = new CachorroQuente("M",5.00,"Pão, molho gourmet de salsicha, milho, ervilha, batata palha, queijo ralado e azeitona.");
        CachorroQuente b2 = new CachorroQuente("G",7.00,"");
        cachorroQuentes.add(b1);
        cachorroQuentes.add(b2);

        TextView descricao = findViewById(R.id.tv_conteudo_cachorro);
        descricao.setText(b1.getConteudo());
        //----------------------------------------------------
        RecyclerView recyclerView = findViewById(R.id.rv_cachorro);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new CachorroQuenteAdapter(this, cachorroQuentes);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
