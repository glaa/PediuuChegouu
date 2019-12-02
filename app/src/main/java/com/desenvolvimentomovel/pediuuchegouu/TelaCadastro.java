package com.desenvolvimentomovel.pediuuchegouu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.desenvolvimentomovel.pediuuchegouu.sqlite.BDControllerCliente;
import com.desenvolvimentomovel.pediuuchegouu.utils.MaskEditUtil;
import com.google.android.material.textfield.TextInputEditText;

public class TelaCadastro extends AppCompatActivity {

    private TextInputEditText tietTelefone;
    private TextInputEditText tietNome;
    private TextInputEditText tietApelido;
    private TextInputEditText tietSenha;
    private Button btCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Cadastro");
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_left);
        setSupportActionBar(toolbar);

        tietTelefone = findViewById(R.id.tiet_telefone);
        tietNome = findViewById(R.id.tiet_nome);
        tietApelido = findViewById(R.id.tiet_apelido);
        tietSenha = findViewById(R.id.tiet_senha);
        btCadastrar = findViewById(R.id.bt_cadastrar_cadastro);

        tietTelefone.addTextChangedListener(MaskEditUtil.mask(tietTelefone,MaskEditUtil.FORMAT_FONE));

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String telefone, nome, apelido, senha;
                boolean ok = true;

                telefone = MaskEditUtil.unmask(tietTelefone.getText().toString());
                nome = tietNome.getText().toString().trim();
                apelido = tietApelido.getText().toString().trim();
                senha = tietSenha.getText().toString();

                if(telefone.length() < 11){
                    tietTelefone.setError("Preenchmento obrigatório! Exemplo: (xx)9xxxx-xxxx");
                    tietTelefone.requestFocus();
                    ok = false;
                } else if(nome.length() < 4){
                    tietNome.setError("Preenchimento obrigatório com pelo menos 4 caracteres!");
                    tietNome.requestFocus();
                    ok = false;
                } else if(senha.length() < 4){
                    tietSenha.setError("Preenchimento obrigatório com pelo menos 4 caracteres!");
                    tietSenha.requestFocus();
                    ok = false;
                }

                if(ok) {
                    BDControllerCliente crud = new BDControllerCliente();
                    String[] mensagem = crud.inserirCliente(getBaseContext(),telefone,nome,apelido,senha);
                    final AlertDialog alertDialog = new AlertDialog.Builder(TelaCadastro.this).create();
                    alertDialog.setCanceledOnTouchOutside(false);

                    if(mensagem[0].equals("OK")){
                        alertDialog.setMessage(getApplicationContext().getString(R.string.sql_cliente_cadastrado_sucesso));

                        alertDialog.setButton(DialogInterface.BUTTON_NEUTRAL, mensagem[1], new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(TelaCadastro.this,LoginActivity.class);
                                intent.putExtra("telefone",telefone);
                                startActivity(intent);
                                finish();
                            }
                        });
                        alertDialog.show();

                    } else {
                        alertDialog.setTitle("Aviso!");
                        if(mensagem[0].equals("TELEFONE")){
                            alertDialog.setMessage(mensagem[1]);
                            alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Não", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    alertDialog.dismiss();
                                    tietTelefone.requestFocus();
                                }
                            });

                            alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Sim", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(TelaCadastro.this,LoginActivity.class);
                                    intent.putExtra("telefone",telefone);
                                    startActivity(intent);
                                    finish();
                                }
                            });
                        } else {

                            alertDialog.setMessage(mensagem[1]);
                        }


                        alertDialog.show();
                        //Log.d("Cadastr", telefone + " " + nome + " " + apelido + " " + senha
                         //       + " " + crud.consultarCliente(telefone) + mensagem);
                    }

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
