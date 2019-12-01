package com.desenvolvimentomovel.pediuuchegouu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.desenvolvimentomovel.pediuuchegouu.sqlite.BDControllerCarrinho;

import java.util.ArrayList;

public class PedirAcaiActivity extends AppCompatActivity {

    private ImageView minusAmendoim; private TextView qtdAmendoim; private ImageView plusAmendoim;
    private ImageView minusAmendoimG; private TextView qtdAmendoimG; private ImageView plusAmendoimG;
    private ImageView minusAveia; private TextView qtdAveia; private ImageView plusAveia;
    private ImageView minusCerealChoc; private TextView qtdCerealChoc; private ImageView plusCerealChoc;
    private ImageView minusFarinhaAmendoim; private TextView qtdFarinhaAmendoim; private ImageView plusFarinhaAmendoim;
    private ImageView minusFarinhaCastanha; private TextView qtdFarinhaCastanha; private ImageView plusFarinhaCastanha;
    private ImageView minusFarinhaLactea; private TextView qtdFarinhaLactea; private ImageView plusFarinhaLactea;
    private ImageView minusGranola; private TextView qtdGranola; private ImageView plusGranola;
    private ImageView minusGranolaChoco; private TextView qtdGranolaChoco; private ImageView plusGranolaChoco;
    private ImageView minusLeitePo; private TextView qtdLeitePo; private ImageView plusLeitePo;
    private ImageView minusNeston; private TextView qtdNeston; private ImageView plusNeston;
    private ImageView minusPacoca; private TextView qtdPacoca; private ImageView plusPacoca;
    private ImageView minusPacocaFarelo; private TextView qtdPacocaFarelo; private ImageView plusPacocaFarelo;
    private ImageView minusSucrilho; private TextView qtdSucrilho; private ImageView plusSucrilho;
    private TextView maxComplento; private TextView valorTotalComplemento;
    private int complemento;
    private double valorComplemento;
    private int totalComplemento = 0;
    private ImageView minusAbacaxi; private TextView qtdAbacaxi; private ImageView plusAbacaxi;
    private ImageView minusBanana; private TextView qtdBanana; private ImageView plusBanana;
    private ImageView minusKiwi; private TextView qtdKiwi; private ImageView plusKiwi;
    private ImageView minusMaca; private TextView qtdMaca; private ImageView plusMaca;
    private ImageView minusManga; private TextView qtdManga; private ImageView plusManga;
    private ImageView minusMorango; private TextView qtdMorango; private ImageView plusMorango;
    private ImageView minusUva; private TextView qtdUva; private ImageView plusUva;
    private TextView maxFruta; private TextView valorTotalFruta;
    private int fruta;
    private double valorFruta;
    private int totalFruta = 0;
    private ImageView minusCaramelo; private TextView qtdCaramelo; private ImageView plusCaramelo;
    private ImageView minusChocolate; private TextView qtdChocolate; private ImageView plusChocolate;
    private ImageView minusDoceLeite; private TextView qtdDoceLeite; private ImageView plusDoceLeite;
    private ImageView minusFrutaVerm; private TextView qtdFrutaVerm; private ImageView plusFrutaVerm;
    private ImageView minusCaldaLeiteCond; private TextView qtdCaldaLeiteCond; private ImageView plusCaldaLeiteCond;
    private ImageView minusLimao; private TextView qtdLimao; private ImageView plusLimao;
    private ImageView minusMaracuja; private TextView qtdMaracuja; private ImageView plusMaracuja;
    private ImageView minusMel; private TextView qtdMel; private ImageView plusMel;
    private ImageView minusMenta; private TextView qtdMenta; private ImageView plusMenta;
    private ImageView minusCaldaMorango; private TextView qtdCaldaMorango; private ImageView plusCaldaMorango;
    private ImageView minusCaldaUva; private TextView qtdCaldaUva; private ImageView plusCaldaUva;
    private TextView maxCalda; private TextView valorTotalCalda;
    private int calda;
    private double valorCalda;
    private int totalCalda = 0;
    private ImageView minusBatom; private TextView qtdBatom; private ImageView plusBatom;
    private ImageView minusBis; private TextView qtdBis; private ImageView plusBis;
    private ImageView minusChocobal; private TextView qtdChocobal; private ImageView plusChocobal;
    private ImageView minusCremeAvela; private TextView qtdCremeAvela; private ImageView plusCremeAvela;
    private ImageView minusCremeMorango; private TextView qtdCremeMorango; private ImageView plusCremeMorango;
    private ImageView minusCremePitaya; private TextView qtdCremePitaya; private ImageView plusCremePitaya;
    private ImageView minusGotaChocolate; private TextView qtdGotaChocolate; private ImageView plusGotaChocolate;
    private ImageView minusJujuba; private TextView qtdJujuba; private ImageView plusJujuba;
    private ImageView minusKitkat; private TextView qtdKitkat; private ImageView plusKitkat;
    private ImageView minusMarshmallow; private TextView qtdMarshmallow; private ImageView plusMarshmallow;
    private ImageView minusMMs; private TextView qtdMMs; private ImageView plusMMs;
    private ImageView minusOreo; private TextView qtdOreo; private ImageView plusOreo;
    private ImageView minusOuroBranco; private TextView qtdOuroBranco; private ImageView plusOuroBranco;
    private ImageView minusOvomaltine; private TextView qtdOvomaltine; private ImageView plusOvomaltine;
    private ImageView minusChocoRaspa; private TextView qtdChocoRaspa; private ImageView plusChocoRaspa;
    private ImageView minusTortuguita; private TextView qtdTortuguita; private ImageView plusTortuguita;
    private ImageView minusTubosChoc; private TextView qtdTubosChoc; private ImageView plusTubosChoc;
    private TextView maxAdicional; private TextView valorTotalAdicional;
    private int adicional;
    private double valorAdicional;
    private int totalAdicional = 0;
    private double valorTotal = 0;
    private TextView valorTotalAcai;
    private Button btContinuar;
    private ArrayList<Extra> extras;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedir_acai);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Açaí");
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_left);
        setSupportActionBar(toolbar);

        final Acai acai = (Acai) getIntent().getSerializableExtra("acai");
        extras = new Extra().pegarExtra();

        //Inventando complento, adicionais
        /*
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
        */

        //Complementos
        complemento = acai.getQtdComplemento();
        fruta = acai.getQtdFruta();
        calda = acai.getQtdFruta();
        adicional = acai.getQtdAdicionais();
        valorComplemento = 1.00;
        valorFruta = 2.00;
        valorCalda = 1.00;
        valorAdicional = 2.00;

        valorTotalAcai = findViewById(R.id.tv_valorTotalAcai);
        maxComplento = findViewById(R.id.tv_numMaxCompl);
        maxComplento.setText(String.valueOf(complemento));
        valorTotalComplemento = findViewById(R.id.tv_val_complemento);
        minusAmendoim = findViewById(R.id.iv_minus_amendoim); qtdAmendoim = findViewById(R.id.tv_qtd_amendoim);
        plusAmendoim = findViewById(R.id.iv_plus_amendoim);
        minusAmendoimG = findViewById(R.id.iv_minus_amendoimG); qtdAmendoimG = findViewById(R.id.tv_qtd_amendoimG);
        plusAmendoimG = findViewById(R.id.iv_plus_amendimG);
        minusAveia = findViewById(R.id.iv_minus_aveia); qtdAveia = findViewById(R.id.tv_qtd_aveia);
        plusAveia = findViewById(R.id.iv_plus_aveia);
        minusCerealChoc = findViewById(R.id.iv_minus_cer_choc); qtdCerealChoc = findViewById(R.id.tv_qtd_cereal_choc);
        plusCerealChoc = findViewById(R.id.iv_plus_cer_choc);
        minusFarinhaAmendoim = findViewById(R.id.iv_minus_far_amend); qtdFarinhaAmendoim = findViewById(R.id.tv_qtd_far_amendoim);
        plusFarinhaAmendoim = findViewById(R.id.iv_plus_far_amendoim);
        minusFarinhaCastanha = findViewById(R.id.iv_minus_far_castanha); qtdFarinhaCastanha = findViewById(R.id.tv_qtd_far_castanha);
        plusFarinhaCastanha = findViewById(R.id.iv_plus_far_castanha);
        minusFarinhaLactea = findViewById(R.id.iv_minus_far_lactea); qtdFarinhaLactea = findViewById(R.id.tv_qtd_far_lactea);
        plusFarinhaLactea = findViewById(R.id.iv_plus_far_lactea);
        minusGranola = findViewById(R.id.iv_minus_granola); qtdGranola = findViewById(R.id.tv_qtd_granola);
        plusGranola = findViewById(R.id.iv_plus_granola); ;
        minusGranolaChoco = findViewById(R.id.iv_minus_granola_choc); qtdGranolaChoco = findViewById(R.id.tv_qtd_granola_choc);
        plusGranolaChoco = findViewById(R.id.iv_plus_granola_choc);
        minusLeitePo = findViewById(R.id.iv_minus_leite); qtdLeitePo = findViewById(R.id.tv_qtd_leite);
        plusLeitePo = findViewById(R.id.iv_plus_leite);
        minusNeston = findViewById(R.id.iv_minus_neston); qtdNeston = findViewById(R.id.tv_qtd_neston);
        plusNeston = findViewById(R.id.iv_plus_neston);
        minusPacoca = findViewById(R.id.iv_minus_pacoca); qtdPacoca = findViewById(R.id.tv_qtd_pacoca);
        plusPacoca = findViewById(R.id.iv_plus_pacoca);
        minusPacocaFarelo = findViewById(R.id.iv_minus_pacoca_far); qtdPacocaFarelo = findViewById(R.id.tv_qtd_pacoca_far);
        plusPacocaFarelo = findViewById(R.id.iv_plus_pacoca_far);
        minusSucrilho = findViewById(R.id.iv_minus_sucrilho); qtdSucrilho = findViewById(R.id.tv_qtd_sucrilho);
        plusSucrilho = findViewById(R.id.iv_plus_sucrilho);
        maxFruta = findViewById(R.id.tv_numMaxFruta);
        maxFruta.setText(String.valueOf(fruta));
        valorTotalFruta = findViewById(R.id.tv_val_frutas);
        minusAbacaxi = findViewById(R.id.iv_minus_abacaxi); qtdAbacaxi = findViewById(R.id.tv_qtd_abacaxi);
        plusAbacaxi = findViewById(R.id.iv_plus_abacaxi);
        minusBanana = findViewById(R.id.iv_minus_banana); qtdBanana = findViewById(R.id.tv_qtd_banana);
        plusBanana = findViewById(R.id.iv_plus_banana);
        minusKiwi = findViewById(R.id.iv_minus_kiwi); qtdKiwi = findViewById(R.id.tv_qtd_kiwi);
        plusKiwi = findViewById(R.id.iv_plus_kiwi);
        minusMaca = findViewById(R.id.iv_minus_maca); qtdMaca = findViewById(R.id.tv_qtd_maca);
        plusMaca = findViewById(R.id.iv_plus_maca);
        minusManga = findViewById(R.id.iv_minus_manga); qtdManga = findViewById(R.id.tv_qtd_manga);
        plusManga = findViewById(R.id.iv_plus_manga);
        minusMorango = findViewById(R.id.iv_minus_morango); qtdMorango = findViewById(R.id.tv_qtd_morango);
        plusMorango = findViewById(R.id.iv_plus_morango);
        minusUva = findViewById(R.id.iv_minus_uva); qtdUva = findViewById(R.id.tv_qtd_uva);
        plusUva = findViewById(R.id.iv_plus_uva);
        maxCalda = findViewById(R.id.tv_numMaxCalda);
        maxCalda.setText(String.valueOf(calda));
        valorTotalCalda = findViewById(R.id.tv_val_caldas);
        minusCaramelo = findViewById(R.id.iv_minus_calda_caramelo); qtdCaramelo = findViewById(R.id.tv_qtd_calda_caramelo);
        plusCaramelo = findViewById(R.id.iv_plus_calda_caramelo);
        minusChocolate = findViewById(R.id.iv_minus_calda_chocolate); qtdChocolate = findViewById(R.id.tv_qtd_calda_chocolate);
        plusChocolate = findViewById(R.id.iv_plus_calda_chocolate);
        minusDoceLeite = findViewById(R.id.iv_minus_calda_doceLeite); qtdDoceLeite = findViewById(R.id.tv_qtd_calda_doceLeite);
        plusDoceLeite = findViewById(R.id.iv_plus_calda_doceLeite);
        minusFrutaVerm = findViewById(R.id.iv_minus_calda_frutaVerm); qtdFrutaVerm = findViewById(R.id.tv_qtd_calda_frutaVerm);
        plusFrutaVerm = findViewById(R.id.iv_plus_calda_frutaVerm);
        minusCaldaLeiteCond = findViewById(R.id.iv_minus_calda_leiteCond); qtdCaldaLeiteCond = findViewById(R.id.tv_qtd_calda_leiteCond);
        plusCaldaLeiteCond = findViewById(R.id.iv_plus_calda_leiteCond);
        minusLimao = findViewById(R.id.iv_minus_calda_limao); qtdLimao = findViewById(R.id.tv_qtd_calda_limao);
        plusLimao = findViewById(R.id.iv_plus_calda_limao);
        minusMaracuja = findViewById(R.id.iv_minus_calda_maracuja); qtdMaracuja = findViewById(R.id.tv_qtd_calda_maracuja);
        plusMaracuja = findViewById(R.id.iv_plus_calda_maracuja);
        minusMel = findViewById(R.id.iv_minus_calda_mel); qtdMel = findViewById(R.id.tv_qtd_calda_mel);
        plusMel = findViewById(R.id.iv_plus_calda_mel);
        minusMenta = findViewById(R.id.iv_minus_calda_menta); qtdMenta = findViewById(R.id.tv_qtd_calda_menta);
        plusMenta = findViewById(R.id.iv_plus_calda_menta);
        minusCaldaMorango = findViewById(R.id.iv_minus_calda_morango); qtdCaldaMorango = findViewById(R.id.tv_qtd_calda_morango);
        plusCaldaMorango = findViewById(R.id.iv_plus_calda_morango);
        minusCaldaUva = findViewById(R.id.iv_minus_calda_uva); qtdCaldaUva = findViewById(R.id.tv_qtd_calda_uva);
        plusCaldaUva = findViewById(R.id.iv_plus_calda_uva);
        maxAdicional = findViewById(R.id.tv_numMaxAdicionais);
        maxAdicional.setText(String.valueOf(adicional));
        valorTotalAdicional = findViewById(R.id.tv_val_adicionais);
        minusBatom = findViewById(R.id.iv_minus_add_batom); qtdBatom = findViewById(R.id.tv_qtd_add_batom);
        plusBatom = findViewById(R.id.iv_plus_add_batom);
        minusBis = findViewById(R.id.iv_minus_add_bis); qtdBis = findViewById(R.id.tv_qtd_add_bis);
        plusBis = findViewById(R.id.iv_plus_add_bis);
        minusChocobal = findViewById(R.id.iv_minus_add_chocobal); qtdChocobal = findViewById(R.id.tv_qtd_add_chocobal);
        plusChocobal = findViewById(R.id.iv_plus_add_chocobal);
        minusCremeAvela = findViewById(R.id.iv_minus_add_creme_avela); qtdCremeAvela = findViewById(R.id.tv_qtd_add_creme_avela);
        plusCremeAvela = findViewById(R.id.iv_plus_add_creme_avela);
        minusCremeMorango = findViewById(R.id.iv_minus_add_creme_morango); qtdCremeMorango = findViewById(R.id.tv_qtd_add_creme_morango);
        plusCremeMorango = findViewById(R.id.iv_plus_add_creme_morango);
        minusCremePitaya = findViewById(R.id.iv_minus_add_creme_pitaya); qtdCremePitaya = findViewById(R.id.tv_qtd_add_creme_pitaya);
        plusCremePitaya = findViewById(R.id.iv_plus_add_creme_pitaya);
        minusGotaChocolate = findViewById(R.id.iv_minus_add_gota_chocolate); qtdGotaChocolate = findViewById(R.id.tv_qtd_add_gota_chocolate);
        plusGotaChocolate = findViewById(R.id.iv_plus_add_gota_chocolate);
        minusJujuba = findViewById(R.id.iv_minus_add_jujuba); qtdJujuba = findViewById(R.id.tv_qtd_add_jujuba);
        plusJujuba = findViewById(R.id.iv_plus_add_jujuba);
        minusKitkat = findViewById(R.id.iv_minus_add_kitkat); qtdKitkat = findViewById(R.id.tv_qtd_add_kitkat);
        plusKitkat = findViewById(R.id.iv_plus_add_kitkat);
        minusMarshmallow = findViewById(R.id.iv_minus_add_marshmallow); qtdMarshmallow = findViewById(R.id.tv_qtd_add_marshmallow);
        plusMarshmallow = findViewById(R.id.iv_plus_add_marshmallow);
        minusMMs = findViewById(R.id.iv_minus_add_mm); qtdMMs = findViewById(R.id.tv_qtd_add_mm);
        plusMMs = findViewById(R.id.iv_plus_add_mm);
        minusOreo = findViewById(R.id.iv_minus_add_oreo); qtdOreo = findViewById(R.id.tv_qtd_add_oreo);
        plusOreo = findViewById(R.id.iv_plus_add_oreo);
        minusOuroBranco = findViewById(R.id.iv_minus_add_ouro_branco); qtdOuroBranco = findViewById(R.id.tv_qtd_add_ouro_branco);
        plusOuroBranco = findViewById(R.id.iv_plus_add_ouro_branco);
        minusOvomaltine = findViewById(R.id.iv_minus_add_ovo_maltine); qtdOvomaltine = findViewById(R.id.tv_qtd_add_ovo_maltine);
        plusOvomaltine = findViewById(R.id.iv_plus_add_ovo_maltine);
        minusChocoRaspa = findViewById(R.id.iv_minus_add_rasp_chocolate); qtdChocoRaspa = findViewById(R.id.tv_qtd_add_rasp_chocolate);
        plusChocoRaspa = findViewById(R.id.iv_plus_add_rasp_chocolate);
        minusTortuguita = findViewById(R.id.iv_minus_add_tortuguita); qtdTortuguita = findViewById(R.id.tv_qtd_add_tortuguita);
        plusTortuguita = findViewById(R.id.iv_plus_add_tortuguita);
        minusTubosChoc = findViewById(R.id.iv_minus_add_tub_chocolate); qtdTubosChoc = findViewById(R.id.tv_qtd_add_tub_chocolate);
        plusTubosChoc = findViewById(R.id.iv_plus_add_tub_chocolate);
        btContinuar = findViewById(R.id.bt_continuar_acai);
        radioGroup = findViewById(R.id.rg_sabor_pedir);

        //Atualizando valor
        valorTotal = acai.getmPreco();
        valorTotalAcai.setText(String.valueOf(valorTotal));

        minusAmendoim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 1;
                decrementarQtd(qtdAmendoim, valorTotalComplemento, complemento, valorComplemento);
                Extra extra = new Extra(id,"Complemento","Amendoim",valorComplemento,Integer.parseInt(qtdAmendoim.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusAmendoim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 1;
                incrementarQtd(qtdAmendoim, valorTotalComplemento, complemento, valorComplemento);
                Extra extra = new Extra(id,"Complemento","Amendoim",valorComplemento,Integer.parseInt(qtdAmendoim.getText().toString()));
                new Extra().atualizar(extra);
                Log.d("EXT2", new BDControllerCarrinho().salvarExtra(getBaseContext(),extra)[1]);
            }
        });
        minusAmendoimG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 2;
                decrementarQtd(qtdAmendoimG, valorTotalComplemento, complemento, valorComplemento);
                Extra extra = new Extra(id,"Complemento","Amendoim Granulado",valorComplemento,Integer.parseInt(qtdAmendoimG.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusAmendoimG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 2;
                incrementarQtd(qtdAmendoimG, valorTotalComplemento, complemento, valorComplemento);
                Extra extra = new Extra(id,"Complemento","Amendoim Granulado",valorComplemento,Integer.parseInt(qtdAmendoimG.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusAveia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 3;
                decrementarQtd(qtdAveia, valorTotalComplemento, complemento, valorComplemento);
                Extra extra = new Extra(id,"Complemento","Aveia",valorComplemento,Integer.parseInt(qtdAveia.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusAveia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 3;
                incrementarQtd(qtdAveia, valorTotalComplemento, complemento, valorComplemento);
                Extra extra = new Extra(id,"Complemento","Aveia",valorComplemento,Integer.parseInt(qtdAveia.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusCerealChoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 4;
                decrementarQtd(qtdCerealChoc, valorTotalComplemento, complemento, valorComplemento);
                Extra extra = new Extra(id,"Complemento","Cereal de Chocolate",valorComplemento,Integer.parseInt(qtdCerealChoc.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusCerealChoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 4;
                incrementarQtd(qtdCerealChoc, valorTotalComplemento, complemento, valorComplemento);
                Extra extra = new Extra(id,"Complemento","Cereal de Chocolate",valorComplemento,Integer.parseInt(qtdCerealChoc.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusFarinhaAmendoim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 5;
                decrementarQtd(qtdFarinhaAmendoim, valorTotalComplemento, complemento, valorComplemento);
                Extra extra = new Extra(id,"Complemento","Farinha de Amendoim",valorComplemento,Integer.parseInt(qtdFarinhaAmendoim.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusFarinhaAmendoim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 5;
                incrementarQtd(qtdFarinhaAmendoim, valorTotalComplemento, complemento, valorComplemento);
                Extra extra = new Extra(id,"Complemento","Farinha de Amendoim",valorComplemento,Integer.parseInt(qtdFarinhaAmendoim.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusFarinhaCastanha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 6;
                decrementarQtd(qtdFarinhaCastanha, valorTotalComplemento, complemento, valorComplemento);
                Extra extra = new Extra(id,"Complemento","Farinha de Castanha",valorComplemento,Integer.parseInt(qtdFarinhaCastanha.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusFarinhaCastanha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 6;
                incrementarQtd(qtdFarinhaCastanha, valorTotalComplemento, complemento, valorComplemento);
                Extra extra = new Extra(id,"Complemento","Farinha de Castanha",valorComplemento,Integer.parseInt(qtdFarinhaCastanha.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusFarinhaLactea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 7;
                decrementarQtd(qtdFarinhaLactea, valorTotalComplemento, complemento, valorComplemento);
                Extra extra = new Extra(id,"Complemento","Farinha Lactea",valorComplemento,Integer.parseInt(qtdFarinhaLactea.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusFarinhaLactea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 7;
                incrementarQtd(qtdFarinhaLactea, valorTotalComplemento, complemento, valorComplemento);
                Extra extra = new Extra(id,"Complemento","Farinha Lactea",valorComplemento,Integer.parseInt(qtdFarinhaLactea.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusGranola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 8;
                decrementarQtd(qtdGranola, valorTotalComplemento, complemento, valorComplemento);
                Extra extra = new Extra(id,"Complemento","Granola",valorComplemento,Integer.parseInt(qtdGranola.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusGranola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 8;
                incrementarQtd(qtdGranola, valorTotalComplemento, complemento, valorComplemento);
                Extra extra = new Extra(id,"Complemento","Granola",valorComplemento,Integer.parseInt(qtdGranola.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusGranolaChoco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 9;
                decrementarQtd(qtdGranolaChoco, valorTotalComplemento, complemento, valorComplemento);
                Extra extra = new Extra(id,"Complemento","Granola de chocolate",valorComplemento,Integer.parseInt(qtdGranolaChoco.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusGranolaChoco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 9;
                incrementarQtd(qtdGranolaChoco, valorTotalComplemento, complemento, valorComplemento);
                Extra extra = new Extra(id,"Complemento","Granola de chocolate",valorComplemento,Integer.parseInt(qtdGranolaChoco.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusLeitePo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 10;
                decrementarQtd(qtdLeitePo, valorTotalComplemento, complemento, valorComplemento);
                Extra extra = new Extra(id,"Complemento","Leite em Pó",valorComplemento,Integer.parseInt(qtdLeitePo.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusLeitePo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 10;
                incrementarQtd(qtdLeitePo, valorTotalComplemento, complemento, valorComplemento);
                Extra extra = new Extra(id,"Complemento","Leite em Pó",valorComplemento,Integer.parseInt(qtdLeitePo.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusNeston.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 11;
                decrementarQtd(qtdNeston, valorTotalComplemento, complemento, valorComplemento);
                Extra extra = new Extra(id,"Complemento","Neston",valorComplemento,Integer.parseInt(qtdNeston.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusNeston.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 11;
                incrementarQtd(qtdNeston, valorTotalComplemento, complemento, valorComplemento);
                Extra extra = new Extra(id,"Complemento","Neston",valorComplemento,Integer.parseInt(qtdNeston.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusPacoca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 12;
                decrementarQtd(qtdPacoca, valorTotalComplemento, complemento, valorComplemento);
                Extra extra = new Extra(id,"Complemento","Paçoca",valorComplemento,Integer.parseInt(qtdPacoca.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusPacoca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 12;
                incrementarQtd(qtdPacoca, valorTotalComplemento, complemento, valorComplemento);
                Extra extra = new Extra(id,"Complemento","Paçoca",valorComplemento,Integer.parseInt(qtdPacoca.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusPacocaFarelo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 13;
                decrementarQtd(qtdPacocaFarelo, valorTotalComplemento, complemento, valorComplemento);
                Extra extra = new Extra(id,"Complemento","Paçoca Farelinho",valorComplemento,Integer.parseInt(qtdPacocaFarelo.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusPacocaFarelo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 13;
                incrementarQtd(qtdPacocaFarelo, valorTotalComplemento, complemento, valorComplemento);
                Extra extra = new Extra(id,"Complemento","Paçoca Farelinho",valorComplemento,Integer.parseInt(qtdPacocaFarelo.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusSucrilho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 14;
                decrementarQtd(qtdSucrilho, valorTotalComplemento, complemento, valorComplemento);
                Extra extra = new Extra(id,"Complemento","Sucrilho",valorComplemento,Integer.parseInt(qtdSucrilho.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusSucrilho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 14;
                incrementarQtd(qtdSucrilho, valorTotalComplemento, complemento, valorComplemento);
                Extra extra = new Extra(id,"Complemento","Sucrilho",valorComplemento,Integer.parseInt(qtdSucrilho.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusAbacaxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 15;
                decrementarQtdFruta(qtdAbacaxi, valorTotalFruta, fruta, valorFruta);
                Extra extra = new Extra(id,"Fruta","Abacaxi",valorComplemento,Integer.parseInt(qtdAbacaxi.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusAbacaxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 15;
                incrementarQtdFruta(qtdAbacaxi, valorTotalFruta, fruta, valorFruta);
                Extra extra = new Extra(id,"Fruta","Abacaxi",valorComplemento,Integer.parseInt(qtdAbacaxi.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusBanana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 16;
                decrementarQtdFruta(qtdBanana, valorTotalFruta, fruta, valorFruta);
                Extra extra = new Extra(id,"Fruta","Banana",valorComplemento,Integer.parseInt(qtdBanana.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusBanana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 16;
                incrementarQtdFruta(qtdBanana, valorTotalFruta, fruta, valorFruta);
                Extra extra = new Extra(id,"Fruta","Banana",valorComplemento,Integer.parseInt(qtdBanana.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusKiwi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 17;
                decrementarQtdFruta(qtdKiwi, valorTotalFruta, fruta, valorFruta);
                Extra extra = new Extra(id,"Fruta","Kiwi",valorComplemento,Integer.parseInt(qtdKiwi.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusKiwi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 17;
                incrementarQtdFruta(qtdKiwi, valorTotalFruta, fruta, valorFruta);
                Extra extra = new Extra(id,"Fruta","Kiwi",valorComplemento,Integer.parseInt(qtdKiwi.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusMaca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 18;
                decrementarQtdFruta(qtdMaca, valorTotalFruta, fruta, valorFruta);
                Extra extra = new Extra(id,"Fruta","Maçã",valorComplemento,Integer.parseInt(qtdMaca.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusMaca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 18;
                incrementarQtdFruta(qtdMaca, valorTotalFruta, fruta, valorFruta);
                Extra extra = new Extra(id,"Fruta","Maçã",valorComplemento,Integer.parseInt(qtdMaca.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusManga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 19;
                decrementarQtdFruta(qtdManga, valorTotalFruta, fruta, valorFruta);
                Extra extra = new Extra(id,"Fruta","Manga",valorComplemento,Integer.parseInt(qtdManga.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusManga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 19;
                incrementarQtdFruta(qtdManga, valorTotalFruta, fruta, valorFruta);
                Extra extra = new Extra(id,"Fruta","Manga",valorComplemento,Integer.parseInt(qtdManga.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusMorango.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 20;
                decrementarQtdFruta(qtdMorango, valorTotalFruta, fruta, valorFruta);
                Extra extra = new Extra(id,"Fruta","Morango",valorComplemento,Integer.parseInt(qtdMorango.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusMorango.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 20;
                incrementarQtdFruta(qtdMorango, valorTotalFruta, fruta, valorFruta);
                Extra extra = new Extra(id,"Fruta","Morango",valorComplemento,Integer.parseInt(qtdMorango.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusUva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 21;
                decrementarQtdFruta(qtdUva, valorTotalFruta, fruta, valorFruta);
                Extra extra = new Extra(id,"Fruta","Uva",valorComplemento,Integer.parseInt(qtdUva.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusUva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 21;
                incrementarQtdFruta(qtdUva, valorTotalFruta, fruta, valorFruta);
                Extra extra = new Extra(id,"Fruta","Uva",valorComplemento,Integer.parseInt(qtdUva.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusCaramelo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 22;
                decrementarQtdCalda(qtdCaramelo, valorTotalCalda, calda, valorCalda);
                Extra extra = new Extra(id,"Calda","Caramelo",valorComplemento,Integer.parseInt(qtdCaramelo.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusCaramelo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 22;
                incrementarQtdCalda(qtdCaramelo, valorTotalCalda, calda, valorCalda);
                Extra extra = new Extra(id,"Calda","Caramelo",valorComplemento,Integer.parseInt(qtdCaramelo.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusChocolate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 23;
                decrementarQtdCalda(qtdChocolate, valorTotalCalda, calda, valorCalda);
                Extra extra = new Extra(id,"Calda","Chocolate",valorComplemento,Integer.parseInt(qtdChocolate.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusChocolate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 23;
                incrementarQtdCalda(qtdChocolate, valorTotalCalda, calda, valorCalda);
                Extra extra = new Extra(id,"Calda","Chocolate",valorComplemento,Integer.parseInt(qtdChocolate.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusDoceLeite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 24;
                decrementarQtdCalda(qtdDoceLeite, valorTotalCalda, calda, valorCalda);
                Extra extra = new Extra(id,"Calda","Doce de leite",valorComplemento,Integer.parseInt(qtdDoceLeite.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusDoceLeite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 24;
                incrementarQtdCalda(qtdDoceLeite, valorTotalCalda, calda, valorCalda);
                Extra extra = new Extra(id,"Calda","Doce de leite",valorComplemento,Integer.parseInt(qtdDoceLeite.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusFrutaVerm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 25;
                decrementarQtdCalda(qtdFrutaVerm, valorTotalCalda, calda, valorCalda);
                Extra extra = new Extra(id,"Calda","Fruta Vermelha",valorComplemento,Integer.parseInt(qtdFrutaVerm.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusFrutaVerm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 25;
                incrementarQtdCalda(qtdFrutaVerm, valorTotalCalda, calda, valorCalda);
                Extra extra = new Extra(id,"Calda","Fruta Vermelha",valorComplemento,Integer.parseInt(qtdFrutaVerm.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusCaldaLeiteCond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 26;
                decrementarQtdCalda(qtdCaldaLeiteCond, valorTotalCalda, calda, valorCalda);
                Extra extra = new Extra(id,"Calda","Leite Condensado",valorComplemento,Integer.parseInt(qtdCaldaLeiteCond.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusCaldaLeiteCond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 26;
                incrementarQtdCalda(qtdCaldaLeiteCond, valorTotalCalda, calda, valorCalda);
                Extra extra = new Extra(id,"Calda","Leite Condensado",valorComplemento,Integer.parseInt(qtdCaldaLeiteCond.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusLimao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 27;
                decrementarQtdCalda(qtdLimao, valorTotalCalda, calda, valorCalda);
                Extra extra = new Extra(id,"Calda","Limão",valorComplemento,Integer.parseInt(qtdLimao.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusLimao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 27;
                incrementarQtdCalda(qtdLimao, valorTotalCalda, calda, valorCalda);
                Extra extra = new Extra(id,"Calda","Limão",valorComplemento,Integer.parseInt(qtdLimao.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusMaracuja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 28;
                decrementarQtdCalda(qtdMaracuja, valorTotalCalda, calda, valorCalda);
                Extra extra = new Extra(id,"Calda","Maracujá",valorComplemento,Integer.parseInt(qtdMaracuja.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusMaracuja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 28;
                incrementarQtdCalda(qtdMaracuja, valorTotalCalda, calda, valorCalda);
                Extra extra = new Extra(id,"Calda","Maracujá",valorComplemento,Integer.parseInt(qtdMaracuja.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusMel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 29;
                decrementarQtdCalda(qtdMel, valorTotalCalda, calda, valorCalda);
                Extra extra = new Extra(id,"Calda","Mel",valorComplemento,Integer.parseInt(qtdMel.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusMel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 29;
                incrementarQtdCalda(qtdMel, valorTotalCalda, calda, valorCalda);
                Extra extra = new Extra(id,"Calda","Mel",valorComplemento,Integer.parseInt(qtdMel.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusMenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 30;
                decrementarQtdCalda(qtdMenta, valorTotalCalda, calda, valorCalda);
                Extra extra = new Extra(id,"Calda","Menta",valorComplemento,Integer.parseInt(qtdMenta.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusMenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 30;
                incrementarQtdCalda(qtdMenta, valorTotalCalda, calda, valorCalda);
                Extra extra = new Extra(id,"Calda","Menta",valorComplemento,Integer.parseInt(qtdMenta.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusCaldaMorango.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 31;
                decrementarQtdCalda(qtdCaldaMorango, valorTotalCalda, calda, valorCalda);
                Extra extra = new Extra(id,"Calda","Morango",valorComplemento,Integer.parseInt(qtdCaldaMorango.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusCaldaMorango.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 31;
                incrementarQtdCalda(qtdCaldaMorango, valorTotalCalda, calda, valorCalda);
                Extra extra = new Extra(id,"Calda","Morango",valorComplemento,Integer.parseInt(qtdCaldaMorango.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusCaldaUva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 32;
                decrementarQtdCalda(qtdCaldaUva, valorTotalCalda, calda, valorCalda);
                Extra extra = new Extra(id,"Calda","Uva",valorComplemento,Integer.parseInt(qtdCaldaUva.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusCaldaUva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 32;
                incrementarQtdCalda(qtdCaldaUva, valorTotalCalda, calda, valorCalda);
                Extra extra = new Extra(id,"Calda","Uva",valorComplemento,Integer.parseInt(qtdCaldaUva.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusBatom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 33;
                decrementarQtdAdd(qtdBatom, valorTotalAdicional, adicional, valorAdicional);
                Extra extra = new Extra(id,"Adicional","Batom",valorComplemento,Integer.parseInt(qtdBatom.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusBatom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 33;
                incrementarQtdAdd(qtdBatom, valorTotalAdicional, adicional, valorAdicional);
                Extra extra = new Extra(id,"Adicional","Batom",valorComplemento,Integer.parseInt(qtdBatom.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusBis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 34;
                decrementarQtdAdd(qtdBis, valorTotalAdicional, adicional, valorAdicional);
                Extra extra = new Extra(id,"Adicional","Bis",valorComplemento,Integer.parseInt(qtdBis.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusBis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 34;
                incrementarQtdAdd(qtdBis, valorTotalAdicional, adicional, valorAdicional);
                Extra extra = new Extra(id,"Adicional","Bis",valorComplemento,Integer.parseInt(qtdBis.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusChocobal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 35;
                decrementarQtdAdd(qtdChocobal, valorTotalAdicional, adicional, valorAdicional);
                Extra extra = new Extra(id,"Adicional","Chocobal",valorComplemento,Integer.parseInt(qtdChocobal.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusChocobal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 35;
                incrementarQtdAdd(qtdChocobal, valorTotalAdicional, adicional, valorAdicional);
                Extra extra = new Extra(id,"Adicional","Chocobal",valorComplemento,Integer.parseInt(qtdChocobal.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusCremeAvela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 36;
                decrementarQtdAdd(qtdCremeAvela, valorTotalAdicional, adicional, valorAdicional);
                Extra extra = new Extra(id,"Adicional","Creme de Avelã",valorComplemento,Integer.parseInt(qtdCremeAvela.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusCremeAvela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 36;
                incrementarQtdAdd(qtdCremeAvela, valorTotalAdicional, adicional, valorAdicional);
                Extra extra = new Extra(id,"Adicional","Creme de Avelã",valorComplemento,Integer.parseInt(qtdCremeAvela.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusCremeMorango.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 37;
                decrementarQtdAdd(qtdCremeMorango, valorTotalAdicional, adicional, valorAdicional);
                Extra extra = new Extra(id,"Adicional","Creme de Morango",valorComplemento,Integer.parseInt(qtdCremeMorango.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusCremeMorango.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 37;
                incrementarQtdAdd(qtdCremeMorango, valorTotalAdicional, adicional, valorAdicional);
                Extra extra = new Extra(id,"Adicional","Creme de Morango",valorComplemento,Integer.parseInt(qtdCremeMorango.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusCremePitaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 38;
                decrementarQtdAdd(qtdCremePitaya, valorTotalAdicional, adicional, valorAdicional);
                Extra extra = new Extra(id,"Adicional","Creme de Pitaya",valorComplemento,Integer.parseInt(qtdCremePitaya.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusCremePitaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 38;
                incrementarQtdAdd(qtdCremePitaya, valorTotalAdicional, adicional, valorAdicional);
                Extra extra = new Extra(id,"Adicional","Creme de Pitaya",valorComplemento,Integer.parseInt(qtdCremePitaya.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusGotaChocolate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 39;
                decrementarQtdAdd(qtdGotaChocolate, valorTotalAdicional, adicional, valorAdicional);
                Extra extra = new Extra(id,"Adicional","Gota de Chocolate",valorComplemento,Integer.parseInt(qtdGotaChocolate.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusGotaChocolate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 39;
                incrementarQtdAdd(qtdGotaChocolate, valorTotalAdicional, adicional, valorAdicional);
                Extra extra = new Extra(id,"Adicional","Gota de Chocolate",valorComplemento,Integer.parseInt(qtdGotaChocolate.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusJujuba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 40;
                decrementarQtdAdd(qtdJujuba, valorTotalAdicional, adicional, valorAdicional);
                Extra extra = new Extra(id,"Adicional","Jujuba",valorComplemento,Integer.parseInt(qtdJujuba.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusJujuba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 40;
                incrementarQtdAdd(qtdJujuba, valorTotalAdicional, adicional, valorAdicional);
                Extra extra = new Extra(id,"Adicional","Jujuba",valorComplemento,Integer.parseInt(qtdJujuba.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusKitkat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 41;
                decrementarQtdAdd(qtdKitkat, valorTotalAdicional, adicional, valorAdicional);
                Extra extra = new Extra(id,"Adicional","Kitkat",valorComplemento,Integer.parseInt(qtdKitkat.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusKitkat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 41;
                incrementarQtdAdd(qtdKitkat, valorTotalAdicional, adicional, valorAdicional);
                Extra extra = new Extra(id,"Adicional","Kitkat",valorComplemento,Integer.parseInt(qtdKitkat.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusMarshmallow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 42;
                decrementarQtdAdd(qtdMarshmallow, valorTotalAdicional, adicional, valorAdicional);
                Extra extra = new Extra(id,"Adicional","Marshmallow",valorComplemento,Integer.parseInt(qtdMarshmallow.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusMarshmallow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 42;
                incrementarQtdAdd(qtdMarshmallow, valorTotalAdicional, adicional, valorAdicional);
                Extra extra = new Extra(id,"Adicional","Marshmallow",valorComplemento,Integer.parseInt(qtdMarshmallow.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusMMs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 43;
                decrementarQtdAdd(qtdMMs, valorTotalAdicional, adicional, valorAdicional);
                Extra extra = new Extra(id,"Adicional","MMs",valorComplemento,Integer.parseInt(qtdMMs.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusMMs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 43;
                incrementarQtdAdd(qtdMMs, valorTotalAdicional, adicional, valorAdicional);
                Extra extra = new Extra(id,"Adicional","MMs",valorComplemento,Integer.parseInt(qtdMMs.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusOreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 44;
                decrementarQtdAdd(qtdOreo, valorTotalAdicional, adicional, valorAdicional);
                Extra extra = new Extra(id,"Adicional","Oreo",valorComplemento,Integer.parseInt(qtdOreo.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusOreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 44;
                incrementarQtdAdd(qtdOreo, valorTotalAdicional, adicional, valorAdicional);
                Extra extra = new Extra(id,"Adicional","Oreo",valorComplemento,Integer.parseInt(qtdOreo.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusOuroBranco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 45;
                decrementarQtdAdd(qtdOuroBranco, valorTotalAdicional, adicional, valorAdicional);
                Extra extra = new Extra(id,"Adicional","Ouro Branco",valorComplemento,Integer.parseInt(qtdOuroBranco.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusOuroBranco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 45;
                incrementarQtdAdd(qtdOuroBranco, valorTotalAdicional, adicional, valorAdicional);
                Extra extra = new Extra(id,"Adicional","Ouro Branco",valorComplemento,Integer.parseInt(qtdOuroBranco.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusOvomaltine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 46;
                decrementarQtdAdd(qtdOvomaltine, valorTotalAdicional, adicional, valorAdicional);
                Extra extra = new Extra(id,"Adicional","Ovomaltine",valorComplemento,Integer.parseInt(qtdOvomaltine.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusOvomaltine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 46;
                incrementarQtdAdd(qtdOvomaltine, valorTotalAdicional, adicional, valorAdicional);
                Extra extra = new Extra(id,"Adicional","Ovomaltine",valorComplemento,Integer.parseInt(qtdOvomaltine.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusChocoRaspa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 47;
                decrementarQtdAdd(qtdChocoRaspa, valorTotalAdicional, adicional, valorAdicional);
                Extra extra = new Extra(id,"Adicional","Chocolate em Raspas",valorComplemento,Integer.parseInt(qtdChocoRaspa.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusChocoRaspa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 47;
                incrementarQtdAdd(qtdChocoRaspa, valorTotalAdicional, adicional, valorAdicional);
                Extra extra = new Extra(id,"Adicional","Chocolate em Raspas",valorComplemento,Integer.parseInt(qtdChocoRaspa.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusTortuguita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 48;
                decrementarQtdAdd(qtdTortuguita, valorTotalAdicional, adicional, valorAdicional);
                Extra extra = new Extra(id,"Adicional","Tortuguita",valorComplemento,Integer.parseInt(qtdTortuguita.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusTortuguita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 48;
                incrementarQtdAdd(qtdTortuguita, valorTotalAdicional, adicional, valorAdicional);
                Extra extra = new Extra(id,"Adicional","Tortuguita",valorComplemento,Integer.parseInt(qtdTortuguita.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        minusTubosChoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 49;
                decrementarQtdAdd(qtdTubosChoc, valorTotalAdicional, adicional, valorAdicional);
                Extra extra = new Extra(id,"Adicional","Tubinhos de Chocolate",valorComplemento,Integer.parseInt(qtdTubosChoc.getText().toString()));
                new Extra().atualizar(extra);
            }
        });
        plusTubosChoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 49;
                incrementarQtdAdd(qtdTubosChoc, valorTotalAdicional, adicional, valorAdicional);
                Extra extra = new Extra(id,"Adicional","Tubinhos de Chocolate",valorComplemento,Integer.parseInt(qtdTubosChoc.getText().toString()));
                new Extra().atualizar(extra);
            }
        });

        btContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radioGroup.getCheckedRadioButtonId() == -1){
                    AlertDialog alertDialog = new AlertDialog.Builder(PedirAcaiActivity.this).create();
                    alertDialog.setTitle("Aviso!");
                    alertDialog.setMessage("Escolha um sabor para prosseguir com o pedido.");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL,"OK", (Message) null);
                    alertDialog.show();
                } else {
                    int escolha = radioGroup.getCheckedRadioButtonId();
                    Log.d("EXTRA1",String.valueOf(radioGroup.getCheckedRadioButtonId()) + " - "+String.valueOf(escolha));
                    if(escolha == R.id.rb_acai){
                        RadioButton rb = findViewById(escolha);
                        acai.setSabor(rb.getText().toString());
                    } else if(escolha == R.id.rb_casadinha){
                        RadioButton rb = findViewById(escolha);
                        acai.setSabor(rb.getText().toString());
                    } else if(escolha == R.id.rb_cupuacu){
                        RadioButton rb = findViewById(escolha);
                        acai.setSabor(rb.getText().toString());
                    }

                    acai.setmDescricao(criarDescricao());
                    acai.setmPreco(Double.parseDouble(valorTotalAcai.getText().toString()));

                    Intent intent = new Intent(PedirAcaiActivity.this,CarrinhoActivity.class);
                    intent.putExtra("Produto",acai);
                    startActivity(intent);
                }
            }
        });
    }
    private void incrementarQtd(TextView quantidade, TextView valor, int qtdComplemento, double valorComplemento){
        int qtdAdicionada;
        double valorParcial = Double.valueOf(valor.getText().toString());
        qtdAdicionada = Integer.parseInt(quantidade.getText().toString());
        if(qtdAdicionada < 2){
            qtdAdicionada++;
            quantidade.setText(String.valueOf(qtdAdicionada));
            totalComplemento++;
            if(totalComplemento > qtdComplemento) {
                valorParcial += valorComplemento;
                valor.setText(String.valueOf(valorParcial));
                valorTotal += valorComplemento;
                valorTotalAcai.setText(String.valueOf(valorTotal));
            }
        }
    }

    private void decrementarQtd(TextView quantidade, TextView valor, int qtdComplemento, double valorComplemento){
        int qtdAdicionada;
        double valorParcial = Double.valueOf(valor.getText().toString());
        qtdAdicionada = Integer.parseInt(quantidade.getText().toString());
        if(qtdAdicionada>0){
            if(totalComplemento > qtdComplemento){
                valorParcial -= valorComplemento;
                valor.setText(String.valueOf(valorParcial));
                valorTotal-=valorComplemento;
                qtdAdicionada--;
                quantidade.setText(String.valueOf(qtdAdicionada));
                totalComplemento--;
                valorTotalAcai.setText(String.valueOf(valorTotal));
            }else{
                qtdAdicionada--;
                quantidade.setText(String.valueOf(qtdAdicionada));
                totalComplemento--;
            }
        }
    }
    private void incrementarQtdFruta(TextView quantidade, TextView valor, int qtdFruta, double valorFruta){
        int qtdAdicionada;
        double valorParcial = Double.valueOf(valor.getText().toString());
        qtdAdicionada = Integer.parseInt(quantidade.getText().toString());
        if(qtdAdicionada < 2){
            qtdAdicionada++;
            quantidade.setText(String.valueOf(qtdAdicionada));
            totalFruta++;
            if(totalFruta > qtdFruta) {
                valorParcial += valorFruta;
                valor.setText(String.valueOf(valorParcial));
                valorTotal += valorFruta;
                valorTotalAcai.setText(String.valueOf(valorTotal));
            }
        }
    }

    private void decrementarQtdFruta(TextView quantidade, TextView valor, int qtdFruta, double valorComplemento){
        int qtdAdicionada;
        double valorParcial = Double.valueOf(valor.getText().toString());
        qtdAdicionada = Integer.parseInt(quantidade.getText().toString());
        if(qtdAdicionada>0){
            if(totalFruta > qtdFruta){
                valorParcial -= valorFruta;
                valor.setText(String.valueOf(valorParcial));
                valorTotal-=valorFruta;
                qtdAdicionada--;
                quantidade.setText(String.valueOf(qtdAdicionada));
                totalFruta--;
                valorTotalAcai.setText(String.valueOf(valorTotal));
            }else{
                qtdAdicionada--;
                quantidade.setText(String.valueOf(qtdAdicionada));
                totalFruta--;
            }
        }
    }
    private void incrementarQtdCalda(TextView quantidade, TextView valor, int qtdCalda, double valorCalda){
        int qtdAdicionada;
        double valorParcial = Double.valueOf(valor.getText().toString());
        qtdAdicionada = Integer.parseInt(quantidade.getText().toString());
        if(qtdAdicionada < 2){
            qtdAdicionada++;
            quantidade.setText(String.valueOf(qtdAdicionada));
            totalCalda++;
            if(totalCalda > qtdCalda) {
                valorParcial += valorCalda;
                valor.setText(String.valueOf(valorParcial));
                valorTotal += valorCalda;
                valorTotalAcai.setText(String.valueOf(valorTotal));
            }
        }
    }

    private void decrementarQtdCalda(TextView quantidade, TextView valor, int qtdCalda, double valorCalda){
        int qtdAdicionada;
        double valorParcial = Double.valueOf(valor.getText().toString());
        qtdAdicionada = Integer.parseInt(quantidade.getText().toString());
        if(qtdAdicionada>0){
            if(totalCalda > qtdCalda){
                valorParcial -= valorCalda;
                valor.setText(String.valueOf(valorParcial));
                valorTotal-=valorCalda;
                qtdAdicionada--;
                quantidade.setText(String.valueOf(qtdAdicionada));
                totalCalda--;
                valorTotalAcai.setText(String.valueOf(valorTotal));
            }else{
                qtdAdicionada--;
                quantidade.setText(String.valueOf(qtdAdicionada));
                totalCalda--;
            }
        }
    }
    private void incrementarQtdAdd(TextView quantidade, TextView valor, int qtdAdicional, double valorAdicional){
        int qtdAdicionada;
        double valorParcial = Double.valueOf(valor.getText().toString());
        qtdAdicionada = Integer.parseInt(quantidade.getText().toString());
        if(qtdAdicionada < 2){
            qtdAdicionada++;
            quantidade.setText(String.valueOf(qtdAdicionada));
            totalAdicional++;
            if(totalAdicional > qtdAdicional) {
                valorParcial += valorAdicional;
                valor.setText(String.valueOf(valorParcial));
                valorTotal += valorAdicional;
                valorTotalAcai.setText(String.valueOf(valorTotal));
            }
        }
    }

    private void decrementarQtdAdd(TextView quantidade, TextView valor, int qtdAdicional, double valorAdicional) {
        int qtdAdicionada;
        double valorParcial = Double.valueOf(valor.getText().toString());
        qtdAdicionada = Integer.parseInt(quantidade.getText().toString());
        if (qtdAdicionada > 0) {
            if (totalAdicional > qtdAdicional) {
                valorParcial -= valorAdicional;
                valor.setText(String.valueOf(valorParcial));
                valorTotal -= valorAdicional;
                qtdAdicionada--;
                quantidade.setText(String.valueOf(qtdAdicionada));
                totalAdicional--;
                valorTotalAcai.setText(String.valueOf(valorTotal));
            } else {
                qtdAdicionada--;
                quantidade.setText(String.valueOf(qtdAdicionada));
                totalAdicional--;
            }
        }
    }

    private String criarDescricao(){
        String descricao = "";
        for (Extra e:extras) {
            descricao +=  e.getQuantidade()+ " " + e.getNome() + ". ";
        }
        return descricao;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}