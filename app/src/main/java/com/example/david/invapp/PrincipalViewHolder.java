package com.example.david.invapp;

import android.widget.TextView;

/**
 * Created by david on 19/08/2016.
 */
public class PrincipalViewHolder {
    private TextView tvCentro;
    private TextView tvRecuento;
    private  TextView tvFecha;

    public PrincipalViewHolder(TextView tvCentro, TextView tvRecuento,TextView tvFecha) {
        this.tvCentro = tvCentro;
        this.tvRecuento = tvRecuento;
        this.tvFecha = tvFecha;
    }

    public TextView getTvCentro() {
        return tvCentro;
    }

    public void setTvCentro(TextView tvCentro) {
        this.tvCentro = tvCentro;
    }

    public TextView getTvRecuento() {
        return tvRecuento;
    }

    public void setTvRecuento(TextView tvRecuento) {
        this.tvRecuento = tvRecuento;
    }

    public TextView getTvFecha() {
        return tvFecha;
    }

    public void setTvFecha(TextView tvFecha) {
        this.tvFecha = tvFecha;
    }


}
