package com.example.mobilmotors;

import android.os.AsyncTask;

import com.example.mobilmotors.ui.conta.Usuario;
import com.example.mobilmotors.ui.home.Veiculo;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Requests {
    private static final String BASE_URL = "http://localhost:3000/";

    public void getUsuarios(final OnUsuariosRequestListener listener) {
        String url = BASE_URL + "usuarios";
        sendRequest("GET", url, new OnRequestListener() {
            @Override
            public void onSuccess(String response) {
                // Converter a resposta JSON em uma lista de objetos Usuario usando Gson
                Gson gson = new Gson();
                Usuario[] usuariosArray = gson.fromJson(response, Usuario[].class);
                List<Usuario> usuarios = new ArrayList<>(Arrays.asList(usuariosArray));
                if (listener != null) {
                    listener.onSuccess(usuarios);
                }
            }

            @Override
            public void onError(String error) {
                if (listener != null) {
                    listener.onError(error);
                }
            }
        });
    }

    public void getFuncionarios(final OnFuncionariosRequestListener listener) {
        String url = BASE_URL + "funcionarios";
        sendRequest("GET", url, new OnRequestListener() {
            @Override
            public void onSuccess(String response) {
                // Converter a resposta JSON em uma lista de objetos Funcionario usando Gson
                Gson gson = new Gson();
                Funcionario[] funcionariosArray = gson.fromJson(response, Funcionario[].class);
                List<Funcionario> funcionarios = new ArrayList<>(Arrays.asList(funcionariosArray));
                if (listener != null) {
                    listener.onSuccess(funcionarios);
                }
            }

            @Override
            public void onError(String error) {
                if (listener != null) {
                    listener.onError(error);
                }
            }
        });
    }

    public void getVeiculos(final OnVeiculosRequestListener listener) {
        String url = BASE_URL + "veiculos";
        sendRequest("GET", url, new OnRequestListener() {
            @Override
            public void onSuccess(String response) {
                // Converter a resposta JSON em uma lista de objetos Veiculo usando Gson
                Gson gson = new Gson();
                Veiculo[] veiculosArray = gson.fromJson(response, Veiculo[].class);
                List<Veiculo> veiculos = new ArrayList<>(Arrays.asList(veiculosArray));
                if (listener != null) {
                    listener.onSuccess(veiculos);
                }
            }

            @Override
            public void onError(String error) {
                if (listener != null) {
                    listener.onError(error);
                }
            }
        });
    }

    private void sendRequest(String metodo, String url, final OnRequestListener listener) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    URL requestUrl = new URL(url);
                    HttpURLConnection connection = (HttpURLConnection) requestUrl.openConnection();
                    connection.setRequestMethod(metodo.toUpperCase());

                    if (connection.getResponseCode() == 200) {
                        InputStream responseBody = connection.getInputStream();
                        Reader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");

                        StringBuilder builder = new StringBuilder();
                        char[] buffer = new char[4096];
                        int read;
                        while ((read = responseBodyReader.read(buffer)) != -1) {
                            builder.append(buffer, 0, read);
                        }

                        String response = builder.toString();

                        if (listener != null) {
                            listener.onSuccess(response);
                        }
                    } else {
                        if (listener != null) {
                            listener.onError("Erro na requisição: " + connection.getResponseCode());
                        }
                    }

                    connection.disconnect();
                } catch (MalformedURLException e) {
                    if (listener != null) {
                        listener.onError("URL inválida: " + url);
                    }
                } catch (IOException e) {
                    if (listener != null) {
                        listener.onError("Erro de conexão: " + e.getMessage());
                    }
                }
            }
        });
    }

    public interface OnRequestListener {
        void onSuccess(String response);
        void onError(String error);
    }

    public interface OnUsuariosRequestListener {
        void onSuccess(List<Usuario> usuarios);
        void onError(String error);
    }

    public interface OnFuncionariosRequestListener {
        void onSuccess(List<Funcionario> funcionarios);
        void onError(String error);
    }

    public interface OnVeiculosRequestListener {
        void onSuccess(List<Veiculo> veiculos);
        void onError(String error);
    }
}