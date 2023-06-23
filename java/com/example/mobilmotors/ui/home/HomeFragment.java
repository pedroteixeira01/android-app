package com.example.mobilmotors.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.fragment.app.Fragment;

import com.example.mobilmotors.Json;
import com.example.mobilmotors.MainActivity;
import com.example.mobilmotors.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    GridView veiculos;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        view = inflater.inflate(R.layout.fragment_home, container, false);

        String json = Json.getJsonFromAssets(getActivity().getApplicationContext(), "db.json");

        veiculos = view.findViewById(R.id.veiculos);
        ArrayList<Veiculo> lista = new ArrayList<>();
        Json.getVeiculos(json, lista);

        VeiculoAdapter adapter = new VeiculoAdapter(getContext(), lista);
        veiculos.setAdapter(adapter);

        return view;
    }


}