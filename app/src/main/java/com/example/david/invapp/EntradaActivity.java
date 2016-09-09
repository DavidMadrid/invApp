package com.example.david.invapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.david.invapp.modeloDAO.DBSingleton;
import com.example.david.invapp.modeloDAO.DatabaseHandler;
import com.example.david.invapp.pojos.pojoEntrada.DetalleRecuento;
import com.example.david.invapp.pojos.pojoEntrada.ListadoDetalle;
import com.example.david.invapp.pojos.pojoLogin.LoginResult;
import com.example.david.invapp.pojos.pojoPrincipal.Recuento;

import java.io.Serializable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EntradaActivity extends AppCompatActivity {

String ubicacion;
String articulo;
String cantidad;
TextView almacenText;
TextView ubicacionText;
TextView loteText;
TextView codigoText;
TextView descripcioText;
    EditText edUbicacion;
    EditText edArticulo;
    EditText edCantidad;
    ServerConnect miserver;
   // miserver.
   String empresa;
  String centro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrada);
        //empresa recoger de bbdd
        //centro recoger de bbdd
        //recuento recoger de ApiRest retrofit

        Recuento recuento = (Recuento)getIntent().getSerializableExtra("recuento");

        miserver = new ServerConnect();

        initUI();
        setup(recuento);


        if(ubicacionText.equals(ubicacion)){
            edCantidad.setEnabled(true);

        }else{

            /*Intent intencion = new Intent(EntradaActivity.this,PrincipalActivity.class);
            EntradaActivity.this.startActivity(intencion);
            Bundle extras= intencion.getExtras();
            intencion.putExtra("ubicacion", (Serializable) ubicacion);
            EntradaActivity.this.finish();*/
            //sino se permitira entrada de recuento en pantalla
        }
        if(edArticulo.equals(articulo)){
            edCantidad.setEnabled(true);
        }else{
            //en vez de ir a principal iria a la que lee codigo de barras
            /*Intent intencion = new Intent(EntradaActivity.this,CodigoBarrasActivity.class);
            EntradaActivity.this.startActivity(intencion);*/
          /*  Bundle extras= intencion.getExtras();
            intencion.putExtra("ubicacion", (Serializable) ubicacion);*/
        }
    }
    private void initUI()
    {

        almacenText = (TextView) findViewById(R.id.tvMostrarAlmacenEntrada);
        ubicacionText = (TextView) findViewById(R.id.tvMostrarUbicacionEntrada);
        loteText = (TextView) findViewById(R.id.tvMostrarLoteEntrada);
        codigoText = (TextView) findViewById(R.id.tvCodigoEntrada);
        descripcioText=(TextView)findViewById(R.id.tvDescripcionEntrada);
        edUbicacion = (EditText) findViewById(R.id.edUbicacionEntrada);
        edArticulo = (EditText) findViewById(R.id.edArticuloEntrada);
        edCantidad = (EditText) findViewById(R.id.edCantidadEntrada);

    }
    private void setup(Recuento recuento){

        ubicacion = edUbicacion.getText().toString();
        articulo = edArticulo.getText().toString();
        cantidad = edCantidad.getText().toString();
        // aqui tendria que cargar  elementos de la base de datos
        // como almacen ubicacion lote y descripcion con la respues del servidor
        empresa=PrincipalActivity.loginApp.getCodEmpresa();
        centro=PrincipalActivity.loginApp.getCentro();
       // ServerConnect server = new ServerConnect();
        final ProgressDialog dialog = ProgressDialog.show(EntradaActivity.this, "", "Consultando entradas de recuento. Por favor, espere...", true);
        miserver.descargaEntradaRecuento(empresa,centro,recuento.getRecuento(), new Callback<ListadoDetalle>() {
            @Override
            public void onResponse(Call<ListadoDetalle> call, Response<ListadoDetalle> response) {
                dialog.dismiss();
                if(response.isSuccessful()) {
                    ListadoDetalle listado = response.body();
                    if(listado.getResultado().equals("OK") && listado.getDetalleRecuento().size() > 0 ) {
                        DetalleRecuento result = listado.getDetalleRecuento().get(0);
                        String recuento = result.getRecuento();
                        // si no es recicler creo que se añadiria vista dinamicamente en la actividad entrada
                        String almacen = result.getAlmacen();
                        String ubicacion = result.getUbicacion();
                        String lote = result.getLote();
                        String codigo = result.getProducto();
                        String descripcion = result.getDescProducto();
                        almacenText.setText(almacen);
                        ubicacionText.setText(ubicacion);
                        loteText.setText(lote);
                        codigoText.setText(codigo);
                        descripcioText.setText(descripcion);
                    }else{
                        Toast.makeText(EntradaActivity.this, "No se han recibido datos", Toast.LENGTH_LONG);
                    }
                }else{
                    Toast.makeText(EntradaActivity.this, "Error al obtener detalle recuento", Toast.LENGTH_LONG);
                }
            }
            @Override
            public void onFailure(Call<ListadoDetalle> call, Throwable t) {
                Toast.makeText(EntradaActivity.this, "Error al obtener detalle recuento", Toast.LENGTH_LONG);
            }
        });


    }
}
