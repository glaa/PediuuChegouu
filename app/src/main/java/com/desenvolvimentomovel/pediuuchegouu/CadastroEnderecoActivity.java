package com.desenvolvimentomovel.pediuuchegouu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class CadastroEnderecoActivity extends AppCompatActivity {

    private TextInputEditText tietNome;
    private TextInputEditText tietLogradouro;
    private TextInputEditText tietNumero;
    private TextInputEditText tietBairro;
    private TextInputEditText tietReferencia;
    private Button btCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_endereco);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Cadastro de Endereço");
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_left);
        setSupportActionBar(toolbar);

        tietNome = findViewById(R.id.tiet_nome_endereco_cadastro);
        tietLogradouro = findViewById(R.id.tiet_logradouro_endereco_cadastro);
        tietNumero = findViewById(R.id.tiet_numero_endereco_cadastro);
        tietBairro = findViewById(R.id.tiet_bairro_endereco_cadastro);
        tietReferencia = findViewById(R.id.tiet_referencia_endereco_cadastro);
        btCadastrar = findViewById(R.id.bt_cadastrar_endereco_cadastro);

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome, logradouro, numero, bairro, referencia;
                boolean ok = true;

                nome = tietNome.getText().toString().trim();
                logradouro = tietLogradouro.getText().toString().trim();
                numero = tietNumero.getText().toString();
                bairro = tietBairro.getText().toString().trim();
                referencia = tietReferencia.getText().toString().trim();

                if(nome.length() < 4){
                    tietNome.setError("Preenchimento obrigatório com pelo menos 4 caracteres!");
                    tietNome.requestFocus();
                    ok = false;
                } else if(logradouro.length() < 4){
                    tietLogradouro.setError("Preenchimento obrigatório com pelo menos 4 caracteres!");
                    tietLogradouro.requestFocus();
                    ok = false;
                } else if(numero.length() < 1){
                    tietNumero.setError("Preenchimento obrigatório com pelo menos 1 dígito!");
                    tietNumero.requestFocus();
                    ok = false;
                } else if(bairro.length() < 4){
                    tietBairro.setError("Preenchimento obrigatório com pelo menos 4 caracteres!");
                    tietBairro.requestFocus();
                    ok = false;
                }

                if(ok){
                    Endereco endereco = new Endereco(nome,logradouro,numero,bairro,referencia);
                    new Endereco().incluirEndereco(endereco);
                    AlertDialog alertDialog = new AlertDialog.Builder(CadastroEnderecoActivity.this).create();
                    alertDialog.setCanceledOnTouchOutside(false);
                    alertDialog.setMessage("Endereço cadastrado!");
                    alertDialog.setButton(DialogInterface.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(CadastroEnderecoActivity.this,EnderecoActivity.class);
                            startActivity(intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                        }
                    });
                    alertDialog.show();
                }
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
