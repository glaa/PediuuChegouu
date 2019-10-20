package com.desenvolvimentomovel.pediuuchegouu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class NuggetsAcitivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<CachorroQuente> nuggets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuggets_acitivity);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Nuggets");
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_left);
        setSupportActionBar(toolbar);

        //Inventando dados ----------------------------------
        nuggets = new ArrayList<>();
        CachorroQuente b0 = new CachorroQuente("P",5.00,"Nuggets");
        CachorroQuente b1 = new CachorroQuente("M",7.00,"Nuggets");
        CachorroQuente b2 = new CachorroQuente("G",12.00,"");
        nuggets.add(b0);
        nuggets.add(b1);
        nuggets.add(b2);

        TextView descricao = findViewById(R.id.tv_conteudo_nuggets);
        descricao.setText(b1.getConteudo());
        //----------------------------------------------------
        RecyclerView recyclerView = findViewById(R.id.rv_nuggets);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new CachorroQuenteAdapter(this, nuggets);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
