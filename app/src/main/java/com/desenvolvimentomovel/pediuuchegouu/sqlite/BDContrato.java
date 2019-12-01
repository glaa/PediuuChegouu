package com.desenvolvimentomovel.pediuuchegouu.sqlite;

import android.provider.BaseColumns;

public final class BDContrato {

    private BDContrato(){}

    public static class ClienteEntrada implements BaseColumns{
        public static final String TABELA_CLIENTE = "cliente";
        public static final String CLIENTE_TELEFONE = "telefone";
        public static final String CLIENTE_NOME = "nome";
        public static final String CLIENTE_APELIDO = "apelido";
        public static final String CLIENTE_SENHA = "senha";
    }

    public static class EnderecoEntrada implements BaseColumns{
        public static final String TABELA_ENDERECO = "endereco";
        public static final String ENDERECO_ID = "id";
        public static final String ENDERECO_FK_CLIENTE_TELEFONE = "fk_telefone_cliente";
        public static final String ENDERECO_NOME = "nome";
        public static final String ENDERECO_LOGRADOURO = "logradouro";
        public static final String ENDERECO_NUMERO = "numero";
        public static final String ENDERECO_BAIRRO = "bairro";
        public static final String ENDERECO_REFERENCIA = "referencia";
    }

    public static class ProdutoEntrada implements BaseColumns{
        public static final String TABELA_PRODUTO = "produto";
        public static final String PRODUTO_ID = "id";
        public static final String PRODUTO_NOME = "nome";
        public static final String PRODUTO_DESCRICAO = "descricao";
        public static final String PRODUTO_TAMANHO = "tamanho";
        public static final String PRODUTO_PRECO = "preco";
        public static final String PRODUTO_FOTO = "foto";
    }

    public static class ExtraEntrada implements BaseColumns{
        public static final String TABELA_EXTRA = "extra";
        public static final String EXTRA_ID = "id";
        public static final String EXTRA_TIPO = "tipo";
        public static final String EXTRA_NOME = "nome";
        public static final String EXTRA_PRECO = "preco";
        public static final String EXTRA_QUANTIDADE = "quantidade";
    }

    public static class AcaiEntrada implements BaseColumns{
        public static final String TABELA_ACAI = "acai";
        public static final String ACAI_ID = "id";
        public static final String ACAI_FK_ID_PRODUTO = "id_produto";
        public static final String ACAI_RECIPIENTE = "recipiente";
        public static final String ACAI_VOLUME = "volume";
        public static final String ACAI_QTDCOMPLEMENTO = "qtd_complemento";
        public static final String ACAI_QTDFRUTA = "qtd_fruta";
        public static final String ACAI_QTDCALDA = "qtd_calda";
        public static final String ACAI_QTDADICIONAL = "qtd_adicional";
        public static final String ACAI_SABOR = "sabor";
    }

    public static class CompraEntrada implements BaseColumns{
        public static final String TABELA_COMPRA = "compra";
        public static final String COMPRA_ID = "id";
        public static final String COMPRA_DATA = "data";
        public static final String COMPRA_VALOR = "valor";
    }

    public static class ItenEntrada implements BaseColumns{
        public static final String TABELA_ITEN = "iten";
        public static final String ITEN_ID = "id";
        public static final String ITEN_FK_ID_COMPRA = "id_compra";
        public static final String ITEN_FK_ID_PRODUTO = "id_produto";
        public static final String ITEN_FK_ID_ACAI = "id_acai";
        public static final String ITEN_FK_ID_EXTRA = "id_extra";


    }
}
