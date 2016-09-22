package com.example.david.invapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.david.invapp.modeloDAO.DatabaseHandler;
import com.example.david.invapp.pojos.pojoCodBarras.ServerResponse;
import com.example.david.invapp.pojos.pojoEntrada.ListadoDetalle;
import com.example.david.invapp.pojos.pojoEnviar.ResultadoEnviar;
import com.example.david.invapp.pojos.pojoLogin.LoginResult;
import com.example.david.invapp.pojos.pojoEntrada.DetalleRecuento;
import com.example.david.invapp.pojos.pojoPrincipal.ListaRecuentos;
import com.example.david.invapp.pojos.pojoPrincipal.Recuento;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by david on 17/08/2016.
 */
public class ServerConnect {

    public static ServerInterface service;

    public ServerConnect()
    {
        if(service == null) {
            final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .readTimeout(60, TimeUnit.SECONDS)
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .build();
            Retrofit retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("http://tiendahispanofil.sonepar.es/")
                    .client(okHttpClient)
                    .build();
            service = retrofit.create(ServerInterface.class);
        }
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
                    InitApp initApp = (InitApp) activity.getApplication();
                    DatabaseHandler dbHandler = initApp.getDbHandler();
                    dbHandler.addLoginResult(result);
                    Intent intencion = new Intent(activity.getApplicationContext(),PrincipalActivity.class);
                    intencion.putExtra("ID_LOGIN",result.getNameUsuario());
                    SharedPreferences preferences = activity.getSharedPreferences("config", Context.MODE_PRIVATE);
                    preferences.edit().putString("id_login", result.getNameUsuario()).commit();
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

    public void listaPrincipalRecuento(LoginResult loginResult, final PrincipalAdapter2 principalAdapter2) {

        final Call<ListaRecuentos> callPrincipal = service.hacerRecuento(loginResult.getCodEmpresa(),loginResult.getCentro(),null);
        callPrincipal.enqueue(new Callback<ListaRecuentos>() {

            @Override
            public void onResponse(Call<ListaRecuentos> call, Response<ListaRecuentos> response) {
                ListaRecuentos result = response.body();
             /*   for(Recuento recuento : result.getRecuentos())
                {
                    Log.i("ServerConnect",recuento.toString());
                }*/
                principalAdapter2.getListaItems().addAll(result.getRecuentos());
                principalAdapter2.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ListaRecuentos> call, Throwable t) {
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
    //entradaActivity
    public void descargaEntradaRecuento(String empresa, String centro,String recuento, Callback<ListadoDetalle> callback){
        service.entradasRecuento(empresa,centro,recuento).enqueue(callback);
    }
    ///EnviarActualizarActivity//////
    public  void actualizarRecuentos(String empresa,String centro,String recuento,String almacen,String ubicacion,String producto,String lote,
                                     String cantidad,String grupal, Callback<ResultadoEnviar> callback){
        final Call<ResultadoEnviar>callActualiza=service.actualizaRecuento(empresa,centro,recuento,almacen,ubicacion,producto,lote,cantidad,grupal);
        callActualiza.enqueue(callback);
    }

    public void descargaCodBarras(final Activity activity, String empresa, String centro, int start, int limit)
    {
        Call<ResponseBody> codBarrasRequest = service.descargaCodBarras(empresa,centro,start,limit);
        codBarrasRequest.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Log.i("ServerConnect","Codigo respuesta: "+response.code());
                    Log.i("ServerConnect","Respuesta error: "+ (response.isSuccessful() ? response.message() : response.errorBody().string()));

                    String jsonRespuesta = response.body().string();
                    InitApp initApp = (InitApp) activity.getApplication();
                    initApp.getDbHandler().setCodBarras(jsonRespuesta);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
