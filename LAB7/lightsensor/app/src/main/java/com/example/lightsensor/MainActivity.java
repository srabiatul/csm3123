package com.example.lightsensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.Toast;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
SensorManager senseMan;

Sensor lightSensor;
TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(TextView) findViewById(R.id.textview);
        senseMan=(SensorManager) getSystemService(SENSOR_SERVICE);
        lightSensor=senseMan.getDefaultSensor(Sensor.TYPE_LIGHT);

        if (lightSensor != null) {
            senseMan.registerListener(this,lightSensor,SensorManager.SENSOR_DELAY_NORMAL);
            Toast.makeText(this, "Light sensor found", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Light sensor not found", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        textView.setText(Float.toString(event.values[0]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onPause() {
        super.onPause();
        senseMan.unregisterListener(this);    }

    @Override
    protected void onResume() {
        super.onResume();
        senseMan.registerListener(this,lightSensor,SensorManager.SENSOR_DELAY_NORMAL);

    }
}