package com.example.david.invapp.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by david on 18/08/2016.
 */
public class PrincipalResult implements Serializable {

    @SerializedName("Centro")
    @Expose
    private String centro;
    @SerializedName("Recuento")
    @Expose
    private String recuento;
    @SerializedName("Fecha")
    @Expose
    private String fecha;
    @SerializedName("AlmacenInicial")
    @Expose
    private String almacenInicial;
    @SerializedName("AlmacenFinal")
    @Expose
    private String almacenFinal;
    @SerializedName("UbicacionInicial")
    @Expose
    private String ubicacionInicial;
    @SerializedName("UbicacionFinal")
    @Expose
    private String ubicacionFinal;
    @SerializedName("ProductoInicial")
    @Expose
    private String productoInicial;
    @SerializedName("ProductoFinal")
    @Expose
    private String productoFinal;

    /**
     *
     * @return
     * The centro
     */
    public String getCentro() {
        return centro;
    }

    /**
     *
     * @param centro
     * The Centro
     */
    public void setCentro(String centro) {
        this.centro = centro;
    }

    /**
     *
     * @return
     * The recuento
     */
    public String getRecuento() {
        return recuento;
    }

    /**
     *
     * @param recuento
     * The Recuento
     */
    public void setRecuento(String recuento) {
        this.recuento = recuento;
    }

    /**
     *
     * @return
     * The fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     *
     * @param fecha
     * The Fecha
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     *
     * @return
     * The almacenInicial
     */
    public String getAlmacenInicial() {
        return almacenInicial;
    }

    /**
     *
     * @param almacenInicial
     * The AlmacenInicial
     */
    public void setAlmacenInicial(String almacenInicial) {
        this.almacenInicial = almacenInicial;
    }

    /**
     *
     * @return
     * The almacenFinal
     */
    public String getAlmacenFinal() {
        return almacenFinal;
    }

    /**
     *
     * @param almacenFinal
     * The AlmacenFinal
     */
    public void setAlmacenFinal(String almacenFinal) {
        this.almacenFinal = almacenFinal;
    }

    /**
     *
     * @return
     * The ubicacionInicial
     */
    public String getUbicacionInicial() {
        return ubicacionInicial;
    }

    /**
     *
     * @param ubicacionInicial
     * The UbicacionInicial
     */
    public void setUbicacionInicial(String ubicacionInicial) {
        this.ubicacionInicial = ubicacionInicial;
    }

    /**
     *
     * @return
     * The ubicacionFinal
     */
    public String getUbicacionFinal() {
        return ubicacionFinal;
    }

    /**
     *
     * @param ubicacionFinal
     * The UbicacionFinal
     */
    public void setUbicacionFinal(String ubicacionFinal) {
        this.ubicacionFinal = ubicacionFinal;
    }

    /**
     *
     * @return
     * The productoInicial
     */
    public String getProductoInicial() {
        return productoInicial;
    }

    /**
     *
     * @param productoInicial
     * The ProductoInicial
     */
    public void setProductoInicial(String productoInicial) {
        this.productoInicial = productoInicial;
    }

    /**
     *
     * @return
     * The productoFinal
     */
    public String getProductoFinal() {
        return productoFinal;
    }

    /**
     *
     * @param productoFinal
     * The ProductoFinal
     */
    public void setProductoFinal(String productoFinal) {
        this.productoFinal = productoFinal;
    }

}



