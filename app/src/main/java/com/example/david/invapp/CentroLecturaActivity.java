package com.example.david.invapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class CentroLecturaActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioButton ubicacion, articulo;
    private Button button;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centro_lectura);
        radioGroup = (RadioGroup) findViewById(R.id.newRadioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // find which radio button is selected
                if (checkedId == R.id.ubicacion) {
                    Toast.makeText(getApplicationContext(), "choice: Silent",
                            Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(getApplicationContext(), "choice: Sound",
                            Toast.LENGTH_SHORT).show();
                }
            }

        });

        ubicacion = (RadioButton) findViewById(R.id.ubicacion);
        articulo = (RadioButton) findViewById(R.id.articulo);

        textView = (TextView) findViewById(R.id.text);

        button = (Button) findViewById(R.id.chooseBtn);
        button.setOnClickListener(new View.OnClickListener() {
            // button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int selectedId = radioGroup.getCheckedRadioButtonId();

                // find which radioButton is checked by id
                if (selectedId == ubicacion.getId()) {
                    textView.setText("You chose 'Sound' option");

                } else {
                    textView.setText("You chose 'Silent' option");
                }

            }

        });
    }
}
