package com.example.david.invapp;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.app.Activity;

import com.example.david.invapp.pojos.Delegacione;

import java.util.ArrayList;
import java.util.List;


public class CentrosActivity extends AppCompatActivity {
    //private RadioGroup radioGroup;
    //private RadioButton sound, vibration;
    private Button button;
    private TextView textView;

    private ServerConnect serverConnect;

    private RecyclerView listaCentros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centros);
        serverConnect = new ServerConnect();
        List<Delegacione>delegaciones= new ArrayList<>();
        listaCentros = (RecyclerView) findViewById(R.id.recyclerView);
        listaCentros.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        CentroAdapter adaptador = new CentroAdapter(delegaciones);
        listaCentros.setAdapter(adaptador);
        serverConnect.descargarCentro(listaCentros,"","","","");
      //  radioGroup = (RadioGroup) findViewById(R.id.myRadioGroup);

       /* radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // find which radio button is selected
                if (checkedId == R.id.silent) {
                    Toast.makeText(getApplicationContext(), "choice: Silent",
                            Toast.LENGTH_SHORT).show();
                } else if (checkedId == R.id.sound) {
                    Toast.makeText(getApplicationContext(), "choice: Sound",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "choice: Vibration",
                            Toast.LENGTH_SHORT).show();
                }
            }

        });

        sound = (RadioButton) findViewById(R.id.sound);
        vibration = (RadioButton) findViewById(R.id.vibration);

        textView = (TextView) findViewById(R.id.text);

        button = (Button) findViewById(R.id.chooseBtn);
        button.setOnClickListener(new OnClickListener() {
            // button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int selectedId = radioGroup.getCheckedRadioButtonId();

                // find which radioButton is checked by id
                if (selectedId == sound.getId()) {
                    textView.setText("You chose 'Sound' option");
                } else if (selectedId == vibration.getId()) {
                    textView.setText("You chose 'Vibration' option");
                } else {
                    textView.setText("You chose 'Silent' option");
                }
                ServerConnectCentros miserver = new ServerConnectCentros();
                miserver.seleccionarCentro(centro,delegacion,delegacionCodigo,delegacionNombre);
            }

        });*/
    }
}
