package com.desenvolvimentomovel.pediuuchegouu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.desenvolvimentomovel.pediuuchegouu.sqlite.BDControllerEndereco;

import java.util.ArrayList;

public class MeusEnderecosActivity extends AppCompatActivity implements EnderecoAdapter.ItemClicked{

    private RecyclerView.Adapter mAdapter;
    private ArrayList<Endereco> enderecos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_enderecos);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Meus Endereços");
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_left);
        setSupportActionBar(toolbar);

        enderecos = new BDControllerEndereco().buscarEnderecos(getBaseContext(),Preferencias.buscarTelefoneUsuario());

        RecyclerView recyclerView = findViewById(R.id.rv_meus_enderecos);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new EnderecoAdapter(this, enderecos);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onItemClicked(int index) {
        Endereco e = enderecos.get(index);
        Log.d("END0",String.valueOf(index));
        Intent intent =  new Intent();
        intent.putExtra("Endereco", e);
        setResult(RESULT_OK,intent);

        finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
