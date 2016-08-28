package com.example.david.invapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.david.invapp.pojos.pojoCentro.Delegacione;


/**
 * Created by david on 23/08/2016.
 */
public class CentroViewHolder extends RecyclerView.ViewHolder { //implements View.OnClickListener

public TextView tvCentro;

    public CentroViewHolder(View itemView) {
        super(itemView);
        tvCentro = (TextView) itemView.findViewById(R.id.tvCentroPrincipal);
        /* itemView.setOnClickListener(this);

        Esta seria una alternativa al ClickListener desde la Activity,
        pero en este caso no seria lo mas adecuado porque al querer
        realizar un Intent necesitamos minimo el Context y para ello
        el ViewHolder deberia tenerlo almacenado (EN ESTE CASO NO RECOMENDABLE).
         */

    }

    public void bindCentro(Delegacione delegacion) {
        tvCentro.setText(delegacion.getCentroCliente());

    }

    /**
     * @Override
     * public void onClick(View view)
     * {
     *     Metodo que tendriamos al implementar la interfaz View.OnClickListener
     * }
     */





}
