package com.example.david.invapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    EditText edUsuario;
    EditText edPassword;
    Button boton;
    String usuario;
    String password;
    ServerConnect miserver;



    //crear objeto de clase server conect
    //con el objeto server conect llamar al metodo
    // pasarle los atributos usuario y password


    private void initUI()
    {
        boton = (Button) findViewById(R.id.btLogin);
        edUsuario = (EditText) findViewById(R.id.etUsuario);
        edPassword = (EditText) findViewById(R.id.etPassword);
    }

    private void setupListeners()
    {
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                //Esto lo recogeria en RegistroAcitivity

                usuario = edUsuario.getText().toString();
                password = edPassword.getText().toString();

                miserver.realizarLogin(LoginActivity.this,usuario,password);


            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        miserver = new ServerConnect();
        initUI();
        setupListeners();
    }


}


