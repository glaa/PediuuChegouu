package com.desenvolvimentomovel.pediuuchegouu;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.desenvolvimentomovel.pediuuchegouu.sqlite.BDController;
import com.desenvolvimentomovel.pediuuchegouu.utils.MaskEditUtil;
import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText tietTelefone;
    private TextInputEditText tietSenha;
    private Button btEntrar;
    private Button btEsqueci;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Login");
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_left);
        setSupportActionBar(toolbar);

        tietTelefone = findViewById(R.id.tiet_telefone_login);
        tietSenha = findViewById(R.id.tiet_senha_login);
        btEntrar = findViewById(R.id.bt_entrar_login);
        btEsqueci = findViewById(R.id.bt_esqueceu_login);

        tietTelefone.addTextChangedListener(MaskEditUtil.mask(tietTelefone,MaskEditUtil.FORMAT_FONE));

        btEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String telefone, senha;
                boolean ok = true;

                telefone = MaskEditUtil.unmask(tietTelefone.getText().toString());
                senha = tietSenha.getText().toString();

                if(telefone.length() < 11) {
                    tietTelefone.setError("Preenchmento obrigatório! Exemplo: (xx)9xxxx-xxxx");
                    tietTelefone.requestFocus();
                    ok = false;
                } else if(senha.length() < 4){
                    tietSenha.setError("Preenchimento obrigatório com pelo menos 4 caracteres!");
                    tietSenha.requestFocus();
                    ok = false;
                }

                if(ok) {
                    BDController crud = new BDController(getBaseContext());
                    Cursor cursor = crud.autenticarCliente(telefone,senha);

                    if(cursor.getCount() > 0){
                        String nome = cursor.getString(0);
                        String apelido = cursor.getString(1);

                        InicialActivity.salvarUsuario(telefone,nome,apelido);

                        Intent intent = new Intent(LoginActivity.this,InicialActivity.class);
                        startActivity(intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                    }

                }

                    /*
                    final AlertDialog alertDialog = new AlertDialog.Builder(TelaCadastro.this).create();

                    if(mensagem.equals("OK")){
                        alertDialog.setMessage(getApplicationContext().getString(R.string.sql_cliente_cadastrado_sucesso));
                        alertDialog.show();
                    } else {
                        alertDialog.setTitle("Aviso!");
                        if(mensagem.equals("UNIQUE constraint failed: cliente.telefone (code 1555)")){
                            alertDialog.setMessage("Este telefone já possui um cadastro.\n"
                                    +"Deseja fazer login?");
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

                            alertDialog.setMessage("Cadastro não realizado.\n"
                                    + "Tente mais tarde!");
                        }


                        alertDialog.show();
                        Log.d("Cadastr", telefone + " " + nome + " " + apelido + " " + senha
                                + " " + crud.consultarCliente(telefone) + mensagem);
                    }

                }
*/
                //conferirDados(telefone, senha);




            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
