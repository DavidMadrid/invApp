package com.example.david.invapp;

import com.example.david.invapp.pojos.pojoCentro.Delegacione;
import com.example.david.invapp.pojos.pojoEntrada.ListadoDetalle;
import com.example.david.invapp.pojos.pojoEnviar.ResultadoEnviar;
import com.example.david.invapp.pojos.pojoLogin.LoginResult;
import com.example.david.invapp.pojos.pojoEntrada.DetalleRecuento;
import com.example.david.invapp.pojos.pojoPrincipal.ListaRecuentos;
import com.example.david.invapp.pojos.pojoPrincipal.Recuento;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by david on 17/08/2016.
 */
public interface ServerInterface {

    @POST("wsSIB3/wsRecuentosResumen")
        //solo nos hace falta recuento los demas los obtenemos de la bbdd
        // Call<PrincipalResult> hacerRecuento(@Query("Centro") String centro, @Query("Recuento")String Recuento, @Query("Empresa")String empresa);
    Call<ListaRecuentos> hacerRecuento(@Query("Empresa") String codEmpresa, @Query("Centro") String centro, @Query("Recuento") String numRecuento);

    @POST("wsSIB4/wsListaDelegaciones")
    Call<Delegacione> seleccionarCentro(@Query("Cliente") String cliente, @Query("Empresa") String empresa,
                                        @Query("Marca") String marca, @Query("Token") String token);


    @POST("wsSIB4/wsLogin")
    Call<LoginResult> hacerLogin(@Query("Usuario") String usuario, @Query("Password") String contrasenna);

    ////Enttrada Activity
    @POST("wsSIB4/wsRecuentosDetalle")
    Call<ListadoDetalle> entradasRecuento(@Query("Empresa") String empresa, @Query("Centro") String centro, @Query("Recuento") String recuento);

    ///EnviarActualizarActivity
    @POST("wsSIB4/wsRecuentosActualiza")
    Call<ResultadoEnviar> actualizaRecuento(@Query("Empresa") String empresa, @Query("Centro") String centro, @Query("Recuento") String recuento,
                                            @Query("Almacen") String almacen, @Query("Ubicacion") String ubicacion, @Query("Producto") String producto,
                                            @Query("Lote") String lote, @Query("Cantidad") String cantidad, @Query("Grupal") String grupal);


    //CodigodeBarrasActivity
   // @POST("wsSIB4/vsCodBarras")

}