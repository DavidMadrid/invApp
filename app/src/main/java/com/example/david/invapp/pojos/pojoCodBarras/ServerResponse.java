package com.example.david.invapp.pojos.pojoCodBarras;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 19/09/2016.
 */
public class ServerResponse {

    @SerializedName("Datos")
    @Expose
    private List<Datos> datos = new ArrayList<Datos>();

    /**
     *
     * @return
     * The datos
     */
    public List<Datos> getDatos() {
        return datos;
    }

    /**
     *
     * @param datos
     * The Datos
     */
    public void setDatos(List<Datos> datos) {
        this.datos = datos;
    }

}
