package com.example.david.invapp;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import com.example.david.invapp.modeloDAO.DatabaseHandler;

/**
 * Created by david on 28/08/2016.
 */
public class InitApp extends Application {

    public DatabaseHandler getDbHandler() {
        return dbHandler;
    }

    private DatabaseHandler dbHandler;

    @Override
    public void onCreate()
    {
        super.onCreate();
        Log.i("InitApp","Iniciando aplicación...");
        dbHandler = new DatabaseHandler(getApplicationContext());
    }
}
