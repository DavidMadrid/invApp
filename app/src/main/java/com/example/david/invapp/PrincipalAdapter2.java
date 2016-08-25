package com.example.david.invapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.david.invapp.CentroViewHolder;
import com.example.david.invapp.pojos.Delegacione;
import com.example.david.invapp.pojos.ListaRecuentos;
import com.example.david.invapp.pojos.PrincipalResult;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by david on 25/08/2016.
 */
public class PrincipalAdapter2 extends RecyclerView.Adapter<Principal2ViewHolder> {

    private List<PrincipalResult> resultados;
    protected  View.OnClickListener miEscuchador;

    public PrincipalAdapter2(List<PrincipalResult> resultados) {
        this.resultados = new LinkedList<>(resultados);
    }
    public void setOnItemClickListener(View.OnClickListener miEscuchador){

        this.miEscuchador = miEscuchador;

    }
    @Override
    public Principal2ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.delegaciones_list_item, parent, false);
        view.setOnClickListener(miEscuchador);
        return new Principal2ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(Principal2ViewHolder holder, int position) {

        PrincipalResult principal = resultados.get(position);
        holder.bindCentro(principal);
        holder.itemView.setTag(principal);
    }



    @Override
    public int getItemCount() { return resultados.size();}

        public void addCentro(PrincipalResult principal){
            resultados.add(0,principal);
            //La notificacion se puede realizar con notifyDataSetChange, pero es menos eficiente porque
            //repintara todo el componente visual, en cambio los notify especificos se basan en la
            //posicion para repintar lo justo
            this.notifyItemInserted(0);
        }
}
