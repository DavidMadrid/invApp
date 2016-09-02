package com.example.david.invapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.david.invapp.modeloDAO.DatabaseHandler;
import com.example.david.invapp.pojos.pojoEntrada.DetalleRecuento;

public class AltaLineaRecuentoActivity extends AppCompatActivity {
    String almacen;
    String ubicacion;
    String lote;
    String producto;
    String cantidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_linea_recuento);
        intitUI();
        Button ok = (Button) findViewById(R.id.bnOK);
        Button cancel = (Button) findViewById(R.id.bnCancel);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InitApp initApp = (InitApp) getApplication();
                DatabaseHandler dbHandler = initApp.getDbHandler();
                dbHandler.getWritableDatabase();
                if(dbHandler!=null){

              /*     dbHandler.execSQL("INSERT INTO RECUENTO(almacen)"+"VALUES ("+almacen+")","" +
                           " UBICACION(ubicacion)"+"VALUES ("+ubicacion+")");
                   dbHandler.close();*/

                }
            }
        });
    }


    public void intitUI(){

        EditText almacen = (EditText) findViewById(R.id.edAlmacen);
        EditText ubicacion = (EditText) findViewById(R.id.edUbicacion);
        EditText lote = (EditText) findViewById(R.id.edLote);
        EditText producto = (EditText) findViewById(R.id.edProducto);
        EditText cantidad = (EditText) findViewById(R.id.edCantidad);




    }
}
