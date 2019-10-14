package com.desenvolvimentomovel.pediuuchegouu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoAdapter.MyViewHolder> {

    private ArrayList<Produto> produtos;
    private Context context;
    private ItemClicked activity;

    public interface ItemClicked{
        void onItemClicked(int index);
    }

    public ProdutoAdapter (Context contexto, ArrayList<Produto> list){
        this.produtos = list;
        this.context = contexto;
        this.activity = (ItemClicked) contexto;
    }

    @NonNull
    @Override
    public ProdutoAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        LayoutInflater mInflanter = LayoutInflater.from(context);
        v = mInflanter.inflate(R.layout.item_produto, viewGroup,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdutoAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.tvNome.setText(produtos.get(i).getmNome());
        myViewHolder.ivFoto.setImageResource(R.drawable.produto);
    }

    @Override
    public int getItemCount() { return produtos.size(); }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvNome;
        ImageView ivFoto;

        public MyViewHolder(final View itemView){
            super(itemView);

            tvNome = itemView.findViewById(R.id.tv_nome_produto);
            ivFoto = itemView.findViewById(R.id.iv_foto_produto);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClicked(getAdapterPosition());
                }
            });
        }
    }

    public Produto getItem(int position){
        return produtos.get(position);
    }
}
