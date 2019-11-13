package com.desenvolvimentomovel.pediuuchegouu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;

public class LoginActivity extends AppCompatActivity {

    private TextView tvTelefone;
    private TextView tvSenha;
    private Button btEntrar;
    private Button btCadastro;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Login");
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_left);
        setSupportActionBar(toolbar);

        tvTelefone = findViewById(R.id.tv_telefone_login);
        tvSenha = findViewById(R.id.tv_senha_login);
        btEntrar = findViewById(R.id.bt_entrar_login);
        btCadastro = findViewById(R.id.bt_cadastro_login);

        btEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tvTelefone.getText().toString().length() == 0){
                    tvTelefone.setError("Obrigatório o preenchimento do telefone");
                    tvTelefone.requestFocus();
                    return;
                }

                if(tvSenha.getText().toString().length() == 0){
                    tvSenha.setError("Obrigatório o preenchimento da senha");
                    tvSenha.requestFocus();
                    return;
                }

                String telefone = tvTelefone.getText().toString();
                String senha = tvSenha.getText().toString();

                //conferirDados(telefone, senha);

                InicialActivity.salvarUsuario(telefone);

                Intent intent = new Intent(LoginActivity.this,InicialActivity.class);
                startActivity(intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
