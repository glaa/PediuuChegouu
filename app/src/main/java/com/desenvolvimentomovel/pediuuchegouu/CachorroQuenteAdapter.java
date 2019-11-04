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
    private ArrayList<Produto> produtos;
    private Context context;
    private CachorroQuenteAdapter.ItemClicked activity;

    public interface ItemClicked{
        void onItemClicked(int index);
    }

    public CachorroQuenteAdapter (Context contexto, ArrayList<Produto> list){
        this.produtos = list;
        this.context = contexto;
        this.activity = (CachorroQuenteAdapter.ItemClicked) contexto;
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

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClicked(getAdapterPosition());
                }
            });
        }
    }

    @Override
    public void onBindViewHolder(@NonNull CachorroQuenteAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.tvTamanho.setText(produtos.get(i).getmTamanho());
        myViewHolder.tvPreco.setText(String.valueOf(produtos.get(i).getmPreco()));
    }

    @Override
    public int getItemCount() { return produtos.size(); }

    public Produto getItem(int position){
        return produtos.get(position);
    }
}
