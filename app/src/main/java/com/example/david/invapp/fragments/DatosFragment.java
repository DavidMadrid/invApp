package com.example.david.invapp.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.david.invapp.R;
import com.example.david.invapp.pojos.pojoPrincipal.Recuento;

public class DatosFragment extends FormParentFragment {

    TextView centro;
    TextView recuento;
    TextView fecha;
    TextView almacenInicial;
    TextView almacenFinal;
    TextView ubicacionInicial;
    TextView ubicacionFinal;
    TextView articuloIncial;
    TextView articuloFinal;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_layout_datos, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        centro = (TextView) view.findViewById(R.id.tvMostrarCentro);
        recuento =(TextView) view.findViewById(R.id.tvMostrarUbicacionEntrada);
        fecha =(TextView) view.findViewById(R.id.tvMostrarLoteEntrada);
        almacenInicial = (TextView) view.findViewById(R.id.tvAlmacenMostrarI);
        almacenFinal =  (TextView) view.findViewById(R.id.tvMostrarAlmacenF);
        ubicacionInicial =(TextView) view.findViewById(R.id.tvUbicacionMostrarI);
        ubicacionFinal =(TextView) view.findViewById(R.id.tvMostrarUbicacionF);
        articuloIncial = (TextView) view.findViewById(R.id.tvArticuloMostrarI);
        articuloFinal = (TextView) view.findViewById(R.id.tvMostrarArticuloF);
    }

    @Override
    public void onFragmentVisible() {
        Recuento result = RecuentosFragment.recuento;
        if(result != null) {
            centro.setText(result.getCentro());
            recuento.setText(result.getRecuento());
            fecha.setText(result.getFecha());
            almacenInicial.setText(result.getAlmacenInicial());
            almacenFinal.setText(result.getAlmacenFinal());
            ubicacionInicial.setText(result.getUbicacionInicial());
            ubicacionFinal.setText(result.getUbicacionFinal());
            ubicacionInicial.setText(result.getUbicacionInicial());
            ubicacionFinal.setText(result.getUbicacionFinal());
            articuloIncial.setText(result.getProductoInicial());
            articuloFinal.setText(result.getProductoFinal());
        }
    }
}