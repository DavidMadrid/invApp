package com.example.david.invapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EnviarActualizarActivity extends AppCompatActivity {

ServerConnect miserver;
    String empresa;
    String centro;
    String recuento;
    String almacen;
    String ubicacion;
    String producto;
    String lote;
    String cantidad;
    String grupal ;
//cogerlos del JSON de recuentos
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviar_actualizar);
        Button actualizar = (Button) findViewById(R.id.btActualizar);
        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            miserver.actualizarRecuentos(empresa,centro,recuento,almacen,ubicacion,producto, lote,
                     cantidad,grupal);
            }
        });
    }
}
