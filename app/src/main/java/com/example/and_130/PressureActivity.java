package com.example.and_130;

import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.HashMap;

public class PressureActivity extends AppCompatActivity {

    private static HashMap<String, HeartStatistic> measures;
    private static final String TAG = "PressureActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);
        Init();
    }

    private void Init() {
        measures = new HashMap<>();

        Button btnSave = findViewById(R.id.buttonSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editHP =findViewById(R.id.editHP);
                EditText editLP =findViewById(R.id.editLP);
                EditText editPulse =findViewById(R.id.editPulse);
                EditText editDateOfMeasure =findViewById(R.id.editDateOfMeasurement);
                CheckBox chbTachycardia =findViewById(R.id.checkBoxTachycardia);

                try {
                    int hp = Integer.parseInt(editHP.getText().toString());
                    int lp = Integer.parseInt(editLP.getText().toString());
                    int pulse = Integer.parseInt(editPulse.getText().toString());
                    String  dateOfMeasurement = editDateOfMeasure.getText().toString();
                    boolean tachycardia = chbTachycardia.isChecked();

                    HeartStatistic statistic = new HeartStatistic(hp,lp,pulse,tachycardia,dateOfMeasurement);
                    measures.put(dateOfMeasurement,statistic);

                    Toast.makeText(PressureActivity.this,
                            getString(R.string.has_data) + statistic.toString(),
                            Toast.LENGTH_LONG).show();

                } catch (Exception e){
                    Toast.makeText(PressureActivity.this, getString(R.string.error_str) + e.getMessage(),Toast.LENGTH_LONG).show();
                    Log.d(TAG, e.toString());
                } finally {
                    Log.i(TAG,"нажата кнопка "+getString(R.string.save));
                }
            }
        });
    }
}
