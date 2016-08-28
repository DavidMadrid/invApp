package com.example.david.invapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.david.invapp.pojos.pojoCentro.Delegacione;

import java.util.List;

/**
 * Created by david on 23/08/2016.
 */
public class CentroAdapter extends RecyclerView.Adapter<CentroViewHolder> {


 List<Delegacione> listaCentros;

 protected  View.OnClickListener onClickListener;

    public CentroAdapter(List<Delegacione> listaCentros) {
        this.listaCentros = listaCentros;
    }


    public void setOnItemClickListener(View.OnClickListener onClickListener){

        this.onClickListener = onClickListener;

    }

    @Override
    public CentroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.delegaciones_list_item, parent, false);
        view.setOnClickListener(onClickListener);
        return new CentroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CentroViewHolder holder, int position) {

        Delegacione delegacion = listaCentros.get(position);//linkedlist tiene metodo position se lo añado
        // ala delegacion del adaptador

        holder.bindCentro(delegacion);
        holder.itemView.setTag(delegacion);
       /* String nombreDelegacion = delegacion.getCentroCliente();
        holder.tvCentro.setText(nombreDelegacion);

        Esta es una alternativa a llamar a un metodo del ViewHolder,
        funciona exactamente igual, pero tdo lo realizamos desde onBindViewHolder sin
        llamar metodos externos.

        */
    }

    @Override
    public int getItemCount() {
        return listaCentros.size();
    }
    public void addCentro(Delegacione delegacion){
        listaCentros.add(0,delegacion);
        //La notificacion se puede realizar con notifyDataSetChange, pero es menos eficiente porque
        //repintara todo el componente visual, en cambio los notify especificos se basan en la
        //posicion para repintar lo justo
        this.notifyItemInserted(0);
    }

}
