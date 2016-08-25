package com.example.david.invapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.david.invapp.pojos.PrincipalResult;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by david on 19/08/2016.
 */
public class PrincipalAdapter extends BaseAdapter {


    public List<PrincipalResult> getResultados() {
        return resultados;
    }

    private List<PrincipalResult> resultados;
    protected  View.OnClickListener onClickListener;
    public PrincipalAdapter(List<PrincipalResult> resultados) {
        this.resultados = new LinkedList<>(resultados);
    }

    @Override
    public int getCount() {
        return resultados.size();
    }

    @Override
    public Object getItem(int position) {
        return resultados.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroupParent) {

        PrincipalResult resultado = resultados.get(position);
        if(convertView==null){
          convertView = LayoutInflater.from(viewGroupParent.getContext()).inflate(R.layout.principal_list_item,viewGroupParent,false);
          convertView.setTag(new PrincipalViewHolder((TextView)convertView.findViewById(R.id.tvCentroPrincipal),(TextView)convertView.findViewById(R.id.tvRecuento),
                  (TextView)convertView.findViewById(R.id.tvFechaPrincipal)));
            //convertView.setTag(resultado);
            ((PrincipalViewHolder)convertView.getTag()).getTvCentro().setText(resultado.getCentro());
            ((PrincipalViewHolder)convertView.getTag()).getTvRecuento().setText(resultado.getRecuento());
            ((PrincipalViewHolder)convertView.getTag()).getTvFecha().setText(resultado.getFecha());
    }


   return convertView;
    }
}
