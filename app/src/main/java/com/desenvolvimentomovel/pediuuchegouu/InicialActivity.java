package com.desenvolvimentomovel.pediuuchegouu;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.widget.Button;
import android.widget.Toast;


public class InicialActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Button btCardapio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);
        //Incluindo o toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        //Definindo o layout do menu lateral
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        //Inserindo o botão menu no toolbar
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        //Definindo o conteiner do menu lateral
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        btCardapio = findViewById(R.id.buttonCardapio);

        btCardapio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InicialActivity.this,ProdutosActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Intent intent;
        switch (item.getItemId()){
            case R.id.nav_favoritos:
                intent = new Intent(this,FavoritosActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_historico:
                intent = new Intent(this, HistoricoActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_sair:
                Toast.makeText(this,"Sair",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_alterar_dados:
                intent = new Intent(this, AlterarDados.class);
                startActivity(intent);
                break;
            case R.id.nav_alterar_senha:
                intent = new Intent(this, AlterarSenha.class);
                startActivity(intent);
                break;
            default:
                super.onOptionsItemSelected(item);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
