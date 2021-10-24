package com.example.appmaps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText latitud;
    EditText longitud;
    Button ingmapa;
    String nzoom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        latitud = (EditText) findViewById(R.id.txtlatitud);
        longitud = (EditText) findViewById(R.id.txtlongitud);
        ingmapa = (Button) findViewById(R.id.btnmap);


        NumberPicker np = findViewById(R.id.npzoom);

        np.setMinValue(1);
        np.setMaxValue(10);
        np.setOnValueChangedListener(onValueChangeListener);

        ingmapa.setOnClickListener((view) -> {

            if (latitud.getText() != null && longitud.getText() != null && nzoom != null) {
                Intent i = new Intent(MainActivity.this, MapsActivity.class);
                i.putExtra("lati", latitud.getText().toString());
                i.putExtra("longi", longitud.getText().toString());
                i.putExtra("zoom", nzoom);

                startActivity(i);
            } else {

                Toast.makeText(MainActivity.this, "Debe llenar todos los campos requerido", Toast.LENGTH_SHORT).show();
            }

        });
    }

    NumberPicker.OnValueChangeListener onValueChangeListener = new NumberPicker.OnValueChangeListener() {
        @Override
        public void onValueChange(NumberPicker numberPicker, int i, int i1) {
            nzoom = String.valueOf(numberPicker.getValue());
            Toast.makeText(MainActivity.this, "Seleccione el zoom" + numberPicker.getValue(), Toast.LENGTH_SHORT).show();
        }
    };


}