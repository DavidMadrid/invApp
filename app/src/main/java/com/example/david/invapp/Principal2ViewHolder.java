package com.example.david.invapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.david.invapp.pojos.Delegacione;
import com.example.david.invapp.pojos.ListaRecuentos;
import com.example.david.invapp.pojos.PrincipalResult;

/**
 * Created by david on 25/08/2016.
 */
public class Principal2ViewHolder extends RecyclerView.ViewHolder{
//se llenan con la base de datos
    private TextView tvCentro;
    private TextView tvRecuento;
    private  TextView tvFecha;


    public Principal2ViewHolder(View itemView) {
        super(itemView);
      ListView listadoRecuentos = (ListView) itemView.findViewById(R.id.lvRecuentos);
         tvCentro = (TextView) itemView.findViewById(R.id.tvCentroPrincipal);
         tvRecuento= (TextView) itemView.findViewById(R.id.tvRecuentoPrincipal);
         tvFecha =  (TextView) itemView.findViewById(R.id.tvFechaPrincipal);
        /* itemView.setOnClickListener(this);

        Esta seria una alternativa al ClickListener desde la Activity,
        pero en este caso no seria lo mas adecuado porque al querer
        realizar un Intent necesitamos minimo el Context y para ello
        el ViewHolder deberia tenerlo almacenado (EN ESTE CASO NO RECOMENDABLE).
         */

    }

    public void bindCentro(PrincipalResult principalResult) {
        tvCentro.setText(principalResult.getAlmacenInicial());
        tvRecuento.setText(principalResult.getRecuento());
        tvFecha.setText(principalResult.getFecha());

    }


}
