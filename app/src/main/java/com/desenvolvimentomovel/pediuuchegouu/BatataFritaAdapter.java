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
    private ArrayList<Produto> produtos;
    private Context context;
    private BatataFritaAdapter.ItemClicked activity;

    public interface ItemClicked{
        void onItemClicked(int index);
    }

    public BatataFritaAdapter (Context contexto, ArrayList<Produto> list){
        this.produtos = list;
        this.context = contexto;
        this.activity = (BatataFritaAdapter.ItemClicked) contexto;
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

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClicked(getAdapterPosition());
                }
            });
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BatataFritaAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.tvTamanho.setText(produtos.get(i).getmTamanho());
        myViewHolder.tvPreco.setText(String.valueOf(produtos.get(i).getmPreco()));
    }

    @Override
    public int getItemCount() { return produtos.size(); }

    public Produto getItem(int position){
        return produtos.get(position);
    }
}
