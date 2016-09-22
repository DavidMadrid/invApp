package com.example.david.invapp.fragments;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.david.invapp.AltaLineaRecuentoActivity;
import com.example.david.invapp.CentroLecturaActivity;
import com.example.david.invapp.CodigoBarrasActivity;
import com.example.david.invapp.PrincipalActivity;
import com.example.david.invapp.R;
import com.example.david.invapp.ServerConnect;
import com.example.david.invapp.pojos.pojoEntrada.DetalleRecuento;
import com.example.david.invapp.pojos.pojoEntrada.ListadoDetalle;
import com.example.david.invapp.pojos.pojoPrincipal.Recuento;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EntradaFragment extends FormParentFragment {

    TextView almacenText;
    TextView ubicacionText;
    TextView loteText;
    TextView codigoText;
    TextView descripcioText;
    EditText edUbicacion;
    EditText edArticulo;
    EditText edCantidad;
    ImageButton botonUbicacion;
    ImageButton botonArticulo;
    private int currentItem = 0;
    private ListadoDetalle listado = null;
    private DetalleRecuento actual = null;
    Button anterior;
    Button siguiente;
    ImageView botonCodBarrasUbi;
    ImageView botonCodBarrasArti;
    private static final int ALTA_REQUEST_CODE = 1;
    private static final int UBI_BARRAS_REQUEST_CODE = 2;
    private static final int ARTI_BARRAS_REQUEST_CODE = 3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_layout_entrada, container, false);
        return v;
    }

    private void logicaUbicacion()
    {
        String edUbicacionVal = edUbicacion.getText().toString();
        String ubicacionDetalleRec = listado.getDetalleRecuento().get(currentItem).getUbicacion();
        if (ubicacionDetalleRec != null && ubicacionDetalleRec.equals(edUbicacionVal)) {
            edCantidad.setEnabled(true);
            edCantidad.setFocusableInTouchMode(true);
            edCantidad.setFocusable(true);
            edCantidad.requestFocus();
        }else{
            int index = 0;
            boolean found = false;
            for(index = 0; index < listado.getDetalleRecuento().size(); index++){
                DetalleRecuento detalle = listado.getDetalleRecuento().get(index);
                if(detalle.getUbicacion() != null && detalle.getUbicacion().equals(edUbicacionVal)){
                    found = true;
                    break;
                }
            }
            if(found){
                currentItem = index;
                mostrarDetalleActual();
            }
        }
    }

    private void logicaArticulo()
    {
        String edArticuloVal = edArticulo.getText().toString();
        String articuloDetalleRec = listado.getDetalleRecuento().get(currentItem).getProducto();
        if (articuloDetalleRec != null && articuloDetalleRec.equals(edArticuloVal)) {
            edCantidad.setEnabled(true);
            edCantidad.setFocusableInTouchMode(true);
            edCantidad.setFocusable(true);
            edCantidad.requestFocus();
        }else {
            int index = 0;
            boolean found = false;
            for(index = 0; index < listado.getDetalleRecuento().size(); index++){
                DetalleRecuento detalle = listado.getDetalleRecuento().get(index);
                if(detalle.getProducto() != null && detalle.getProducto().equals(edArticuloVal)){
                    found = true;
                    break;
                }
            }
            if(found){
                currentItem = index;
                mostrarDetalleActual();
            }
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        almacenText = (TextView) view.findViewById(R.id.tvMostrarAlmacenEntrada);
        ubicacionText = (TextView) view.findViewById(R.id.tvMostrarUbicacionEntrada);
        loteText = (TextView) view.findViewById(R.id.tvMostrarLoteEntrada);
        codigoText = (TextView) view.findViewById(R.id.tvMostrarCodigoEntrada);
        descripcioText=(TextView)view.findViewById(R.id.tvMostrarDescripcionEntrada);
        edUbicacion = (EditText) view.findViewById(R.id.edUbicacionEntrada);
        edArticulo = (EditText) view.findViewById(R.id.edArticuloEntrada);
        edCantidad = (EditText) view.findViewById(R.id.edCantidadEntrada);
        botonUbicacion = (ImageButton) view.findViewById(R.id.botonUbicacion);
        botonArticulo = (ImageButton) view.findViewById(R.id.botonArticulo);
        anterior = (Button) view.findViewById(R.id.anterior);
        siguiente = (Button) view.findViewById(R.id.siguiente);
        botonCodBarrasUbi = (ImageView) view.findViewById(R.id.botonCodBarrasUbi);
        botonCodBarrasArti = (ImageView) view.findViewById(R.id.botonCodBarrasArti);

        edUbicacion.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                Log.i("onEditorAction","Action ID: "+actionId);
                if(actionId == EditorInfo.IME_ACTION_GO)
                {
                    logicaUbicacion();
                }
                return true;
            }
        });

        edArticulo.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_GO)
                {
                    logicaArticulo();
                }
                return true;
            }
        });

        anterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anterior();
            }
        });

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                siguiente();
            }
        });

        botonUbicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logicaUbicacion();
            }
        });

        botonArticulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logicaArticulo();
            }
        });

        botonCodBarrasUbi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CodigoBarrasActivity.class);
                startActivityForResult(intent, UBI_BARRAS_REQUEST_CODE);
            }
        });

        botonCodBarrasArti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CodigoBarrasActivity.class);
                startActivityForResult(intent, ARTI_BARRAS_REQUEST_CODE);
            }
        });
    }

    private void mostrarDetalleActual(){
        actual = listado.getDetalleRecuento().get(currentItem);
        if(actual != null) {
            String recuento = actual.getRecuento();
            // si no es recicler creo que se añadiria vista dinamicamente en la actividad entrada
            String almacen = actual.getAlmacen();
            String ubicacion = actual.getUbicacion();
            String lote = actual.getLote();
            String codigo = actual.getProducto();
            String descripcion = actual.getDescProducto();
            edCantidad.setText("");
            almacenText.setText(almacen);
            ubicacionText.setText(ubicacion);
            loteText.setText(lote);
            codigoText.setText(codigo);
            descripcioText.setText(descripcion);
            if(actual.getCantidad() != null)
                edCantidad.setText(actual.getCantidad());
        }
    }

    public void siguiente() {
        String cantidad = edCantidad.getText().toString();
        if(cantidad != null && !cantidad.trim().isEmpty() && !cantidad.equals(actual.getCantidad())){
            actual.setCantidad(cantidad);
            EnviarFragment.detallesEnviar.remove(actual.hashCode());
            EnviarFragment.detallesEnviar.put(actual.hashCode(), actual);
        }

        edUbicacion.setText("");
        edArticulo.setText("");
        edCantidad.setEnabled(false);

        if(currentItem < listado.getDetalleRecuento().size() - 1){
            currentItem++;
            mostrarDetalleActual();
        }
    }

    public void anterior() {

        String cantidad = edCantidad.getText().toString();
        if(cantidad != null && !cantidad.trim().isEmpty() && !cantidad.equals(actual.getCantidad())){
            actual.setCantidad(cantidad);
            EnviarFragment.detallesEnviar.remove(actual.hashCode());
            EnviarFragment.detallesEnviar.put(actual.hashCode(), actual);
        }

        edUbicacion.setText("");
        edArticulo.setText("");
        edCantidad.setEnabled(false);

        if(currentItem > 0){
            currentItem--;
            mostrarDetalleActual();
        }
    }

    @Override
    public void onFragmentVisible() {
        Recuento recuento = RecuentosFragment.recuento;
        ServerConnect server = new ServerConnect();

        SharedPreferences preferences = getActivity().getSharedPreferences("config", Context.MODE_PRIVATE);
        String tipoLectura = preferences.getString("TipoLectura", null);
        if(tipoLectura != null){
            if(tipoLectura.equals("ubicacion")){
                edArticulo.setEnabled(false);
                botonArticulo.setEnabled(false);
            }else{
                edUbicacion.setEnabled(false);
                botonUbicacion.setEnabled(false);
            }
        }
        // aqui tendria que cargar  elementos de la base de datos
        // como almacen ubicacion lote y descripcion con la respues del servidor
        String empresa= PrincipalActivity.loginApp.getCodEmpresa();
        String centro=PrincipalActivity.loginApp.getCentro();
        // ServerConnect server = new ServerConnect();
        final ProgressDialog dialog = ProgressDialog.show(getContext(), "", "Consultando entradas de recuento. Por favor, espere...", true);
        server.descargaEntradaRecuento(empresa,centro,recuento.getRecuento(), new Callback<ListadoDetalle>() {
            @Override
            public void onResponse(Call<ListadoDetalle> call, Response<ListadoDetalle> response) {
                dialog.dismiss();
                if(response.isSuccessful()) {
                    listado = response.body();
                    mostrarDetalleActual();
                    if(!listado.getResultado().equals("OK") || listado.getDetalleRecuento().isEmpty()){
                        Toast.makeText(getContext(), "No se han recibido datos", Toast.LENGTH_LONG);
                    }
                }else{
                    Toast.makeText(getContext(), "Error al obtener detalle recuento", Toast.LENGTH_LONG);
                }
            }
            @Override
            public void onFailure(Call<ListadoDetalle> call, Throwable t) {
                Toast.makeText(getContext(), "Error al obtener detalle recuento", Toast.LENGTH_LONG);
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == ALTA_REQUEST_CODE){
            edUbicacion.setText("");
            edArticulo.setText("");
            int createdHash = data.getIntExtra("createdHash", -1);
            if(createdHash > -1){
                listado.getDetalleRecuento().add(EnviarFragment.detallesEnviar.get(createdHash));
            }
        }else if(requestCode == UBI_BARRAS_REQUEST_CODE){
            if(resultCode == Activity.RESULT_OK) {
                edUbicacion.setText(data.getStringExtra("contents"));
            }
        }else if(requestCode == ARTI_BARRAS_REQUEST_CODE){
            if(resultCode == Activity.RESULT_OK) {
                edArticulo.setText(data.getStringExtra("contents"));
            }
        }
    }

    @Override
    public void onPreferencesChange(Class<?> from) {
        super.onPreferencesChange(from);
        if(from.equals(CentroLecturaActivity.class)){
            SharedPreferences preferences = getActivity().getSharedPreferences("config", Context.MODE_PRIVATE);
            String tipoLectura = preferences.getString("TipoLectura", null);
            if(tipoLectura != null){
                if(tipoLectura.equals("ubicacion")){
                    edUbicacion.setEnabled(true);
                    botonUbicacion.setEnabled(true);
                    edArticulo.setEnabled(false);
                    botonArticulo.setEnabled(false);
                }else{
                    edUbicacion.setEnabled(false);
                    botonUbicacion.setEnabled(false);
                    edArticulo.setEnabled(true);
                    botonArticulo.setEnabled(true);
                }
            }
        }
    }
}