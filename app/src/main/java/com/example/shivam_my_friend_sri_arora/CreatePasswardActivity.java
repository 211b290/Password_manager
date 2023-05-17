package com.example.shivam_my_friend_sri_arora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreatePasswardActivity extends AppCompatActivity {

    EditText editText1, editText2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_passward);

        editText1 = findViewById(R.id.editTextTextPassword1);
        editText2 = findViewById(R.id.editTextTextPassword2);
        button = findViewById(R.id.button);

        button.setOnClickListener(v -> {
            String text1 = editText1.getText().toString();
            String text2 = editText2.getText().toString();


            if(text1.equals("") || text2.equals("")){
                //there s no password
                Toast.makeText(CreatePasswardActivity.this,"No password entered!", Toast.LENGTH_SHORT).show();
            } else {
                if(text1.equals(text2)){
                    //save the password
                    SharedPreferences settings = getSharedPreferences("PREFS", 0);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putString("password",text1);
                    editor.apply();
                    // enter the app
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    //there is no match on
                    Toast.makeText(CreatePasswardActivity.this, "Passwords doesn't match!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}