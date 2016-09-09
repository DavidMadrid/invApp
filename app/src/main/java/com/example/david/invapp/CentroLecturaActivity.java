package com.example.david.invapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class CentroLecturaActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centro_lectura);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        SharedPreferences preferences = getSharedPreferences("config", MODE_PRIVATE);
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.rbUbicacion:
                if (checked)
                    preferences.edit().putString("TipoLectura", "ubicacion").commit();
                break;
            case R.id.rbArticulo:
                if (checked)
                    preferences.edit().putString("TipoLectura", "articulo").commit();
                break;
        }
    }
}