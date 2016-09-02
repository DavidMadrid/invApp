package com.example.david.invapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MenuConfigActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_config);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.itAcercaDe) {
            Toast toast1 =
                    Toast.makeText(getApplicationContext(),
                            "Acerca de", Toast.LENGTH_SHORT);
            Intent intencion = new Intent(MenuConfigActivity.this,AcercaDeActivity.class);
            startActivity(intencion);

            toast1.show();
            return true;
        }
        if (id == R.id.itSalir) {

           int p= android.os.Process.myPid();
            android.os.Process.killProcess(p);


            return true;
        }
        if (id == R.id.itCentro) {
            Toast toast1 =
                    Toast.makeText(getApplicationContext(),
                            "Centro", Toast.LENGTH_SHORT);
            Intent intencion = new Intent(MenuConfigActivity.this,CentrosActivity.class);
            startActivity(intencion);

            toast1.show();
            return true;
        }
        if (id == R.id.itTipoLectura) {
            Toast toast1 =
                    Toast.makeText(getApplicationContext(),
                            "tipo lectura", Toast.LENGTH_SHORT);
            Intent intencion = new Intent(MenuConfigActivity.this,CentroLecturaActivity.class);
            startActivity(intencion);

            toast1.show();
            return true;
        }
        if (id == R.id.itCargarCodigos) {
            Toast toast1 =
                    Toast.makeText(getApplicationContext(),
                            "cargar codigos", Toast.LENGTH_SHORT);
            Intent intencion = new Intent(MenuConfigActivity.this,CodigoBarrasActivity.class);
            startActivity(intencion);

            toast1.show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}


