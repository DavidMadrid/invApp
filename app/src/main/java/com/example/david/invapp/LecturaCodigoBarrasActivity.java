package com.example.david.invapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import com.example.david.invapp.modeloDAO.DatabaseHandler;
import com.example.david.invapp.pojos.pojoLogin.LoginResult;

public class LecturaCodigoBarrasActivity extends AppCompatActivity implements DatabaseHandler.ProgressListener{

    ProgressBar barraProgreso;
    ImageButton descargaCB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lectura_codigo_barras);
        InitApp initApp = (InitApp) getApplication();
        DatabaseHandler dbHandler = initApp.getDbHandler();
        dbHandler.setOnProgressListener(this);
        descargaCB = (ImageButton) findViewById(R.id.ibtnCodBarras);
        barraProgreso = (ProgressBar) findViewById(R.id.cargaCodBarrasPb);

        descargaCB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ServerConnect serverConnect = new ServerConnect();
                LoginResult loginResult = PrincipalActivity.loginApp;
                serverConnect.descargaCodBarras(LecturaCodigoBarrasActivity.this,loginResult.getCodEmpresa(),loginResult.getCentro(),0,1);
            }
        });
    }

    @Override
    public void onProgressListener(int progreso) {
        barraProgreso.setProgress(progreso);
    }
}
