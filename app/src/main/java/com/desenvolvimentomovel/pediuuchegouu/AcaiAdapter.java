package com.desenvolvimentomovel.pediuuchegouu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AcaiAdapter extends RecyclerView.Adapter<AcaiAdapter.MyViewHolder>  {

    private ArrayList<Acai> acais;
    private Context context;


    public AcaiAdapter (Context contexto, ArrayList<Acai> list){
        this.acais = list;
        this.context = contexto;
    }

    @NonNull
    @Override
    public AcaiAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        LayoutInflater mInflanter = LayoutInflater.from(context);
        v = mInflanter.inflate(R.layout.item_acai, viewGroup,false);
        return new AcaiAdapter.MyViewHolder(v);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvRecipiente;
        TextView tvTamanho;
        TextView tvQuantidade;
        TextView tvPreco;
        TextView tvDescricao;

        public MyViewHolder(final View itemView){
            super(itemView);

            tvRecipiente = itemView.findViewById(R.id.tv_recipiente_item_acai);
            tvTamanho = itemView.findViewById(R.id.tv_tamanho_item_acai);
            tvQuantidade = itemView.findViewById(R.id.tv_quantidade_item_acai);
            tvPreco = itemView.findViewById(R.id.tv_preco_item_acai);
            tvDescricao = itemView.findViewById(R.id.tv_descicao_item_acai);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull AcaiAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.tvRecipiente.setText(acais.get(i).getRecipiente());
        myViewHolder.tvTamanho.setText(acais.get(i).getTamanho());
        myViewHolder.tvQuantidade.setText(acais.get(i).getQuatidade());
        myViewHolder.tvPreco.setText(String.valueOf(acais.get(i).getPreco()));
        myViewHolder.tvDescricao.setText(acais.get(i).getDescricao());
    }

    @Override
    public int getItemCount() { return acais.size(); }

    public Acai getItem(int position){
        return acais.get(position);
    }
}
