package com.desenvolvimentomovel.pediuuchegouu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CarrinhoAdapter extends RecyclerView.Adapter<CarrinhoAdapter.MyViewHolder>{

    private ArrayList<Produto> produtos;
    private ArrayList<Produto> favoritos;
    private Context context;
    private CarrinhoAdapter.ItemClicked activity;

    public interface ItemClicked{
        void excluirItem(int index);
        void ativarFavorito(int index);
        void desativarFavorito(int index);
    }

    public CarrinhoAdapter (Context contexto, ArrayList<Produto> list, ArrayList<Produto> favoritos){
        this.produtos = list;
        this.favoritos = favoritos;
        this.context = contexto;
        this.activity = (CarrinhoAdapter.ItemClicked) contexto;
    }

    @NonNull
    @Override
    public CarrinhoAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        LayoutInflater mInflanter = LayoutInflater.from(context);
        v = mInflanter.inflate(R.layout.item_carrinho, viewGroup,false);
        return new CarrinhoAdapter.MyViewHolder(v);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvNome;
        TextView tvTamanho;
        TextView tvDescricao;
        TextView tvPreco;
        ImageView ivDelete;
        ImageView ivFavorito;

        public MyViewHolder(final View itemView){
            super(itemView);
            tvNome = itemView.findViewById(R.id.tv_produto_carrinho);
            tvTamanho = itemView.findViewById(R.id.tv_tamanho_carrinho);
            tvDescricao = itemView.findViewById(R.id.tv_decricao_carrinho);
            tvPreco = itemView.findViewById(R.id.tv_valor_carrinho);
            ivDelete = itemView.findViewById(R.id.iv_excluir_carrinho);
            ivFavorito = itemView.findViewById(R.id.iv_favorito_carrinho);


            ivDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.excluirItem(getAdapterPosition());
                }
            });

            ivFavorito.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if(favoritos.contains(produtos.get(getAdapterPosition()))){
                        Log.d("CARR","desfavorito");
                        favoritos.remove(produtos.get(getAdapterPosition()));
                        ivFavorito.setImageResource(R.drawable.ic_favorite_border_red_24dp);
                        activity.desativarFavorito(getAdapterPosition());
                    } else {
                        Log.d("CARR","favorito");
                        favoritos.add(produtos.get(getAdapterPosition()));
                        ivFavorito.setImageResource(R.drawable.ic_favorite_red_24dp);
                        activity.ativarFavorito(getAdapterPosition());
                    }



                }
            });
        }
    }

    @Override
    public void onBindViewHolder(@NonNull CarrinhoAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.tvNome.setText(produtos.get(i).getmNome());
        myViewHolder.tvTamanho.setText(produtos.get(i).getmTamanho());
        myViewHolder.tvDescricao.setText(produtos.get(i).getmDescricao());
        myViewHolder.tvPreco.setText(String.valueOf(produtos.get(i).getmPreco()));

        if(marcarFavorito(produtos.get(i))){
        //    myViewHolder.ivFavorito.setImageResource(R.drawable.ic_favorite_red_24dp);
        }
    }

    @Override
    public int getItemCount() { return produtos.size(); }

    public Produto getItem(int position){
        return produtos.get(position);
    }

    private boolean marcarFavorito(Produto produto){
        if(favoritos.contains(produto)){
            return true;
        } else {
            return false;
        }
    }
}
