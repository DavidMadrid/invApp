package com.example.david.invapp.pojos.pojoLogin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Restriccione {
    @SerializedName("PVP")
    @Expose
    private String pVP;
    @SerializedName("Precio")
    @Expose
    private String precio;
    @SerializedName("Dto")
    @Expose
    private String dto;
    @SerializedName("Stock")
    @Expose
    private String stock;

    /**
     *
     * @return
     * The pVP
     */
    public String getPVP() {
        return pVP;
    }

    /**
     *
     * @param pVP
     * The PVP
     */
    public void setPVP(String pVP) {
        this.pVP = pVP;
    }

    /**
     *
     * @return
     * The precio
     */
    public String getPrecio() {
        return precio;
    }

    /**
     *
     * @param precio
     * The Precio
     */
    public void setPrecio(String precio) {
        this.precio = precio;
    }

    /**
     *
     * @return
     * The dto
     */
    public String getDto() {
        return dto;
    }

    /**
     *
     * @param dto
     * The Dto
     */
    public void setDto(String dto) {
        this.dto = dto;
    }

    /**
     *
     * @return
     * The stock
     */
    public String getStock() {
        return stock;
    }

    /**
     *
     * @param stock
     * The Stock
     */
    public void setStock(String stock) {
        this.stock = stock;
    }

    public Restriccione(String pvp, String precio, String dto, String stock)
    {
        this.pVP = pvp;
        this.precio = precio;
        this.dto = dto;
        this.stock = stock;
    }

}


