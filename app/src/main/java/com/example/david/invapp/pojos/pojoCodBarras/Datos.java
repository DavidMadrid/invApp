package com.example.david.invapp.pojos.pojoCodBarras;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 19/09/2016.
 */
public class Datos {

    @SerializedName("Cbarras")
    @Expose
    private List<CBarra> cbarras = new ArrayList<CBarra>();
    @SerializedName("TotalRegistros")
    @Expose
    private String totalRegistros;
    @SerializedName("Resultado")
    @Expose
    private String resultado;

    /**
     *
     * @return
     * The cbarras
     */
    public List<CBarra> getCbarras() {
        return cbarras;
    }

    /**
     *
     * @param cbarras
     * The Cbarras
     */
    public void setCbarras(List<CBarra> cbarras) {
        this.cbarras = cbarras;
    }

    /**
     *
     * @return
     * The totalRegistros
     */
    public String getTotalRegistros() {
        return totalRegistros;
    }

    /**
     *
     * @param totalRegistros
     * The TotalRegistros
     */
    public void setTotalRegistros(String totalRegistros) {
        this.totalRegistros = totalRegistros;
    }

    /**
     *
     * @return
     * The resultado
     */
    public String getResultado() {
        return resultado;
    }

    /**
     *
     * @param resultado
     * The Resultado
     */
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

}