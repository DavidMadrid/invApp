package com.example.david.invapp.modeloDAO;

import android.content.Context;

/**
 * Created by david on 28/08/2016.
 */
public class DBSingleton {

    public DatabaseHandler getDbHandler() {
        return dbHandler;
    }

    private DatabaseHandler dbHandler;

    private DBSingleton(Context context)
    {
        dbHandler = new DatabaseHandler(context);
    }

    private static DBSingleton instance;

    public static DBSingleton getInstance(Context context)
    {
        if(instance == null)
        {
            instance = new DBSingleton(context);
        }
        return instance;
    }




}
