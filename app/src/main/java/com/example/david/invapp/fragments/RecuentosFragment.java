package com.example.david.invapp.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.david.invapp.EntradaActivity;
import com.example.david.invapp.InitApp;
import com.example.david.invapp.PrincipalActivity;
import com.example.david.invapp.PrincipalAdapter2;
import com.example.david.invapp.R;
import com.example.david.invapp.ServerConnect;
import com.example.david.invapp.modeloDAO.DatabaseHandler;
import com.example.david.invapp.pojos.pojoLogin.LoginResult;
import com.example.david.invapp.pojos.pojoPrincipal.Recuento;

import java.util.ArrayList;
import java.util.List;

public class RecuentosFragment extends FormParentFragment {

    public static Recuento recuento;
    private List<Recuento> resultados;
    private RecyclerView principalRecuentos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_layout_recuentos, container, false);
        return v;
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        principalRecuentos = (RecyclerView) view.findViewById(R.id.rvRecuentos);
        principalRecuentos.setLayoutManager(new LinearLayoutManager(getContext().getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        resultados = new ArrayList<>();
        final PrincipalAdapter2 adapter2 = new PrincipalAdapter2(resultados);
        principalRecuentos.setAdapter(adapter2);
        Button miboton = (Button) view.findViewById(R.id.btLupa);
        ServerConnect server = new ServerConnect();
        server.listaPrincipalRecuento(PrincipalActivity.loginApp,adapter2);//para cargar la lista entera

        //accion de pulsar un elemento de la lista y llevarnos ala pagina de datos
        adapter2.setOnItemClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recuento = (Recuento) view.getTag();
                Toast.makeText(getContext(), "Recuento seleccionado", Toast.LENGTH_SHORT).show();
            }
        });
        // accion  de mostrar todos los items o solo los que coinciden con recuento
        miboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //    hay que meterle los objetos de reciclerview
                // abria que pasarle el recuento pero solo de los item que coincidan por el recuento tecleado
                EditText etNumeroRecuento = (EditText) view.findViewById(R.id.edNumeroRecuento);
                String numeroRecuentoIntroducido = etNumeroRecuento.getText().toString();
                for(Recuento item : adapter2.getListaItems())
                {
                    if(!item.getRecuento().equals(numeroRecuentoIntroducido) && !numeroRecuentoIntroducido.equals(""))
                    {
                        item.setElementoOculto(true);
                    }
                    else {
                        item.setElementoOculto(false);
                    }
                }
                adapter2.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onFragmentVisible() {

    }
}