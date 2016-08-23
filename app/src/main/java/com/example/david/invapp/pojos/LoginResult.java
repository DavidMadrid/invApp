package com.example.david.invapp.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 17/08/2016.
 */
public class LoginResult {

    @SerializedName("CodEmpresa")
    @Expose
    private String codEmpresa;
    @SerializedName("NameEmpresa")
    @Expose
    private String nameEmpresa;
    @SerializedName("Centro")
    @Expose
    private String centro;
    @SerializedName("CodMarca")
    @Expose
    private String codMarca;
    @SerializedName("NameMarca")
    @Expose
    private String nameMarca;
    @SerializedName("Usuario")
    @Expose
    private String usuario;
    @SerializedName("NameUsuario")
    @Expose
    private String nameUsuario;
    @SerializedName("TipoUsuario")
    @Expose
    private String tipoUsuario;
    @SerializedName("MailUsuario")
    @Expose
    private String mailUsuario;
    @SerializedName("MailRepresentante")
    @Expose
    private String mailRepresentante;
    @SerializedName("TelefonoRepresentante")
    @Expose
    private String telefonoRepresentante;
    @SerializedName("UrlInicio")
    @Expose
    private String urlInicio;
    @SerializedName("PerfilUsuario")
    @Expose
    private String perfilUsuario;
    @SerializedName("VersionIosAPP")
    @Expose
    private String versionIosAPP;
    @SerializedName("VersionAndroidAPP")
    @Expose
    private String versionAndroidAPP;
    @SerializedName("CambioCondicionesAPP")
    @Expose
    private String cambioCondicionesAPP;
    @SerializedName("Gamificacion")
    @Expose
    private String gamificacion;
    @SerializedName("Restricciones")
    @Expose
    private List<Object> restricciones = new ArrayList<Object>();
    @SerializedName("Token")
    @Expose
    private String token;
    @SerializedName("Resultado")
    @Expose
    private String resultado;

    /**
     *
     * @return
     * The codEmpresa
     */
    public String getCodEmpresa() {
        return codEmpresa;
    }

    /**
     *
     * @param codEmpresa
     * The CodEmpresa
     */
    public void setCodEmpresa(String codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    /**
     *
     * @return
     * The nameEmpresa
     */
    public String getNameEmpresa() {
        return nameEmpresa;
    }

    /**
     *
     * @param nameEmpresa
     * The NameEmpresa
     */
    public void setNameEmpresa(String nameEmpresa) {
        this.nameEmpresa = nameEmpresa;
    }

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
     * The codMarca
     */
    public String getCodMarca() {
        return codMarca;
    }

    /**
     *
     * @param codMarca
     * The CodMarca
     */
    public void setCodMarca(String codMarca) {
        this.codMarca = codMarca;
    }

    /**
     *
     * @return
     * The nameMarca
     */
    public String getNameMarca() {
        return nameMarca;
    }

    /**
     *
     * @param nameMarca
     * The NameMarca
     */
    public void setNameMarca(String nameMarca) {
        this.nameMarca = nameMarca;
    }

    /**
     *
     * @return
     * The usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     *
     * @param usuario
     * The Usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     *
     * @return
     * The nameUsuario
     */
    public String getNameUsuario() {
        return nameUsuario;
    }

    /**
     *
     * @param nameUsuario
     * The NameUsuario
     */
    public void setNameUsuario(String nameUsuario) {
        this.nameUsuario = nameUsuario;
    }

    /**
     *
     * @return
     * The tipoUsuario
     */
    public String getTipoUsuario() {
        return tipoUsuario;
    }

    /**
     *
     * @param tipoUsuario
     * The TipoUsuario
     */
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    /**
     *
     * @return
     * The mailUsuario
     */
    public String getMailUsuario() {
        return mailUsuario;
    }

    /**
     *
     * @param mailUsuario
     * The MailUsuario
     */
    public void setMailUsuario(String mailUsuario) {
        this.mailUsuario = mailUsuario;
    }

    /**
     *
     * @return
     * The mailRepresentante
     */
    public String getMailRepresentante() {
        return mailRepresentante;
    }

    /**
     *
     * @param mailRepresentante
     * The MailRepresentante
     */
    public void setMailRepresentante(String mailRepresentante) {
        this.mailRepresentante = mailRepresentante;
    }

    /**
     *
     * @return
     * The telefonoRepresentante
     */
    public String getTelefonoRepresentante() {
        return telefonoRepresentante;
    }

    /**
     *
     * @param telefonoRepresentante
     * The TelefonoRepresentante
     */
    public void setTelefonoRepresentante(String telefonoRepresentante) {
        this.telefonoRepresentante = telefonoRepresentante;
    }

    /**
     *
     * @return
     * The urlInicio
     */
    public String getUrlInicio() {
        return urlInicio;
    }

    /**
     *
     * @param urlInicio
     * The UrlInicio
     */
    public void setUrlInicio(String urlInicio) {
        this.urlInicio = urlInicio;
    }

    /**
     *
     * @return
     * The perfilUsuario
     */
    public String getPerfilUsuario() {
        return perfilUsuario;
    }

    /**
     *
     * @param perfilUsuario
     * The PerfilUsuario
     */
    public void setPerfilUsuario(String perfilUsuario) {
        this.perfilUsuario = perfilUsuario;
    }

    /**
     *
     * @return
     * The versionIosAPP
     */
    public String getVersionIosAPP() {
        return versionIosAPP;
    }

    /**
     *
     * @param versionIosAPP
     * The VersionIosAPP
     */
    public void setVersionIosAPP(String versionIosAPP) {
        this.versionIosAPP = versionIosAPP;
    }

    /**
     *
     * @return
     * The versionAndroidAPP
     */
    public String getVersionAndroidAPP() {
        return versionAndroidAPP;
    }

    /**
     *
     * @param versionAndroidAPP
     * The VersionAndroidAPP
     */
    public void setVersionAndroidAPP(String versionAndroidAPP) {
        this.versionAndroidAPP = versionAndroidAPP;
    }

    /**
     *
     * @return
     * The cambioCondicionesAPP
     */
    public String getCambioCondicionesAPP() {
        return cambioCondicionesAPP;
    }

    /**
     *
     * @param cambioCondicionesAPP
     * The CambioCondicionesAPP
     */
    public void setCambioCondicionesAPP(String cambioCondicionesAPP) {
        this.cambioCondicionesAPP = cambioCondicionesAPP;
    }

    /**
     *
     * @return
     * The gamificacion
     */
    public String getGamificacion() {
        return gamificacion;
    }

    /**
     *
     * @param gamificacion
     * The Gamificacion
     */
    public void setGamificacion(String gamificacion) {
        this.gamificacion = gamificacion;
    }

    /**
     *
     * @return
     * The restricciones
     */
    public List<Object> getRestricciones() {
        return restricciones;
    }

    /**
     *
     * @param restricciones
     * The Restricciones
     */
    public void setRestricciones(List<Object> restricciones) {
        this.restricciones = restricciones;
    }

    /**
     *
     * @return
     * The token
     */
    public String getToken() {
        return token;
    }

    /**
     *
     * @param token
     * The Token
     */
    public void setToken(String token) {
        this.token = token;
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
