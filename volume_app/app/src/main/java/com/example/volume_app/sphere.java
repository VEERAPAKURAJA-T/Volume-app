package com.example.volume_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class sphere extends AppCompatActivity {
    TextView textView2,textView3;
    EditText editTextTextPersonName;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sphere);
        textView2=findViewById(R.id.textView2);
        textView3=findViewById(R.id.textView3);
        editTextTextPersonName=findViewById(R.id.editTextTextPersonName);
        button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String u=editTextTextPersonName.getText().toString();
                int r=Integer.parseInt(u);
                double volume=(4/3)*3.14159*r*r*r;
                textView3.setText("v ="+volume+"m^3");
            }
        });
        /*
        Like this we have to create the separate activity for the remaining shapes.
         */

    }
}