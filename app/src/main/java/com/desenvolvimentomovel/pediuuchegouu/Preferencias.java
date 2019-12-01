package com.desenvolvimentomovel.pediuuchegouu;

import android.content.SharedPreferences;
import android.util.Log;

import static android.content.Context.MODE_PRIVATE;

public class Preferencias {

    public static SharedPreferences preferencias;

    public Preferencias(SharedPreferences sharedPreferences){
        this.preferencias = sharedPreferences;
    }

    public static void salvarUsuario(String telefone, String nome, String apelido){
        SharedPreferences.Editor editor = preferencias.edit();
        String telefoneFormatado = "("+telefone.substring(0,2)+")"
                +telefone.substring(2,7)+"-"
                +telefone.substring(7,11);
        editor.putString("telefone",telefoneFormatado);
        editor.putString("nome",nome);
        editor.putString("apelido",apelido);
        editor.putBoolean("logado",true);
        editor.apply();
    }

    public static boolean verificarUsuarioLogado(){
        boolean logado = true;
        if(!preferencias.contains("logado")){
            logado = false;
        }
        return logado;
    }

    public static void apagarUsuario(){
        SharedPreferences.Editor editor = preferencias.edit();
        editor.clear();
        editor.apply();
    }

    public static String buscarTelefoneUsuario(){
        String telefoneSemFormato;
        telefoneSemFormato = preferencias.getString("telefone","ERRO");
        telefoneSemFormato = telefoneSemFormato.replace("(","");
        telefoneSemFormato = telefoneSemFormato.replace(")","");
        telefoneSemFormato = telefoneSemFormato.replace("-","");

        return telefoneSemFormato;
    }
}
