package com.example.david.invapp.pojos.pojoEntrada;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class DetalleRecuento {

    @SerializedName("Centro")
    @Expose
    private String centro;
    @SerializedName("Recuento")
    @Expose
    private String recuento;
    @SerializedName("Fecha")
    @Expose
    private String fecha;
    @SerializedName("Almacen")
    @Expose
    private String almacen;
    @SerializedName("Ubicacion")
    @Expose
    private String ubicacion;
    @SerializedName("Subhueco")
    @Expose
    private String subhueco;
    @SerializedName("Lote")
    @Expose
    private String lote;
    @SerializedName("Producto")
    @Expose
    private String producto;
    @SerializedName("DescProducto")
    @Expose
    private String descProducto;
    @SerializedName("EAN")
    @Expose
    private String eAN;
    @SerializedName("Cantidad")
    @Expose
    private String cantidad;
    @SerializedName("CantRecontada")
    @Expose
    private String cantRecontada;

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
     * The almacen
     */
    public String getAlmacen() {
        return almacen;
    }

    /**
     *
     * @param almacen
     * The Almacen
     */
    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    /**
     *
     * @return
     * The ubicacion
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     *
     * @param ubicacion
     * The Ubicacion
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     *
     * @return
     * The subhueco
     */
    public String getSubhueco() {
        return subhueco;
    }

    /**
     *
     * @param subhueco
     * The Subhueco
     */
    public void setSubhueco(String subhueco) {
        this.subhueco = subhueco;
    }

    /**
     *
     * @return
     * The lote
     */
    public String getLote() {
        return lote;
    }

    /**
     *
     * @param lote
     * The Lote
     */
    public void setLote(String lote) {
        this.lote = lote;
    }

    /**
     *
     * @return
     * The producto
     */
    public String getProducto() {
        return producto;
    }

    /**
     *
     * @param producto
     * The Producto
     */
    public void setProducto(String producto) {
        this.producto = producto;
    }

    /**
     *
     * @return
     * The descProducto
     */
    public String getDescProducto() {
        return descProducto;
    }

    /**
     *
     * @param descProducto
     * The DescProducto
     */
    public void setDescProducto(String descProducto) {
        this.descProducto = descProducto;
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

    /**
     *
     * @return
     * The cantidad
     */
    public String getCantidad() {
        return cantidad;
    }

    /**
     *
     * @param cantidad
     * The Cantidad
     */
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    /**
     *
     * @return
     * The cantRecontada
     */
    public String getCantRecontada() {
        return cantRecontada;
    }

    /**
     *
     * @param cantRecontada
     * The CantRecontada
     */
    public void setCantRecontada(String cantRecontada) {
        this.cantRecontada = cantRecontada;
    }

}
