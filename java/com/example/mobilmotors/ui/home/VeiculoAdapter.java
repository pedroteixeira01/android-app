package com.example.mobilmotors.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mobilmotors.R;

import java.util.ArrayList;

public class VeiculoAdapter extends ArrayAdapter<Veiculo> {

    public VeiculoAdapter(@NonNull Context context, ArrayList<Veiculo> lista) {
        super(context, 0, lista);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listitemView = convertView;
        if (listitemView == null) {
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.card_item, parent, false);
        }

        Veiculo veiculos = getItem(position);
        TextView nome = listitemView.findViewById(R.id.nomeProduto);
        TextView valor = listitemView.findViewById(R.id.valorProduto);
        TextView descricao = listitemView.findViewById(R.id.descricao);

        nome.setText(veiculos.getNome());
        valor.setText(String.valueOf(veiculos.getPreco()));
        descricao.setText(veiculos.getDescricao());

        return listitemView;
    }
}
