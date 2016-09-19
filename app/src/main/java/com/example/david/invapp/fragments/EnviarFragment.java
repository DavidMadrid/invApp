package com.example.david.invapp.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.david.invapp.PrincipalActivity;
import com.example.david.invapp.R;
import com.example.david.invapp.ServerConnect;
import com.example.david.invapp.pojos.pojoEntrada.DetalleRecuento;
import com.example.david.invapp.pojos.pojoEnviar.ResultadoEnviar;
import com.example.david.invapp.pojos.pojoPrincipal.Recuento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EnviarFragment extends FormParentFragment {

    private Iterator<DetalleRecuento> iterator;
    private ServerConnect server;
    private Button botonActualizar;

    public static HashMap<Integer, DetalleRecuento> detallesEnviar = new HashMap<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_layout_enviar, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        server = new ServerConnect();
        botonActualizar = (Button) view.findViewById(R.id.actualizar);
        botonActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(detallesEnviar.values().size() >  0) {
                    iterator = detallesEnviar.values().iterator();
                    nextSend();
                }
            }
        });
    }

    @Override
    public void onFragmentVisible() {

    }

    private void nextSend(){
        if(iterator.hasNext()) {
            final DetalleRecuento detalleRecuento = iterator.next();
            String empresa = PrincipalActivity.loginApp.getCodEmpresa();
            String centro = PrincipalActivity.loginApp.getCentro();
            Recuento recuento = RecuentosFragment.recuento;
            server.actualizarRecuentos(empresa, centro, recuento.getRecuento(), detalleRecuento.getAlmacen(), detalleRecuento.getUbicacion(), detalleRecuento.getProducto(), detalleRecuento.getLote(), detalleRecuento.getCantidad(), "N", new Callback<ResultadoEnviar>() {
                @Override
                public void onResponse(Call<ResultadoEnviar> call, Response<ResultadoEnviar> response) {
                    if(!response.isSuccessful() || !response.body().getResultado().equals("OK")){
                        Toast.makeText(getActivity(), "Error al actualizar detalle recuento " + detalleRecuento.getProducto(), Toast.LENGTH_LONG).show();
                    }else{
                        iterator.remove();
                    }
                    nextSend();
                }

                @Override
                public void onFailure(Call<ResultadoEnviar> call, Throwable t) {
                    Toast.makeText(getActivity(), "Error al contactar con el servicio", Toast.LENGTH_LONG).show();
                    nextSend();
                }
            });
        }else{
            Toast.makeText(getActivity(), "Detalles recuento actualizados", Toast.LENGTH_LONG).show();
        }
    }
}