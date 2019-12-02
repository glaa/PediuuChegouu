package com.desenvolvimentomovel.pediuuchegouu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HistoricoAdapter extends RecyclerView.Adapter<HistoricoAdapter.MyViewHolder>{
    private ArrayList<Produto> produtos;
    private Context context;
    private HistoricoAdapter.ItemClicked activity;
    private String data;

    public interface ItemClicked{
        void onItemClicked(int index);
    }

    public HistoricoAdapter (Context contexto, ArrayList<Produto> list, String data){
        this.produtos = list;
        this.context = contexto;
        this.activity = (HistoricoAdapter.ItemClicked) contexto;
        this.data = data;
    }

    @NonNull
    @Override
    public HistoricoAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        LayoutInflater mInflanter = LayoutInflater.from(context);
        v = mInflanter.inflate(R.layout.item_historico, viewGroup,false);
        return new HistoricoAdapter.MyViewHolder(v);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvProduto;
        TextView tvTamanho;
        TextView tvData;
        TextView tvDescricao;
        TextView tvPreco;

        public MyViewHolder(final View itemView){
            super(itemView);
            tvProduto = itemView.findViewById(R.id.tv_produto_historico);
            tvTamanho = itemView.findViewById(R.id.tv_tamanho_historico);
            tvData = itemView.findViewById(R.id.tv_data_historico);
            tvDescricao = itemView.findViewById(R.id.tv_descricao_historico);
            tvPreco = itemView.findViewById(R.id.tv_preco_historico);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClicked(getAdapterPosition());
                }
            });
        }
    }

    @Override
    public void onBindViewHolder(@NonNull HistoricoAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.tvProduto.setText(produtos.get(i).getmNome());
        myViewHolder.tvTamanho.setText(produtos.get(i).getmTamanho());
        myViewHolder.tvData.setText("02/12/2019");
        myViewHolder.tvDescricao.setText(produtos.get(i).getmDescricao());
        myViewHolder.tvPreco.setText(String.valueOf(produtos.get(i).getmPreco()));
    }

    @Override
    public int getItemCount() { return produtos.size(); }

    public Produto getItem(int position){
        return produtos.get(position);
    }
}
