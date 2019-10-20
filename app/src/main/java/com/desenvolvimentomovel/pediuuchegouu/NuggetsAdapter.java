package com.desenvolvimentomovel.pediuuchegouu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NuggetsAdapter extends  RecyclerView.Adapter<NuggetsAdapter.MyViewHolder> {

    private ArrayList<CachorroQuente> nuggets;
    private Context context;

    public NuggetsAdapter (Context contexto, ArrayList<CachorroQuente> list){
        this.nuggets = list;
        this.context = contexto;
    }

    @NonNull
    @Override
    public NuggetsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        LayoutInflater mInflanter = LayoutInflater.from(context);
        v = mInflanter.inflate(R.layout.item_nuggets, viewGroup,false);
        return new NuggetsAdapter.MyViewHolder(v);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTamanho;
        TextView tvPreco;

        public MyViewHolder(final View itemView){
            super(itemView);
            tvTamanho = itemView.findViewById(R.id.tv_tamanho_nuggets);
            tvPreco = itemView.findViewById(R.id.tv_preco_nuggets);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull NuggetsAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.tvTamanho.setText(nuggets.get(i).getTamanho());
        myViewHolder.tvPreco.setText(String.valueOf(nuggets.get(i).getPreco()));
    }

    @Override
    public int getItemCount() { return nuggets.size(); }

    public CachorroQuente getItem(int position){
        return nuggets.get(position);
    }
}
