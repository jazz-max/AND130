package com.example.and_130;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static HashMap<String, Persone> persons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Init();
    }

    private void Init(){
        persons = new HashMap<>();

        Button btnSave = findViewById(R.id.buttonSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editFio =findViewById(R.id.editFio);
                EditText editAge =findViewById(R.id.editAge);

                try {
                    int age = Integer.parseInt(editAge.getText().toString());
                    String  fio = editFio.getText().toString();
                    Persone persone = new Persone(age,fio);
                    persons.put(fio,persone);

                    Toast.makeText(MainActivity.this,
                                getString(R.string.has_data) + persone.toString(),
                                    Toast.LENGTH_LONG).show();

                } catch (Exception e){
                    Toast.makeText(MainActivity.this, getString(R.string.error_str) + e.getMessage(),Toast.LENGTH_LONG).show();
                    Log.d(TAG, e.toString());
                } finally {
                    Log.i(TAG,"нажата кнопка "+getString(R.string.save));
                }
            }
        });
        Button buttonPressure = findViewById(R.id.buttonPressure);
        buttonPressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"нажата кнопка "+getString(R.string.preasure));
                Intent intent = new Intent(MainActivity.this, PressureActivity.class);
                startActivity(intent);
            }
        });

        Button buttonVitalStat = findViewById(R.id.buttonVitalStat);
        buttonVitalStat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"нажата кнопка "+getString(R.string.vital_statistic));
                Intent intent = new Intent(MainActivity.this, VitalStatisticActivity.class);
                startActivity(intent);
            }
        });

    }
}
