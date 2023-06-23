package com.example.mobilmotors.ui.conta;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mobilmotors.R;
import com.example.mobilmotors.databinding.FragmentPerfilBinding;

public class PerfilFragment extends Fragment {

    TextView nome, email, telefone;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        view = inflater.inflate(R.layout.fragment_perfil, container, false);

        nome = view.findViewById(R.id.perfNome);
        email = view.findViewById(R.id.perfEmail);
        telefone = view.findViewById(R.id.perfTel);

        nome.setText(getArguments().getString("nome"));
        email.setText(getArguments().getString("email"));
        telefone.setText(getArguments().getString("telefone"));

        return view;
    }

    public static PerfilFragment newInstance(String nome, String email, String telefone) {
        PerfilFragment pf = new PerfilFragment();

        Bundle args = new Bundle();
        args.putString("nome", nome);
        args.putString("email", email);
        args.putString("telefone", telefone);
        pf.setArguments(args);

        return pf;
    }
}