package com.example.david.invapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.david.invapp.pojos.pojoPrincipal.Recuento;

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

    public void bindCentro(Recuento principalResult) {
        tvCentro.setText(principalResult.getCentro());
        tvRecuento.setText(principalResult.getRecuento());
        tvFecha.setText(principalResult.getFecha());

    }


}
