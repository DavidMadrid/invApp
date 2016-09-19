package com.example.david.invapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.david.invapp.fragments.EnviarFragment;
import com.example.david.invapp.modeloDAO.DatabaseHandler;
import com.example.david.invapp.pojos.pojoEntrada.DetalleRecuento;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Digits;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import java.util.List;

/**
 * Da de alta un nuevo detalle recuento, y lo introduce en un listado para enviar luego al servidor
 */

public class AltaLineaRecuentoActivity extends AppCompatActivity {

    @NotEmpty
    EditText almacen;
    @NotEmpty
    EditText ubicacion;
    @NotEmpty
    EditText lote;
    @NotEmpty
    EditText producto;
    @NotEmpty
    EditText cantidad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_linea_recuento);
        final Validator validator = new Validator(this);

        almacen = (EditText) findViewById(R.id.edAlmacen);
        ubicacion = (EditText) findViewById(R.id.edUbicacion);
        lote = (EditText) findViewById(R.id.edLote);
        producto = (EditText) findViewById(R.id.edProducto);
        cantidad = (EditText) findViewById(R.id.edCantidad);

        if(getIntent() != null && getIntent().getExtras() != null){
            if(getIntent().hasExtra("ubicacion")) {
                ubicacion.setText(getIntent().getStringExtra("ubicacion"));
            }else if(getIntent().hasExtra("producto")) {
                producto.setText(getIntent().getStringExtra("producto"));
            }
        }

        Button ok = (Button) findViewById(R.id.bnOK);
        Button cancel = (Button) findViewById(R.id.bnCancel);

        validator.setValidationListener(new Validator.ValidationListener() {
            @Override
            public void onValidationSucceeded() {
                DetalleRecuento detalle = new DetalleRecuento();
                detalle.setAlmacen(almacen.getText().toString());
                detalle.setUbicacion(ubicacion.getText().toString());
                detalle.setLote(lote.getText().toString());
                detalle.setProducto(producto.getText().toString());
                detalle.setCantidad(cantidad.getText().toString());
                EnviarFragment.detallesEnviar.put(detalle.hashCode(), detalle);
                Toast.makeText(AltaLineaRecuentoActivity.this, "DetalleRecuento agregado correctamente", Toast.LENGTH_LONG).show();
                Intent result = new Intent();
                result.putExtra("createdHash", detalle.hashCode());
                setResult(RESULT_OK, result);
                finish();
            }

            @Override
            public void onValidationFailed(List<ValidationError> errors) {
                for (ValidationError error : errors) {
                    View view = error.getView();
                    String message = error.getCollatedErrorMessage(AltaLineaRecuentoActivity.this);

                    // Display error messages ;)
                    if (view instanceof EditText) {
                        ((EditText) view).setError(message);
                    } else {
                        Toast.makeText(AltaLineaRecuentoActivity.this, message, Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validator.validate();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
