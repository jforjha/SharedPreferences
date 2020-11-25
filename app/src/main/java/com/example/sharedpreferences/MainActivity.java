package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button ;
    TextView textView;
    EditText editText ;
    //Button button = findViewById(R.id.button);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         button = findViewById(R.id.button);
        textView = findViewById(R.id.text);
        editText = findViewById(R.id.editTextText);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                String msg = editText.getText().toString();
                SharedPreferences shrd =getSharedPreferences("demo",MODE_PRIVATE);
                SharedPreferences.Editor editor = shrd.edit();
                editor.putString("str",msg);
                editor.apply();
                textView.setText(msg);
            }
        });
        //Get the value of shared preference back
        SharedPreferences getShared = getSharedPreferences("demo",MODE_PRIVATE);
       String value= getShared.getString("str","Save a note and it will show here");
       textView.setText(value);

    }
}