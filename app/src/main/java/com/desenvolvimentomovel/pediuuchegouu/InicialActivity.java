package com.desenvolvimentomovel.pediuuchegouu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;

import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class InicialActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Button btCardapio;
    public static SharedPreferences preferencias;
    private boolean usuarioLogado;
    private TextView tvTitulo;
    private TextView tvSubtitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);

        preferencias = getSharedPreferences("preferencias_usuario",MODE_PRIVATE);

        usuarioLogado = verificarUsuarioLogado();

        if(usuarioLogado){
            setContentView(R.layout.activity_inicial);
            Log.d("INIacti", "foi");

        } else {
            Log.d("INIacti","delogado 1");

            setContentView(R.layout.activity_inicial_deslogado);
        }

        //BDController crud = new BDController(getBaseContext());
        //String inserir = crud.inserirCliente("88900002222", "João Teste", "Testador");
        //Log.d("INIns",inserir);
        //Cursor cursor = crud.carregarCliente();
        //Log.d("INIn",cursor.getString(0) + " " + cursor.getString(1) + " " + cursor.getString(2));


        //Incluindo o toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        //Definindo o layout do menu lateral
        DrawerLayout drawer;
        if(usuarioLogado){
            drawer = findViewById(R.id.drawer_layout);
        } else {
            drawer = findViewById(R.id.drawer_layout_deslogado);
        }

        //Inserindo o botão menu no toolbar
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //Definindo o conteiner do menu lateral
        NavigationView navigationView;
        if(usuarioLogado){
            navigationView = findViewById(R.id.nav_view);
        } else {
            navigationView = findViewById(R.id.nav_view_deslogado);
        }
        navigationView.setNavigationItemSelectedListener(this);

        //Personalizando menu de acordo com o login

        personalizarMenu(usuarioLogado,navigationView);

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
        DrawerLayout drawer;
        if(usuarioLogado){
            drawer = findViewById(R.id.drawer_layout);
        } else {
            drawer = findViewById(R.id.drawer_layout_deslogado);
        }

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
                apagarUsuario();
                intent = new Intent(this, InicialActivity.class);
                startActivity(intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                //setContentView(R.layout.activity_inicial_deslogado);
                break;
            case R.id.nav_alterar_dados:
                intent = new Intent(this, AlterarDados.class);
                startActivity(intent);
                break;
            case R.id.nav_alterar_senha:
                intent = new Intent(this, AlterarSenha.class);
                startActivity(intent);
                break;
            case R.id.nav_entrar:
                intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_cadastro:
                intent = new Intent(this, TelaCadastro.class);
                startActivity(intent);
                break;

            case R.id.nav_alterar_endereco:
                intent = new Intent(this,EnderecoActivity.class);
                startActivity(intent);
            default:
                super.onOptionsItemSelected(item);
        }
        DrawerLayout drawer;
        if(usuarioLogado){
            drawer = findViewById(R.id.drawer_layout);
        } else {
            drawer = findViewById(R.id.drawer_layout_deslogado);
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private boolean verificarUsuarioLogado(){
        boolean logado = true;
        if(!preferencias.contains("logado")){
            logado = false;
        }
        return logado;
    }

    private void personalizarMenu(boolean logado, NavigationView navigationView){
        View header = navigationView.getHeaderView(0);
        TextView titulo;
        TextView subtitulo;

        if(logado){
            titulo = header.findViewById(R.id.tv_titulo_header);
            subtitulo = header.findViewById(R.id.tv_subtitulo_header);
            String apelido = preferencias.getString("apelido","");
            if(apelido.length() > 0){
                titulo.setText(preferencias.getString("apelido",":)"));
            } else {
                titulo.setText(preferencias.getString("nome",":)"));
            }
            subtitulo.setText(preferencias.getString("telefone","Não reconheci seu número :("));
        }
    }

    public static void salvarUsuario(String telefone, String nome, String apelido){
        SharedPreferences.Editor editor = InicialActivity.preferencias.edit();
        String telefoneFormatado = "("+telefone.substring(0,2)+")"
                                    +telefone.substring(2,7)+"-"
                                    +telefone.substring(7,11);
        editor.putString("telefone",telefoneFormatado);
        editor.putString("nome",nome);
        editor.putString("apelido",apelido);
        editor.putBoolean("logado",true);
        editor.apply();
    }

    private void apagarUsuario(){
        SharedPreferences.Editor editor = preferencias.edit();
        editor.clear();
        editor.apply();
        Log.d("INIactia", "apagado");
    }
}
