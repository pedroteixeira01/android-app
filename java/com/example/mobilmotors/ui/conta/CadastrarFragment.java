package com.example.mobilmotors.ui.conta;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mobilmotors.R;

public class CadastrarFragment extends Fragment {

    Button btEnviar, btLogin;
    EditText nome, email, telefone, senha;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_cadastrar, container, false);

        btEnviar = view.findViewById(R.id.cadEnviar);
        btLogin = view.findViewById(R.id.paraLogin);

        btEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Insira os dados para entrar na sua conta", Toast.LENGTH_LONG).show();
                getFragmentManager().beginTransaction().replace(
                        R.id.nav_host_fragment_content_main
                        , new CadastrarFragment()).addToBackStack(null).commit();
            }
        });

        return view;
    }
}