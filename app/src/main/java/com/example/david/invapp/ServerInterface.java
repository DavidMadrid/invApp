package com.example.david.invapp;

import com.example.david.invapp.pojos.Delegacione;
import com.example.david.invapp.pojos.LoginResult;
import com.example.david.invapp.pojos.PrincipalResult;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by david on 17/08/2016.
 */
public interface ServerInterface {

    @POST("wsSIB3/wsRecuentosResumen")
    Call<PrincipalResult> hacerRecuento(@Query("Centro") String centro, @Query("Recuento")String Recuento, @Query("Empresa")String empresa);


    @POST("wsSIB4/wsListaDelegaciones")
    Call<Delegacione> seleccionarCentro(@Query("Cliente") String cliente, @Query("Empresa") String empresa,
                                        @Query("Marca") String marca, @Query("Token") String token);


    @POST("wsSIB4/wsLogin")
    Call<LoginResult> hacerLogin(@Query("Usuario") String usuario, @Query("Password") String contrasenna);


}
