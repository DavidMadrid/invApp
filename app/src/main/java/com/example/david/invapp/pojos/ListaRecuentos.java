package com.example.david.invapp.pojos;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


import java.util.ArrayList;
import java.util.List;


public class ListaRecuentos {


    @SerializedName("Recuentos")
    @Expose
    private List<Recuento> recuentos = new ArrayList<Recuento>();
    @SerializedName("Resultado")
    @Expose
    private String resultado;

    /**
     *
     * @return
     * The recuentos
     */
    public List<Recuento> getRecuentos() {
        return recuentos;
    }

    /**
     *
     * @param recuentos
     * The Recuentos
     */
    public void setRecuentos(List<Recuento> recuentos) {
        this.recuentos = recuentos;
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





