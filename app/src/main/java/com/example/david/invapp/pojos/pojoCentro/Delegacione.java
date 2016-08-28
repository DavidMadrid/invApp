package com.example.david.invapp.pojos.pojoCentro;





    import com.google.gson.annotations.Expose;
    import com.google.gson.annotations.SerializedName;

    import java.io.Serializable;
    import java.util.ArrayList;
    import java.util.List;


public class Delegacione implements Serializable{

        @SerializedName("Empresa")
        @Expose
        private String empresa;
        @SerializedName("Nombre Empresa")
        @Expose
        private String nombreEmpresa;
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
        @SerializedName("CentroCliente")
        @Expose
        private String centroCliente;
        @SerializedName("TipoUsuario")
        @Expose
        private String tipoUsuario;
        @SerializedName("Restricciones")
        @Expose
        private List<Restriccione> restricciones = new ArrayList<Restriccione>();
        @SerializedName("Delegacion")
        @Expose
        private List<Object> delegacion = new ArrayList<Object>();
        @SerializedName("Logisticos")
        @Expose
        private List<Logistico> logisticos = new ArrayList<Logistico>();

        /**
         *
         * @return
         * The empresa
         */
        public String getEmpresa() {
            return empresa;
        }

        /**
         *
         * @param empresa
         * The Empresa
         */
        public void setEmpresa(String empresa) {
            this.empresa = empresa;
        }

        /**
         *
         * @return
         * The nombreEmpresa
         */
        public String getNombreEmpresa() {
            return nombreEmpresa;
        }

        /**
         *
         * @param nombreEmpresa
         * The Nombre Empresa
         */
        public void setNombreEmpresa(String nombreEmpresa) {
            this.nombreEmpresa = nombreEmpresa;
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
         * The centroCliente
         */
        public String getCentroCliente() {
            return centroCliente;
        }

        /**
         *
         * @param centroCliente
         * The CentroCliente
         */
        public void setCentroCliente(String centroCliente) {
            this.centroCliente = centroCliente;
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
         * The restricciones
         */
        public List<Restriccione> getRestricciones() {
            return restricciones;
        }

        /**
         *
         * @param restricciones
         * The Restricciones
         */
        public void setRestricciones(List<Restriccione> restricciones) {
            this.restricciones = restricciones;
        }

        /**
         *
         * @return
         * The delegacion
         */
        public List<Object> getDelegacion() {
            return delegacion;
        }

        /**
         *
         * @param delegacion
         * The Delegacion
         */
        public void setDelegacion(List<Object> delegacion) {
            this.delegacion = delegacion;
        }

        /**
         *
         * @return
         * The logisticos
         */
        public List<Logistico> getLogisticos() {
            return logisticos;
        }

        /**
         *
         * @param logisticos
         * The Logisticos
         */
        public void setLogisticos(List<Logistico> logisticos) {
            this.logisticos = logisticos;
        }

    }
