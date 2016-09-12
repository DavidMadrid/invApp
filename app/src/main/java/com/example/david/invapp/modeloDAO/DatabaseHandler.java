package com.example.david.invapp.modeloDAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.david.invapp.pojos.pojoLogin.LoginResult;
import com.example.david.invapp.pojos.pojoLogin.Restriccione;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 26/08/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    private static final String TABLE_NAME = "inventario";
    private static final String KEY_COD_EMPRESA = "cod_empresa";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME_EMPRESA = "name_empresa";
    private static final String KEY_CENTRO = "centro";
    private static final String KEY_COD_MARCA = "cod_marca";
    private static final String KEY_NAME_MARCA = "name_marca";
    private static final String KEY_USUARIO = "usuario";
    private static final String KEY_NAME_USUARIO = "name_usuario";
    private static final String KEY_TIPO_USUARIO = "tipo_usuario";
    private static final String KEY_MAIL_USUARIO = "mail_usuario";
    private static final String KEY_MAIL_REPRESENTANTE = "mail_representate";
    private static final String KEY_TELEFONO_REPRESENTANTE = "telefono_representate";
    private static final String KEY_URL_INICIO = "url_inicio";
    private static final String KEY_PERFIL_USUARIO = "perfil_usuario";
    private static final String KEY_VERSION_IOS_APP = "version_ios" ;
    private static final String KEY_VERSION_ANDROID_APP = "version_android";
    private static final String KEY_CAMBIO_CONDICIONES_APP = "cambio_condiciones";
    private static final String KEY_GAMIFICACION = "gamificacion";
    private static final String KEY_RESTRICCIONES ="restricciones" ;
    private static final String KEY_TOKEN = "token";
    private static final String KEY_RESULTADO = "resultado";

    private static final int DATABASE_VERSION = 1;

    public DatabaseHandler(Context context) {
        super(context, TABLE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //este metodo es el que se ejecuta cuando no hay bbdd creada y se encarga de crear el
        //archivo .db en una carpeta de la aplicacion
        String CREATE_TABLE_LOCAL_INVENTARIO = "CREATE TABLE " + TABLE_NAME +
                "(" + KEY_COD_EMPRESA + " TEXT," +
                KEY_NAME_EMPRESA +" TEXT," + KEY_CENTRO + " TEXT," + KEY_COD_MARCA + " TEXT," +
                KEY_NAME_MARCA + " TEXT," + KEY_USUARIO + " TEXT," + KEY_NAME_USUARIO + " TEXT PRIMARY KEY," +
                KEY_TIPO_USUARIO + " TEXT," + KEY_MAIL_USUARIO + " TEXT," + KEY_MAIL_REPRESENTANTE + " TEXT," +
                KEY_TELEFONO_REPRESENTANTE + " TEXT," + KEY_URL_INICIO + " TEXT," + KEY_PERFIL_USUARIO + " TEXT," +
                KEY_VERSION_IOS_APP + " TEXT," + KEY_VERSION_ANDROID_APP + " TEXT," + KEY_CAMBIO_CONDICIONES_APP + " TEXT," +
                KEY_GAMIFICACION + " TEXT," + KEY_RESTRICCIONES + " TEXT," + KEY_TOKEN + " TEXT," + KEY_RESULTADO + " TEXT" + ")";

        db.execSQL(CREATE_TABLE_LOCAL_INVENTARIO);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    //se utiliza para cuando cambiamos la versiond e bbbdd para reciclar la que teniamos y
        //poner una nueva,se utiliza mas que el metdo oncreate
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);

        onCreate(db);
    }

    public void addLoginResult(LoginResult loginResult)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_COD_EMPRESA,loginResult.getCodEmpresa());
        values.put(KEY_NAME_EMPRESA,loginResult.getNameEmpresa());
        values.put(KEY_CENTRO,loginResult.getCentro());
        values.put(KEY_COD_MARCA,loginResult.getCodEmpresa());
        values.put(KEY_NAME_MARCA,loginResult.getNameMarca());
        values.put(KEY_USUARIO,loginResult.getUsuario());
        values.put(KEY_NAME_USUARIO,loginResult.getNameUsuario());
        values.put(KEY_TIPO_USUARIO,loginResult.getTipoUsuario());
        values.put(KEY_MAIL_USUARIO,loginResult.getMailUsuario());
        values.put(KEY_MAIL_REPRESENTANTE,loginResult.getMailRepresentante());
        values.put(KEY_TELEFONO_REPRESENTANTE,loginResult.getTelefonoRepresentante());
        values.put(KEY_URL_INICIO,loginResult.getUrlInicio());
        values.put(KEY_VERSION_IOS_APP,loginResult.getVersionIosAPP());
        values.put(KEY_VERSION_ANDROID_APP,loginResult.getVersionAndroidAPP());
        values.put(KEY_CAMBIO_CONDICIONES_APP,loginResult.getCambioCondicionesAPP());
        values.put(KEY_GAMIFICACION,loginResult.getGamificacion());
        values.put(KEY_RESTRICCIONES,stringArrayList(loginResult.getRestricciones()));
        values.put(KEY_TOKEN,loginResult.getToken());
        values.put(KEY_RESULTADO,loginResult.getResultado());
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+KEY_NAME_USUARIO+" = ?", new String[]{loginResult.getNameUsuario()});
        if(cursor.getCount() == 0)
        {
            db.insert(TABLE_NAME,null,values);
        }
        else
        {
            db.update(TABLE_NAME,values,KEY_NAME_USUARIO + " = ?",new String[] {loginResult.getNameUsuario()});
        }
        cursor.close();
        db.close();
    }

    private String stringArrayList(List<Restriccione> arrayList)
    {
        Gson gson = new Gson();
        String json = gson.toJson(arrayList);
        return json;
    }

    public LoginResult getLoginResult(String id)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[] {KEY_COD_EMPRESA,KEY_NAME_EMPRESA,KEY_CENTRO,KEY_COD_MARCA,
                KEY_NAME_MARCA,KEY_USUARIO,KEY_NAME_USUARIO,KEY_TIPO_USUARIO,KEY_MAIL_USUARIO,KEY_MAIL_REPRESENTANTE,
                KEY_TELEFONO_REPRESENTANTE,KEY_URL_INICIO,KEY_VERSION_IOS_APP,KEY_VERSION_ANDROID_APP,KEY_RESTRICCIONES,
                KEY_CAMBIO_CONDICIONES_APP,KEY_GAMIFICACION,KEY_TOKEN,KEY_RESULTADO}, KEY_NAME_USUARIO + "=?",new String[] {id},null,null,null);

        if(cursor != null)
        {
            cursor.moveToFirst();
            String codEmpresa = cursor.getString(cursor.getColumnIndex(KEY_COD_EMPRESA));
            String nameEmpresa = cursor.getString(cursor.getColumnIndex(KEY_NAME_EMPRESA));
            String centro = cursor.getString(cursor.getColumnIndex(KEY_CENTRO));
            String codmarca = cursor.getString(cursor.getColumnIndex(KEY_COD_MARCA));
            String keynamemarca = cursor.getString(cursor.getColumnIndex(KEY_NAME_MARCA));
            String usuario = cursor.getString(cursor.getColumnIndex(KEY_USUARIO));
            String nameusuario = cursor.getString(cursor.getColumnIndex(KEY_NAME_USUARIO));
            String keyTipoUsuario = cursor.getString(cursor.getColumnIndex(KEY_TIPO_USUARIO));
            String keyMailUsuario = cursor.getString(cursor.getColumnIndex(KEY_MAIL_USUARIO));
            String keyMailRepresentante = cursor.getString(cursor.getColumnIndex(KEY_MAIL_REPRESENTANTE));
            String keyTelefonoRepresentante = cursor.getString(cursor.getColumnIndex(KEY_TELEFONO_REPRESENTANTE));
            String keyUrlInicio = cursor.getString(cursor.getColumnIndex(KEY_URL_INICIO));
            String keyVersionIos = cursor.getString(cursor.getColumnIndex(KEY_VERSION_IOS_APP));
            String keyVersionAndroid = cursor.getString(cursor.getColumnIndex(KEY_VERSION_ANDROID_APP));
            String keyCambioCondicionesApp = cursor.getString(cursor.getColumnIndex(KEY_CAMBIO_CONDICIONES_APP));
            String keyGamificacion = cursor.getString(cursor.getColumnIndex(KEY_GAMIFICACION));
            String keyToken = cursor.getString(cursor.getColumnIndex(KEY_TOKEN));
            String keyResultado = cursor.getString(cursor.getColumnIndex(KEY_RESULTADO));
            List<Restriccione> restricciones = getListRestricciones(cursor.getString(cursor.getColumnIndex(KEY_RESTRICCIONES)));


            LoginResult loginResult = new LoginResult(codEmpresa,nameEmpresa,centro,codmarca,keynamemarca,usuario,nameusuario,keyTipoUsuario,
                    keyMailUsuario,keyMailRepresentante,keyTelefonoRepresentante,keyUrlInicio,keyVersionIos,keyVersionAndroid,keyCambioCondicionesApp,
                    keyGamificacion,keyToken,keyResultado,restricciones);
            return loginResult;
        }
        return null;
    }

    private List<Restriccione> getListRestricciones(String textRestricciones)
    {
       Gson gson = new Gson();
        ArrayList<Restriccione> recuperado = gson.fromJson(textRestricciones,ArrayList.class);
        return recuperado;
    }



}
