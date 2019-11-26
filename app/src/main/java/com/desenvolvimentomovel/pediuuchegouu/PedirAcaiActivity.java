package com.desenvolvimentomovel.pediuuchegouu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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
        fruta = acai.getQtdFruta();
        calda = acai.getQtdFruta();
        adicional = acai.getQtdAdicionais();
        valorComplemento = ex1.getPreco();
        valorFruta = ex6.getPreco();
        valorCalda = ex8.getPreco();
        valorAdicional = ex10.getPreco();

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

        minusAmendoim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtd(qtdAmendoim, valorTotalComplemento, complemento, valorComplemento);
            }
        });
        plusAmendoim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtd(qtdAmendoim, valorTotalComplemento, complemento, valorComplemento);
            }
        });
        minusAmendoimG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtd(qtdAmendoimG, valorTotalComplemento, complemento, valorComplemento);
            }
        });
        plusAmendoimG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtd(qtdAmendoimG, valorTotalComplemento, complemento, valorComplemento);
            }
        });
        minusAveia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtd(qtdAveia, valorTotalComplemento, complemento, valorComplemento);
            }
        });
        plusAveia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtd(qtdAveia, valorTotalComplemento, complemento, valorComplemento);
            }
        });
        minusCerealChoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtd(qtdCerealChoc, valorTotalComplemento, complemento, valorComplemento);
            }
        });
        plusCerealChoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtd(qtdCerealChoc, valorTotalComplemento, complemento, valorComplemento);
            }
        });
        minusFarinhaAmendoim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtd(qtdFarinhaAmendoim, valorTotalComplemento, complemento, valorComplemento);
            }
        });
        plusFarinhaAmendoim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtd(qtdFarinhaAmendoim, valorTotalComplemento, complemento, valorComplemento);
            }
        });
        minusFarinhaCastanha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtd(qtdFarinhaCastanha, valorTotalComplemento, complemento, valorComplemento);
            }
        });
        plusFarinhaCastanha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtd(qtdFarinhaCastanha, valorTotalComplemento, complemento, valorComplemento);
            }
        });
        minusFarinhaLactea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtd(qtdFarinhaLactea, valorTotalComplemento, complemento, valorComplemento);
            }
        });
        plusFarinhaLactea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtd(qtdFarinhaLactea, valorTotalComplemento, complemento, valorComplemento);
            }
        });
        minusGranola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtd(qtdGranola, valorTotalComplemento, complemento, valorComplemento);
            }
        });
        plusGranola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtd(qtdGranola, valorTotalComplemento, complemento, valorComplemento);
            }
        });
        minusGranolaChoco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtd(qtdGranolaChoco, valorTotalComplemento, complemento, valorComplemento);
            }
        });
        plusGranolaChoco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtd(qtdGranolaChoco, valorTotalComplemento, complemento, valorComplemento);
            }
        });
        minusLeitePo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtd(qtdLeitePo, valorTotalComplemento, complemento, valorComplemento);
            }
        });
        plusLeitePo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtd(qtdLeitePo, valorTotalComplemento, complemento, valorComplemento);
            }
        });
        minusNeston.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtd(qtdNeston, valorTotalComplemento, complemento, valorComplemento);
            }
        });
        plusNeston.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtd(qtdNeston, valorTotalComplemento, complemento, valorComplemento);
            }
        });
        minusPacoca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtd(qtdPacoca, valorTotalComplemento, complemento, valorComplemento);
            }
        });
        plusPacoca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtd(qtdPacoca, valorTotalComplemento, complemento, valorComplemento);
            }
        });
        minusPacocaFarelo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtd(qtdPacocaFarelo, valorTotalComplemento, complemento, valorComplemento);
            }
        });
        plusPacocaFarelo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtd(qtdPacocaFarelo, valorTotalComplemento, complemento, valorComplemento);
            }
        });
        minusSucrilho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtd(qtdSucrilho, valorTotalComplemento, complemento, valorComplemento);
            }
        });
        plusSucrilho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtd(qtdSucrilho, valorTotalComplemento, complemento, valorComplemento);
            }
        });
        minusAbacaxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtdFruta(qtdAbacaxi, valorTotalFruta, fruta, valorFruta);
            }
        });
        plusAbacaxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtdFruta(qtdAbacaxi, valorTotalFruta, fruta, valorFruta);
            }
        });
        minusBanana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtdFruta(qtdBanana, valorTotalFruta, fruta, valorFruta);
            }
        });
        plusBanana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtdFruta(qtdBanana, valorTotalFruta, fruta, valorFruta);
            }
        });
        minusKiwi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtdFruta(qtdKiwi, valorTotalFruta, fruta, valorFruta);
            }
        });
        plusKiwi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtdFruta(qtdKiwi, valorTotalFruta, fruta, valorFruta);
            }
        });
        minusMaca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtdFruta(qtdMaca, valorTotalFruta, fruta, valorFruta);
            }
        });
        plusMaca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtdFruta(qtdMaca, valorTotalFruta, fruta, valorFruta);
            }
        });
        minusManga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtdFruta(qtdManga, valorTotalFruta, fruta, valorFruta);
            }
        });
        plusManga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtdFruta(qtdManga, valorTotalFruta, fruta, valorFruta);
            }
        });
        minusMorango.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtdFruta(qtdMorango, valorTotalFruta, fruta, valorFruta);
            }
        });
        plusMorango.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtdFruta(qtdMorango, valorTotalFruta, fruta, valorFruta);
            }
        });
        minusUva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtdFruta(qtdUva, valorTotalFruta, fruta, valorFruta);
            }
        });
        plusUva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtdFruta(qtdUva, valorTotalFruta, fruta, valorFruta);
            }
        });
        minusCaramelo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtdCalda(qtdCaramelo, valorTotalCalda, calda, valorCalda);
            }
        });
        plusCaramelo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtdCalda(qtdCaramelo, valorTotalCalda, calda, valorCalda);
            }
        });
        minusChocolate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtdCalda(qtdChocolate, valorTotalCalda, calda, valorCalda);
            }
        });
        plusChocolate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtdCalda(qtdChocolate, valorTotalCalda, calda, valorCalda);
            }
        });
        minusDoceLeite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtdCalda(qtdDoceLeite, valorTotalCalda, calda, valorCalda);
            }
        });
        plusDoceLeite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtdCalda(qtdDoceLeite, valorTotalCalda, calda, valorCalda);
            }
        });
        minusFrutaVerm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtdCalda(qtdFrutaVerm, valorTotalCalda, calda, valorCalda);
            }
        });
        plusFrutaVerm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtdCalda(qtdFrutaVerm, valorTotalCalda, calda, valorCalda);
            }
        });
        minusCaldaLeiteCond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtdCalda(qtdCaldaLeiteCond, valorTotalCalda, calda, valorCalda);
            }
        });
        plusCaldaLeiteCond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtdCalda(qtdCaldaLeiteCond, valorTotalCalda, calda, valorCalda);
            }
        });
        minusLimao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtdCalda(qtdLimao, valorTotalCalda, calda, valorCalda);
            }
        });
        plusLimao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtdCalda(qtdLimao, valorTotalCalda, calda, valorCalda);
            }
        });
        minusMaracuja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtdCalda(qtdMaracuja, valorTotalCalda, calda, valorCalda);
            }
        });
        plusMaracuja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtdCalda(qtdMaracuja, valorTotalCalda, calda, valorCalda);
            }
        });
        minusMel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtdCalda(qtdMel, valorTotalCalda, calda, valorCalda);
            }
        });
        plusMel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtdCalda(qtdMel, valorTotalCalda, calda, valorCalda);
            }
        });
        minusMenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtdCalda(qtdMenta, valorTotalCalda, calda, valorCalda);
            }
        });
        plusMenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtdCalda(qtdMenta, valorTotalCalda, calda, valorCalda);
            }
        });
        minusCaldaMorango.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtdCalda(qtdCaldaMorango, valorTotalCalda, calda, valorCalda);
            }
        });
        plusCaldaMorango.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtdCalda(qtdCaldaMorango, valorTotalCalda, calda, valorCalda);
            }
        });
        minusCaldaUva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtdCalda(qtdCaldaUva, valorTotalCalda, calda, valorCalda);
            }
        });
        plusCaldaUva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtdCalda(qtdCaldaUva, valorTotalCalda, calda, valorCalda);
            }
        });
        minusBatom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtdAdd(qtdBatom, valorTotalAdicional, adicional, valorAdicional);
            }
        });
        plusBatom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtdAdd(qtdBatom, valorTotalAdicional, adicional, valorAdicional);
            }
        });
        minusBis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtdAdd(qtdBis, valorTotalAdicional, adicional, valorAdicional);
            }
        });
        plusBis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtdAdd(qtdBis, valorTotalAdicional, adicional, valorAdicional);
            }
        });
        minusChocobal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtdAdd(qtdChocobal, valorTotalAdicional, adicional, valorAdicional);
            }
        });
        plusChocobal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtdAdd(qtdChocobal, valorTotalAdicional, adicional, valorAdicional);
            }
        });
        minusCremeAvela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtdAdd(qtdCremeAvela, valorTotalAdicional, adicional, valorAdicional);
            }
        });
        plusCremeAvela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtdAdd(qtdCremeAvela, valorTotalAdicional, adicional, valorAdicional);
            }
        });
        minusCremeMorango.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtdAdd(qtdCremeMorango, valorTotalAdicional, adicional, valorAdicional);
            }
        });
        plusCremeMorango.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtdAdd(qtdCremeMorango, valorTotalAdicional, adicional, valorAdicional);
            }
        });
        minusCremePitaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtdAdd(qtdCremePitaya, valorTotalAdicional, adicional, valorAdicional);
            }
        });
        plusCremePitaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtdAdd(qtdCremePitaya, valorTotalAdicional, adicional, valorAdicional);
            }
        });
        minusGotaChocolate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtdAdd(qtdGotaChocolate, valorTotalAdicional, adicional, valorAdicional);
            }
        });
        plusGotaChocolate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtdAdd(qtdGotaChocolate, valorTotalAdicional, adicional, valorAdicional);
            }
        });
        minusJujuba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtdAdd(qtdJujuba, valorTotalAdicional, adicional, valorAdicional);
            }
        });
        plusJujuba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtdAdd(qtdJujuba, valorTotalAdicional, adicional, valorAdicional);
            }
        });
        minusKitkat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtdAdd(qtdKitkat, valorTotalAdicional, adicional, valorAdicional);
            }
        });
        plusKitkat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtdAdd(qtdKitkat, valorTotalAdicional, adicional, valorAdicional);
            }
        });
        minusMarshmallow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtdAdd(qtdMarshmallow, valorTotalAdicional, adicional, valorAdicional);
            }
        });
        plusMarshmallow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtdAdd(qtdMarshmallow, valorTotalAdicional, adicional, valorAdicional);
            }
        });
        minusMMs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtdAdd(qtdMMs, valorTotalAdicional, adicional, valorAdicional);
            }
        });
        plusMMs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtdAdd(qtdMMs, valorTotalAdicional, adicional, valorAdicional);
            }
        });
        minusOreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtdAdd(qtdOreo, valorTotalAdicional, adicional, valorAdicional);
            }
        });
        plusOreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtdAdd(qtdOreo, valorTotalAdicional, adicional, valorAdicional);
            }
        });
        minusOuroBranco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtdAdd(qtdOuroBranco, valorTotalAdicional, adicional, valorAdicional);
            }
        });
        plusOuroBranco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtdAdd(qtdOuroBranco, valorTotalAdicional, adicional, valorAdicional);
            }
        });
        minusOvomaltine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtdAdd(qtdOvomaltine, valorTotalAdicional, adicional, valorAdicional);
            }
        });
        plusOvomaltine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtdAdd(qtdOvomaltine, valorTotalAdicional, adicional, valorAdicional);
            }
        });
        minusChocoRaspa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtdAdd(qtdChocoRaspa, valorTotalAdicional, adicional, valorAdicional);
            }
        });
        plusChocoRaspa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtdAdd(qtdChocoRaspa, valorTotalAdicional, adicional, valorAdicional);
            }
        });
        minusTortuguita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtdAdd(qtdTortuguita, valorTotalAdicional, adicional, valorAdicional);
            }
        });
        plusTortuguita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtdAdd(qtdTortuguita, valorTotalAdicional, adicional, valorAdicional);
            }
        });
        minusTubosChoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementarQtdAdd(qtdTubosChoc, valorTotalAdicional, adicional, valorAdicional);
            }
        });
        plusTubosChoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarQtdAdd(qtdTubosChoc, valorTotalAdicional, adicional, valorAdicional);
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
}