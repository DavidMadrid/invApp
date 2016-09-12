package com.example.david.invapp.pojos.pojoEntrada;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class ListadoDetalle {
    @SerializedName("DetalleRecuento")
    @Expose
    private List<DetalleRecuento> detalleRecuento = new ArrayList<DetalleRecuento>();
    @SerializedName("Resultado")
    @Expose
    private String resultado;

    /**
     *
     * @return
     * The detalleRecuento
     */
    public List<DetalleRecuento> getDetalleRecuento() {
        return detalleRecuento;
    }

    /**
     *
     * @param detalleRecuento
     * The DetalleRecuento
     */
    public void setDetalleRecuento(List<DetalleRecuento> detalleRecuento) {
        this.detalleRecuento = detalleRecuento;
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


