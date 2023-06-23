package com.example.mobilmotors.ui.conta;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mobilmotors.Json;
import com.example.mobilmotors.MainActivity;
import com.example.mobilmotors.R;
import com.google.android.material.navigation.NavigationView;

public class LoginFragment extends Fragment {

    Button btEntrar, btCadastro;
    EditText email, senha;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        view = inflater.inflate(R.layout.fragment_login, container, false);
        String json = Json.getJsonFromAssets(getActivity().getApplicationContext(), "db.json");

        Usuario usr = new Usuario();

        email = view.findViewById(R.id.logEmail);
        senha = view.findViewById(R.id.logSenha);

        btEntrar = view.findViewById(R.id.btEntrar);
        btCadastro = view.findViewById(R.id.paraCadastro);

        btEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(email.getText().toString().equals("")){
                    email.setError("Por favor, preencha o campo do email");
                }
                if(senha.getText().toString().equals("")){
                    senha.setError("Por favor, preencha o campo da senha");
                }
                Json.checkUsusario(email.getText().toString(), senha.getText().toString(), json, usr);
                if(usr != null){
                    Toast.makeText(getContext(), "Bem vindo(a) " + usr.getNome() + " !", Toast.LENGTH_SHORT).show();

                    ((MainActivity) getActivity()).setLoged(true);

                    PerfilFragment.newInstance(usr.getNome(), usr.getEmail(), usr.getTelefone());

                }else{
                    Toast.makeText(getContext(), "E-mail ou senha incorretos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Insira os dados para cadastrar sua conta", Toast.LENGTH_LONG).show();
                getFragmentManager().beginTransaction().replace(
                        R.id.nav_host_fragment_content_main
                        , new CadastrarFragment()).addToBackStack(null).commit();
            }
        });

        return view;
    }
}