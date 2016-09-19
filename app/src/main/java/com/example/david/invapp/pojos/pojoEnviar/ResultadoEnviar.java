package com.example.david.invapp.pojos.pojoEnviar;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by david on 13/09/2016.
 */
public class ResultadoEnviar {
    @SerializedName("Resultado")
    @Expose
    private String resultado;
    @SerializedName("Incidencia")
    @Expose
    private String incidencia;

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

    /**
     *
     * @return
     * The incidencia
     */
    public String getIncidencia() {
        return incidencia;
    }

    /**
     *
     * @param incidencia
     * The Incidencia
     */
    public void setIncidencia(String incidencia) {
        this.incidencia = incidencia;
    }
}
