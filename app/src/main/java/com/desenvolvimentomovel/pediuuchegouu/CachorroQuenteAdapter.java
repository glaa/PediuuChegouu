package com.desenvolvimentomovel.pediuuchegouu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CachorroQuenteAdapter extends RecyclerView.Adapter<CachorroQuenteAdapter.MyViewHolder>{
    private ArrayList<CachorroQuente> cachorroQuentes;
    private Context context;


    public CachorroQuenteAdapter (Context contexto, ArrayList<CachorroQuente> list){
        this.cachorroQuentes = list;
        this.context = contexto;
    }

    @NonNull
    @Override
    public CachorroQuenteAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        LayoutInflater mInflanter = LayoutInflater.from(context);
        v = mInflanter.inflate(R.layout.item_cachorro, viewGroup,false);
        return new CachorroQuenteAdapter.MyViewHolder(v);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTamanho;
        TextView tvPreco;

        public MyViewHolder(final View itemView){
            super(itemView);
            tvTamanho = itemView.findViewById(R.id.tv_tamanho_cachorro);
            tvPreco = itemView.findViewById(R.id.tv_preco_cachorro);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull CachorroQuenteAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.tvTamanho.setText(cachorroQuentes.get(i).getTamanho());
        myViewHolder.tvPreco.setText(String.valueOf(cachorroQuentes.get(i).getPreco()));
    }

    @Override
    public int getItemCount() { return cachorroQuentes.size(); }

    public CachorroQuente getItem(int position){
        return cachorroQuentes.get(position);
    }
}
