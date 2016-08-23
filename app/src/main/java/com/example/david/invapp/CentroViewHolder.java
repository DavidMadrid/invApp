package com.example.david.invapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.david.invapp.pojos.Delegacione;


/**
 * Created by david on 23/08/2016.
 */
public class CentroViewHolder extends RecyclerView.ViewHolder {

private TextView tvCentro;

    public CentroViewHolder(View itemView) {
      //  super(itemView);
        tvCentro = (TextView) itemView.findViewById(R.id.tvCentro);

    }

    public void bindCentro(Delegacione delegacion) {
        tvCentro.setText(delegacion.getCentroCliente());

    }





}
