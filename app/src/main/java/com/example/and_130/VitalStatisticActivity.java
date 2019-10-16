package com.example.and_130;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.HashMap;

public class VitalStatisticActivity extends AppCompatActivity {
    private static HashMap<String, VitalStatistic> measures;
    private static final String TAG = "PressureActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vital_statistic);
        Init();
    }

    private void Init() {
        measures = new HashMap<>();

        Button btnSave = findViewById(R.id.buttonSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editWeigh =findViewById(R.id.editWeight);
                EditText editSteps =findViewById(R.id.editSteps);
                EditText editDateOfMeasure =findViewById(R.id.editDateOfMeasurement);

                try {
                    double weight = Double.parseDouble(editWeigh.getText().toString());
                    int steps = Integer.parseInt(editSteps.getText().toString());
                    String  dateOfMeasurement = editDateOfMeasure.getText().toString();

                    VitalStatistic statistic = new VitalStatistic(weight,steps,dateOfMeasurement);
                    measures.put(dateOfMeasurement,statistic);

                    Toast.makeText(VitalStatisticActivity.this,
                            getString(R.string.has_data) + statistic.toString(),
                            Toast.LENGTH_LONG).show();

                } catch (Exception e){
                    Toast.makeText(VitalStatisticActivity.this, getString(R.string.error_str) + e.getMessage(),Toast.LENGTH_LONG).show();
                    Log.d(TAG, e.toString());
                } finally {
                    Log.i(TAG,"нажата кнопка "+getString(R.string.save));
                }
            }
        });
    }
}
