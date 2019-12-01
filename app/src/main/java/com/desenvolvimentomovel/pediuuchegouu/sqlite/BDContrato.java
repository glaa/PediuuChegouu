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
}
