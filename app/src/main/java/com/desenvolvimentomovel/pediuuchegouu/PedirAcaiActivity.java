package com.desenvolvimentomovel.pediuuchegouu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PedirAcaiActivity extends AppCompatActivity {

    private ImageView minusAmendoim;
    private TextView qtdAmendoim;
    private ImageView plusAmendoim;
    private TextView valorAmendoim;
    private ImageView minusAmendoimG;
    private TextView qtdAmendoimG;
    private ImageView plusAmendoimG;
    private TextView valorAmendoimG;
    private ImageView minusAveia;
    private TextView qtdAveia;
    private ImageView plusAveia;
    private TextView valorAveia;
    private ImageView minusCerealChoc;
    private TextView qtdCerealChoc;
    private ImageView plusCerealChoc;
    private TextView valorCerealChoc;
    private ImageView minusFarinhaAmendoim;
    private TextView qtdFarinhaAmendoim;
    private ImageView plusFarinhaAmendoim;
    private TextView valorFarinhaAmendoim;
    private ImageView minusFarinhaCastanha;
    private TextView qtdFarinhaCastanha;
    private ImageView plusFarinhaCastanha;
    private TextView valorFarinhaCastanha;
    private ImageView minusFarinhaLactea;
    private TextView qtdFarinhaLactea;
    private ImageView plusFarinhaLactea;
    private TextView valorFarinhaLactea;
    private ImageView minusGranola;
    private TextView qtdGranola;
    private ImageView plusGranola;
    private TextView valorGranola;
    private ImageView minusGranolaChoco;
    private TextView qtdGranolaChoco;
    private ImageView plusGranolaChoco;
    private TextView valorGranolaChoco;
    private ImageView minusLeite;
    private TextView qtdLeite;
    private ImageView plusLeite;
    private TextView valorLeite;
    private ImageView minusNeston;
    private TextView qtdNeston;
    private ImageView plusNeston;
    private TextView valorNeston;
    private ImageView minusPacoca;
    private TextView qtdPacoca;
    private ImageView plusPacoca;
    private TextView valorPacoca;
    private ImageView minusPacocaFarelo;
    private TextView qtdPacocaFarelo;
    private ImageView plusPacocaFarelo;
    private TextView valorPacocaFarelo;
    private ImageView minusSucrilho;
    private TextView qtdSucrilho;
    private ImageView plusSucrilho;
    private TextView valorSucrilho;
    private TextView maxComplento;
    private int complemento;
    private double valorComplemento;
    private int totalComplemento = 0;
    private double valorTotal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedir_acai);

        Acai acai = (Acai) getIntent().getSerializableExtra("acai");

        //Inventando complento, adicionais
        Extra ex1 = new Extra(1,"Complemento","Amendoim",1.00);
        Extra ex2 = new Extra(2,"Complemento","Amendoim Granulado",1.00);
        Extra ex3 = new Extra(3,"Complemento","Aveia",1.00);
        Extra ex4 = new Extra(4,"Complemento","Cereal de Chocolate",1.00);
        Extra ex5 = new Extra(5,"Complemento","Farinha de Amendoim",1.00);
        Extra ex6 = new Extra(6,"Fruta","Abacaxi",2.00);
        Extra ex7 = new Extra(7,"Fruta","Banana",2.00);
        Extra ex8 = new Extra(8,"Calda","Caramelo",1.00);
        Extra ex9 = new Extra(9,"Calda","Chocolate",1.00);
        Extra ex10 = new Extra(10,"Adicional","Oreo",2.00);


        //Complementos
        complemento = acai.getQtdComplemento();
        valorComplemento = ex1.getPreco();

        maxComplento = findViewById(R.id.tv_numMaxCompl);
        maxComplento.setText(String.valueOf(complemento));
        minusAmendoim = findViewById(R.id.iv_minus_amendoim);
        qtdAmendoim = findViewById(R.id.tv_qtd_amendoim);
        plusAmendoim = findViewById(R.id.iv_plus_amendoim);
        valorAmendoim = findViewById(R.id.tv_val_amendoim);
        minusAmendoimG = findViewById(R.id.iv_minus_amendoimG);
        qtdAmendoimG = findViewById(R.id.tv_qtd_amendoimG);
        plusAmendoimG = findViewById(R.id.iv_plus_amendimG);
        valorAmendoimG = findViewById(R.id.tv_val_amendoimG);
        minusAveia = findViewById(R.id.iv_minus_aveia);
        qtdAveia = findViewById(R.id.tv_qtd_aveia);
        plusAveia = findViewById(R.id.iv_plus_aveia);
        valorAveia = findViewById(R.id.tv_val_aveia);
        minusCerealChoc = findViewById(R.id.iv_minus_cer_choc);
        qtdCerealChoc = findViewById(R.id.tv_qtd_cereal_choc);
        plusCerealChoc = findViewById(R.id.iv_plus_cer_choc);
        valorCerealChoc = findViewById(R.id.tv_val_cer_choc);
        minusFarinhaAmendoim = findViewById(R.id.iv_minus_far_amend);
        qtdFarinhaAmendoim = findViewById(R.id.tv_qtd_far_amendoim);
        plusFarinhaAmendoim = findViewById(R.id.iv_plus_far_amendoim);
        valorFarinhaAmendoim = findViewById(R.id.tv_val_far_amendoim);
        minusFarinhaCastanha = findViewById(R.id.iv_minus_far_castanha);
        qtdFarinhaCastanha = findViewById(R.id.tv_qtd_far_castanha);
        plusFarinhaCastanha = findViewById(R.id.iv_plus_far_castanha);
        valorFarinhaCastanha = findViewById(R.id.tv_val_far_castanha);
        minusFarinhaLactea = findViewById(R.id.iv_minus_far_lactea);
        qtdFarinhaLactea = findViewById(R.id.tv_qtd_far_lactea);
        plusFarinhaLactea = findViewById(R.id.iv_plus_far_lactea);
        valorFarinhaLactea = findViewById(R.id.tv_val_far_lactea);
        minusGranola = findViewById(R.id.iv_minus_granola);
        qtdGranola = findViewById(R.id.tv_qtd_granola);
        plusGranola = findViewById(R.id.iv_plus_granola);
        valorGranola = findViewById(R.id.tv_val_granola);
        minusGranolaChoco = findViewById(R.id.iv_minus_granola_choc);
        qtdGranolaChoco = findViewById(R.id.tv_qtd_granola_choc);
        plusGranolaChoco = findViewById(R.id.iv_plus_granola_choc);
        valorGranolaChoco = findViewById(R.id.tv_val_granola_choc);
        minusLeite = findViewById(R.id.iv_minus_leite);
        qtdLeite = findViewById(R.id.tv_qtd_leite);
        plusLeite = findViewById(R.id.iv_plus_leite);
        valorLeite = findViewById(R.id.tv_val_leite);
        minusNeston = findViewById(R.id.iv_minus_neston);
        qtdNeston = findViewById(R.id.tv_qtd_neston);
        plusNeston = findViewById(R.id.iv_plus_neston);
        valorNeston = findViewById(R.id.tv_val_neston);
        minusPacoca = findViewById(R.id.iv_minus_pacoca);
        qtdPacoca = findViewById(R.id.tv_qtd_pacoca);
        plusPacoca = findViewById(R.id.iv_plus_pacoca);
        valorPacoca = findViewById(R.id.tv_val_pacoca);
        minusPacocaFarelo = findViewById(R.id.iv_minus_pacoca_far);
        qtdPacocaFarelo = findViewById(R.id.tv_qtd_pacoca_far);
        plusPacocaFarelo = findViewById(R.id.iv_plus_pacoca_far);
        valorPacocaFarelo = findViewById(R.id.tv_val_pacoca_far);
        minusSucrilho = findViewById(R.id.iv_minus_sucrilho);
        qtdSucrilho = findViewById(R.id.tv_qtd_sucrilho);
        plusSucrilho = findViewById(R.id.iv_plus_sucrilho);
        valorSucrilho = findViewById(R.id.tv_val_sucrilho);

        minusAmendoim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtd(qtdAmendoim, valorAmendoim, complemento, valorComplemento);
            }
        });
        plusAmendoim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtd(qtdAmendoim, valorAmendoim, complemento, valorComplemento);
            }
        });
        minusAmendoimG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtd(qtdAmendoimG, valorAmendoimG, complemento, valorComplemento);
            }
        });
        plusAmendoimG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtd(qtdAmendoimG, valorAmendoimG, complemento, valorComplemento);
            }
        });
        minusAveia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtd(qtdAveia, valorAveia, complemento, valorComplemento);
            }
        });
        plusAveia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtd(qtdAveia, valorAveia, complemento, valorComplemento);
            }
        });
        minusCerealChoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtd(qtdCerealChoc, valorCerealChoc, complemento, valorComplemento);
            }
        });
        plusCerealChoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtd(qtdCerealChoc, valorCerealChoc, complemento, valorComplemento);
            }
        });
        minusFarinhaAmendoim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtd(qtdFarinhaAmendoim, valorFarinhaAmendoim, complemento, valorComplemento);
            }
        });
        plusFarinhaAmendoim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtd(qtdFarinhaAmendoim, valorFarinhaAmendoim, complemento, valorComplemento);
            }
        });
        minusFarinhaCastanha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtd(qtdFarinhaCastanha, valorFarinhaCastanha, complemento, valorComplemento);
            }
        });
        plusFarinhaCastanha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtd(qtdFarinhaCastanha, valorFarinhaCastanha, complemento, valorComplemento);
            }
        });
        minusFarinhaLactea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtd(qtdFarinhaLactea, valorFarinhaLactea, complemento, valorComplemento);
            }
        });
        plusFarinhaLactea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtd(qtdFarinhaLactea, valorFarinhaLactea, complemento, valorComplemento);
            }
        });
        minusGranola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtd(qtdGranola, valorGranola, complemento, valorComplemento);
            }
        });
        plusGranola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtd(qtdGranola, valorGranola, complemento, valorComplemento);
            }
        });
        minusGranolaChoco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtd(qtdGranolaChoco, valorGranolaChoco, complemento, valorComplemento);
            }
        });
        plusGranolaChoco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtd(qtdGranolaChoco, valorGranolaChoco, complemento, valorComplemento);
            }
        });
        minusLeite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtd(qtdLeite, valorLeite, complemento, valorComplemento);
            }
        });
        plusLeite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtd(qtdLeite, valorLeite, complemento, valorComplemento);
            }
        });
        minusNeston.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtd(qtdNeston, valorNeston, complemento, valorComplemento);
            }
        });
        plusNeston.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtd(qtdNeston, valorNeston, complemento, valorComplemento);
            }
        });
        minusPacoca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtd(qtdPacoca, valorPacoca, complemento, valorComplemento);
            }
        });
        plusPacoca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtd(qtdPacoca, valorPacoca, complemento, valorComplemento);
            }
        });
        minusPacocaFarelo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtd(qtdPacocaFarelo, valorPacocaFarelo, complemento, valorComplemento);
            }
        });
        plusPacocaFarelo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtd(qtdPacocaFarelo, valorPacocaFarelo, complemento, valorComplemento);
            }
        });
        minusSucrilho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtd(qtdSucrilho, valorSucrilho, complemento, valorComplemento);
            }
        });
        plusSucrilho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtd(qtdSucrilho, valorSucrilho, complemento, valorComplemento);
            }
        });
    }
    private void incrementarQtd(TextView quantidade, TextView valor, int qtdComplemto, double valorComplemento){
        int qtdAdicionada;
        double valorParcial = Double.valueOf(valor.getText().toString());
        qtdAdicionada = Integer.parseInt(quantidade.getText().toString());
        if(qtdAdicionada>=qtdComplemto || totalComplemento > qtdComplemto){
            valorParcial += valorComplemento;
            valor.setText(String.valueOf(valorParcial));
            valorTotal += valorParcial;
        }
        qtdAdicionada++;
        quantidade.setText(String.valueOf(qtdAdicionada));
        totalComplemento++;

    }

    private void decrementarQtd(TextView quantidade, TextView valor, int qtdComplemto, double valorComplemento){
        int qtdAdicionada;
        double valorParcial = Double.valueOf(valor.getText().toString());
        qtdAdicionada = Integer.parseInt(quantidade.getText().toString());
        if(qtdAdicionada > 0) {
            qtdAdicionada--;
            quantidade.setText(String.valueOf(qtdAdicionada));
            if (valorParcial > 0) {
                valorParcial -= valorComplemento;
                valor.setText(String.valueOf(valorParcial));
                totalComplemento--;
            }
        }
    }
}
