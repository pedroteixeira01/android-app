package com.example.mobilmotors;

import android.content.Context;

import com.example.mobilmotors.ui.conta.Usuario;
import com.example.mobilmotors.ui.home.Veiculo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Json {

    public static String getJsonFromAssets(Context context, String fileName) {
        String jsonString;
        try {
            InputStream is = context.getAssets().open(fileName);

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            jsonString = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return jsonString;
    }

    public static void checkUsusario(String email, String senha, String json, Usuario usuario){

        try{
            JSONObject obj = new JSONObject(json);
            JSONArray lista = obj.getJSONArray("usuarios");

            for(int i=0; i < lista.length(); i++){

                JSONObject usr = lista.getJSONObject(i);
                if((email.equals(usr.getString("email"))) && (senha.equals(usr.getString("senha")))){

                    usuario.setNome(usr.getString("nome"));
                    usuario.setEmail(email);
                    usuario.setTelefone("telefone");
                    usuario.setSenha(senha);

                    return;
                }else{
                    return;
                }
            }

        }catch (JSONException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void getVeiculos(String json, ArrayList<Veiculo> veiculos){

        try{
            JSONObject obj = new JSONObject(json);
            JSONArray lista = obj.getJSONArray("veiculos");

            for(int i=0; i <= lista.length(); i++){
                JSONObject veiculo = lista.getJSONObject(i);

                veiculos.add(new Veiculo(
                        veiculo.getInt("id")
                        , veiculo.getString("nome")
                        , veiculo.getString("descricao")
                        , veiculo.getString("cor")
                        , veiculo.getString("modelo")
                        , veiculo.getString("tipo")
                        , veiculo.getDouble("preco")
                        , veiculo.getString("imagem")
                ));
            }

        }catch (JSONException e){}
    }
}