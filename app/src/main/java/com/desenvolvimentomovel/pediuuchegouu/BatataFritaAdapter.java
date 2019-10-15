package com.desenvolvimentomovel.pediuuchegouu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BatataFritaAdapter extends RecyclerView.Adapter<BatataFritaAdapter.MyViewHolder> {
    private ArrayList<BatataFrita> batatas;
    private Context context;


    public BatataFritaAdapter (Context contexto, ArrayList<BatataFrita> list){
        this.batatas = list;
        this.context = contexto;
    }

    @NonNull
    @Override
    public BatataFritaAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        LayoutInflater mInflanter = LayoutInflater.from(context);
        v = mInflanter.inflate(R.layout.item_batata, viewGroup,false);
        return new BatataFritaAdapter.MyViewHolder(v);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTamanho;
        TextView tvPreco;

        public MyViewHolder(final View itemView){
            super(itemView);
            tvTamanho = itemView.findViewById(R.id.tv_tamanho_batata);
            tvPreco = itemView.findViewById(R.id.tv_preco_batata);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BatataFritaAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.tvTamanho.setText(batatas.get(i).getTamanho());
        myViewHolder.tvPreco.setText(String.valueOf(batatas.get(i).getPreco()));
    }

    @Override
    public int getItemCount() { return batatas.size(); }

    public BatataFrita getItem(int position){
        return batatas.get(position);
    }
}
