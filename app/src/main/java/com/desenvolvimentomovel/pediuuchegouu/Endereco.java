package com.desenvolvimentomovel.pediuuchegouu;

import java.io.Serializable;
import java.util.ArrayList;

public class Endereco implements Serializable {

    private String tipo;
    private String logradouro;
    private String numero;
    private String bairro;
    private String referencia;

    private static ArrayList<Endereco> enderecos = new ArrayList<>();

    public Endereco(){}

    public Endereco(String tipo, String logradouro, String numero, String bairro, String referencia) {
        this.tipo = tipo;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.referencia = referencia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public void incluirEndereco(Endereco e){
        enderecos.add(e);
    }

    public void excluirEndereco(int index){
        enderecos.remove(index);
    }

    public ArrayList<Endereco> pegarEnderecos(){
        return enderecos;
    }
}
