package com.example.konversisuhu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public EditText inputCelcius, outputKelvin, outputFarenheit, outputReamur;
    public Button btnKonversi,btnClear;
    protected double xinputCelcius;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputCelcius = (EditText) findViewById(R.id.inputCelcius);
        outputFarenheit = (EditText) findViewById(R.id.outputFarenheit);
        outputKelvin = (EditText) findViewById(R.id.outputKelvin);
        outputReamur = (EditText) findViewById(R.id.outputReamur);
        btnKonversi = (Button) findViewById(R.id.btnKonversi);
        btnKonversi.setOnClickListener(this);
        btnClear = (Button) findViewById(R.id.clear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataEmpty();
            }
        });

    }


    @Override
    public void onClick(View view){
        


        switch (view.getId()){
            case R.id.btnKonversi:
            xinputCelcius = Double.parseDouble(inputCelcius.getText().toString());

            double kelvin = xinputCelcius + 273.15;
            outputKelvin.setText(String.valueOf(kelvin));

            double farenheit = (xinputCelcius * 1.8) + 32;
            outputFarenheit.setText(String.valueOf(farenheit));

            double reamur = 0.8*xinputCelcius;
            outputReamur.setText(String.valueOf(reamur));
            break;

            case R.id.clear:
                inputCelcius.getText().clear();
                outputKelvin.getText().clear();
                outputFarenheit.getText().clear();
                outputReamur.getText().clear();
                break;
        }

    }
        String suhu; EditText celcius;
    public void dataEmpty() {

        celcius = (EditText) findViewById(R.id.inputCelcius);
        suhu = celcius.getText().toString();

        if (suhu.isEmpty()) {
            inputCelcius.setError("Isi suhu terlebih dahulu!");
            inputCelcius.requestFocus();
        }
    }


}

