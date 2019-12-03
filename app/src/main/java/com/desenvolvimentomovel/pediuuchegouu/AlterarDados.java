package com.desenvolvimentomovel.pediuuchegouu;
import androidx.appcompat.app.AppCompatActivity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.desenvolvimentomovel.pediuuchegouu.sqlite.BDContrato;
import com.desenvolvimentomovel.pediuuchegouu.sqlite.BDLocal;
import com.google.android.material.textfield.TextInputEditText;


public class AlterarDados extends AppCompatActivity {

    private TextInputEditText et_nomeAtual;
    private TextInputEditText et_apelidoAtual;
    private Button bt_confirmar;
    private BDLocal bdLocal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_dados);

        et_nomeAtual = findViewById(R.id.editText_nomeAtual);
        et_apelidoAtual = findViewById(R.id.editText_apelidoAtual);
        bt_confirmar = findViewById(R.id.button_confirmar);

        String telefone = Preferencias.buscarTelefoneUsuario();
        if (telefone != null){
            et_nomeAtual.setText(telefone);
        }

        bt_confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }
}
