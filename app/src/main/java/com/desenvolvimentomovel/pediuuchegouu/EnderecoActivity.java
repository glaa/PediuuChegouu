package com.desenvolvimentomovel.pediuuchegouu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.desenvolvimentomovel.pediuuchegouu.sqlite.BDControllerEndereco;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class EnderecoActivity extends AppCompatActivity implements EnderecoAdapter.ItemClicked{

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private ArrayList<Endereco> enderecos;
    private Button btAdicionar;
    private TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endereco);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Endereços");
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_left);
        setSupportActionBar(toolbar);

        btAdicionar = findViewById(R.id.bt_adicionar_endereco);
        tvInfo = findViewById(R.id.tv_info_endereco);

        enderecos = new BDControllerEndereco().buscarEnderecos(getBaseContext(),Preferencias.buscarTelefoneUsuario());

        //Caso não haja endereço cadastrado
        if(enderecos.isEmpty()){
            tvInfo.setText("Não há endereços cadastrados!");
        }

        RecyclerView recyclerView = findViewById(R.id.rv_enderecos);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new EnderecoAdapter(this, enderecos);
        recyclerView.setAdapter(mAdapter);

        btAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EnderecoActivity.this,CadastroEnderecoActivity.class);
                startActivity(intent);
            }
        });
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
