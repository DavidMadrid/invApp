package com.example.david.invapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.david.invapp.pojos.Delegacione;
import com.example.david.invapp.pojos.LoginResult;
import com.example.david.invapp.pojos.PrincipalResult;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by david on 17/08/2016.
 */
public class ServerConnect {

    ServerInterface service;

    public ServerConnect()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://tiendahispanofil.sonepar.es/")
                .build();
        service = retrofit.create(ServerInterface.class);

    }

    public void realizarLogin(final Activity activity, String usuario, String contrasenna)
    {
        final Call<LoginResult> callLogin = service.hacerLogin(usuario,contrasenna);
        callLogin.enqueue(new Callback<LoginResult>() {
            @Override
            public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {
                LoginResult result = response.body();
                String tipoUsuario = result.getTipoUsuario();
                String resultado = result.getResultado();
            if(!(resultado.equals("OK"))) {
                Toast.makeText(activity, "su registro ha sido" + resultado, Toast.LENGTH_SHORT).show();

            }else{

                if(tipoUsuario.equals("CPOMERCIAL")){

                    Toast.makeText(activity, "su registro ha sido" + resultado, Toast.LENGTH_SHORT).show();
                }else{
                    //almacenar en la base de datos
                    Intent intencion = new Intent(activity.getApplicationContext(),PrincipalActivity.class);
                    activity.startActivity(intencion);
                    activity.finish();


                }
            }

            }

            @Override
            public void onFailure(Call<LoginResult> call, Throwable t) {
                /**
                 * Este metodo se podria usar en caso de que el servidor
                 * nos mandara respuestas de error con solicitudes erroneas.
                 * Ahora mismo nos indica los errores en el JSON de respuesta.
                 */
            }
        });




    }

    public void listaPrincipalRecuento(String recuento) {

        final Call<PrincipalResult> callPrincipal = service.hacerRecuento(recuento);
        callPrincipal.enqueue(new Callback<PrincipalResult>() {
           // PrincipalAdapter principalAdapter = list

            @Override
            public void onResponse(Call<PrincipalResult> call, Response<PrincipalResult> response) {

                //creo que aqui meteria el adaptador


            }

            @Override
            public void onFailure(Call<PrincipalResult> call, Throwable t) {
                /**
                 * Este metodo se podria usar en caso de que el servidor
                 * nos mandara respuestas de error con solicitudes erroneas.
                 * Ahora mismo nos indica los errores en el JSON de respuesta.
                 */

            }
        });
    }

 /*   public void descargarCentro(final RecyclerView listaCentros, String cliente, String empresa, String marca, String token){
   //     final Call<ListaRecuentos>callResult =  service.seleccionarCentro(cliente,empresa,marca,token);
    //    callResult.enqueue(new Callback<ListaRecuentos>() {
            @Override
            public void onResponse(Call<ListaRecuentos> call, Response<ListaRecuentos> response) {
                CentroAdapter adapter = listaCentros.getAdapter();
                for(Delegacione centro : response.body().getRecuentos()) //meter metodo para meterle toda la lista
                {
                    adapter.getListado().add(centro);
                }
               // adapter.getListado().addAll(response.body().getRecuentos()); (Alternativa al bucle)
                adapter.notifyDataSetChanged();
                // aqui  podriamos poner intencion y mandarnos a CentrosLecturactivity segun
                //item numero de centro que hayamos seleccionado

            }

            @Override
            public void onFailure(Call<Delegacione> call, Throwable t) {
                /**
                 * Este metodo se podria usar en caso de que el servidor
                 * nos mandara respuestas de error con solicitudes erroneas.
                 * Ahora mismo nos indica los errores en el JSON de respuesta.

            }
        });

    }
*/
}
