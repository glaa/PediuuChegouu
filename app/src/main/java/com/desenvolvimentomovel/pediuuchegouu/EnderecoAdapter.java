package com.desenvolvimentomovel.pediuuchegouu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EnderecoAdapter  extends RecyclerView.Adapter<EnderecoAdapter.MyViewHolder> {

    private ArrayList<Endereco> enderecos;
    private Context context;
    private EnderecoAdapter.ItemClicked activity;

    public interface ItemClicked{
        void onItemClicked(int index);
    }

    public EnderecoAdapter (Context contexto, ArrayList<Endereco> list){
        this.enderecos = list;
        this.context = contexto;
        this.activity = (EnderecoAdapter.ItemClicked) contexto;
    }

    @NonNull
    @Override
    public EnderecoAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        LayoutInflater mInflanter = LayoutInflater.from(context);
        v = mInflanter.inflate(R.layout.item_endereco, viewGroup,false);
        return new EnderecoAdapter.MyViewHolder(v);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTipo;
        TextView tvLogradouro;
        TextView tvBairro;
        TextView tvReferencia;

        public MyViewHolder(final View itemView){
            super(itemView);
            tvTipo = itemView.findViewById(R.id.tv_tipo_item_endereco);
            tvLogradouro = itemView.findViewById(R.id.tv_logradouro_item_endereco);
            tvBairro = itemView.findViewById(R.id.tv_bairro_item_endereco);
            tvReferencia = itemView.findViewById(R.id.tv_referencia_item_endereco);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //activity.onItemClicked(getAdapterPosition());
                }
            });
        }
    }

    @Override
    public void onBindViewHolder(@NonNull EnderecoAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.tvTipo.setText(enderecos.get(i).getTipo());
        myViewHolder.tvLogradouro.setText(enderecos.get(i).getLogradouro() + ", " + enderecos.get(i).getNumero());
        myViewHolder.tvBairro.setText(enderecos.get(i).getBairro());
        myViewHolder.tvReferencia.setText(String.valueOf(enderecos.get(i).getReferencia()));
    }

    @Override
    public int getItemCount() { return enderecos.size(); }

    public Endereco getItem(int position){
        return enderecos.get(position);
    }

}
