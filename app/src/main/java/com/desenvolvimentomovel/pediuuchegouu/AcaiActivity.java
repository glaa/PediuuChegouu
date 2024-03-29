package com.desenvolvimentomovel.pediuuchegouu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.desenvolvimentomovel.pediuuchegouu.sqlite.BDControllerCarrinho;

import java.util.ArrayList;

public class AcaiActivity extends AppCompatActivity implements AcaiAdapter.ItemClicked{

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Acai> acais;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acai);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Açaí");
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_left);
        setSupportActionBar(toolbar);

        //Inventando objetos --------------------------------------------------
        acais = new ArrayList<>();
        Acai acai1 = new Acai("Copo","","300ml",6.00,"2 complementos, 1 fruta, 1 calda",2,1,1,0,null);
        Acai acai2 = new Acai("Tigela","P","300ml",7.00,"3 complementos, 2 frutas, 1 calda",3,2,1,0,null);
        Acai acai3 = new Acai("Tigela","M","400ml",10.00,"4 complementos, 3 frutas, 2 caldas",4,3,2,0,null);
        Acai acai4 = new Acai("Tigela","G","500ml",13.00,"5 complementos, 4 frutas, 3 caldas",5,4,3,0,null);
        Acai acai5 = new Acai("Tigela","GG","800ml",18.00,"7 complementos, 5 frutas, 4 caldas",7,5,4,0,null);
        Acai acai6 = new Acai("Barca","P","600ml",18.00,"4 complementos, 2 frutas, 1 calda, 1 adicional",4,2,1,0,null);
        Acai acai7 = new Acai("Roleta","","1L",30.00,"5 complementos, 4 frutas, 3 calda, 1 adicional",5,4,3,0,null);


        acais.add(acai1); acais.add(acai2); acais.add(acai3); acais.add(acai4); acais.add(acai5); acais.add(acai6); acais.add(acai7);

        //Log.d("ACAI0", new BDControllerCarrinho().salvarAcai(getBaseContext(),acai1)[1]);
        //----------------------------------------------------------------------

        RecyclerView recyclerView = findViewById(R.id.rv_acai);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new AcaiAdapter(this,acais);
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onItemClicked(int index) {
        Acai acai = acais.get(index);
        Intent intent;
        intent = new Intent(AcaiActivity.this, PedirAcaiActivity.class);
        intent.putExtra("acai", acai);
        startActivity(intent);
        //Toast.makeText(this, String.valueOf(index), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
