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

    private ArrayList<Produto> produtos;
    private Context context;
    private NuggetsAdapter.ItemClicked activity;

    public interface ItemClicked{
        void onItemClicked(int index);
    }

    public NuggetsAdapter (Context contexto, ArrayList<Produto> list){
        this.produtos = list;
        this.context = contexto;
        this.activity = (NuggetsAdapter.ItemClicked) contexto;
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

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClicked(getAdapterPosition());
                }
            });
        }
    }

    @Override
    public void onBindViewHolder(@NonNull NuggetsAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.tvTamanho.setText(produtos.get(i).getmTamanho());
        myViewHolder.tvPreco.setText(String.valueOf(produtos.get(i).getmPreco()));
    }

    @Override
    public int getItemCount() { return produtos.size(); }

    public Produto getItem(int position){
        return produtos.get(position);
    }
}
