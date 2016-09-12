package com.example.david.invapp.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.david.invapp.R;
import com.example.david.invapp.pojos.pojoEntrada.DetalleRecuento;

import java.util.ArrayList;
import java.util.List;

public class EnviarFragment extends FormParentFragment {


    public static List<DetalleRecuento> detallesEnviar = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_layout_enviar, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onFragmentVisible() {

    }
}