package com.example.david.invapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.david.invapp.pojos.PrincipalResult;

import java.util.LinkedList;
import java.util.List;

public class PrincipalActivity extends AppCompatActivity {

    TextView recuento;
    TextView fecha;
    TextView centro;
    TextView empresa;
    private List<PrincipalResult> resultados;
    private PrincipalAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        recuento=(TextView) findViewById(R.id.tvRecuento);
        centro=(TextView) findViewById(R.id.tvCentro);
        fecha=(TextView) findViewById(R.id.tvFecha);
        String recuento="";
        String centro="";
        String empresa="";

        resultados = new LinkedList<>();
        adaptador = new PrincipalAdapter(resultados);

        //Inicilizar el ListView
        ListView listView = (ListView) findViewById(R.id.lvRecuentos);

        listView.setAdapter(adaptador);




        ServerConnectPrincipal miserver = new ServerConnectPrincipal();
        miserver.hacerRecuento(recuento,centro,empresa);   //(recuento,empresa,centro);





    }
}
