package com.desenvolvimentomovel.pediuuchegouu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class BataFritaActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<BatataFrita> batatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bata_frita);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Batata Frita");
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_left);
        setSupportActionBar(toolbar);

        //Inventando dados ----------------------------------
        batatas = new ArrayList<>();
        BatataFrita b1 = new BatataFrita("M",5.00,"Porção: Batata,Queijo ralado e Cheddar.");
        BatataFrita b2 = new BatataFrita("G",8.00,"");
        batatas.add(b1);
        batatas.add(b2);
        //----------------------------------------------------
        RecyclerView recyclerView = findViewById(R.id.rv_batata);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new BatataFritaAdapter(this,batatas);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
