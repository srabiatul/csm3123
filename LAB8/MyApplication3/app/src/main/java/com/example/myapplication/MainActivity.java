package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    EditText ed1, ed2;

    Button save, login;

    public static final String myPref = "myPref";
    public static final String nameKey = "namekey";
    public static final String passwordKey = "passwordkey";

    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = findViewById(R.id.editText1);
        ed2 = findViewById(R.id.editText2);

        save = findViewById(R.id.button1);
        login = findViewById(R.id.button2);

        sp = getSharedPreferences(myPref, Context.MODE_PRIVATE);

        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String name = ed1.getText().toString();
                String password = ed2.getText().toString();

                SharedPreferences.Editor editor = sp.edit();
                editor.putString(nameKey, name);
                editor.putString(passwordKey, password);
                editor.apply();

                Toast.makeText(MainActivity.this, "Data saved to SharedPreferences", Toast.LENGTH_LONG).show();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (sp.contains(nameKey) && sp.contains(passwordKey)) {

                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "Login failed. Please save data first.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}