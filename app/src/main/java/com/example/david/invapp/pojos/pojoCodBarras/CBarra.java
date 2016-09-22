package com.example.david.invapp.pojos.pojoCodBarras;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by david on 19/09/2016.
 */
public class CBarra {

    @SerializedName("Articulo")
    @Expose
    private String articulo;
    @SerializedName("EAN")
    @Expose
    private String eAN;

    /**
     *
     * @return
     * The articulo
     */
    public String getArticulo() {
        return articulo;
    }

    /**
     *
     * @param articulo
     * The Articulo
     */
    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    /**
     *
     * @return
     * The eAN
     */
    public String getEAN() {
        return eAN;
    }

    /**
     *
     * @param eAN
     * The EAN
     */
    public void setEAN(String eAN) {
        this.eAN = eAN;
    }

}
