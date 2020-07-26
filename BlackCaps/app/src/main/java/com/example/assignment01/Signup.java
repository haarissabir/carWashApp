package com.example.assignment01;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigInteger;

public class Signup extends AppCompatActivity {
    TextView textView;
    DatabaseHelper db;
    EditText num,pass,name;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        num = findViewById(R.id.txtPhone);
        pass = findViewById(R.id.txtPassword) ;
        name = findViewById(R.id.txtName);
        textView = findViewById(R.id.textView5);
        submit = findViewById(R.id.btnSubmit);
        db = new DatabaseHelper(this);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignin();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(pass.getText()) || TextUtils.isEmpty(num.getText()) || TextUtils.isEmpty(name.getText()))
                {
                    if(TextUtils.isEmpty(pass.getText())){
                        pass.setError("Error");
                    }
                    else{
                       // pass.setBackgroundColor(Color.WHITE);
                    }
                    if(TextUtils.isEmpty(num.getText())){
                        num.setError("Error");
                    }
                    else{
                       // num.setBackgroundColor(Color.WHITE);
                    }
                    if(TextUtils.isEmpty(name.getText())){
                        name.setError("Error");
                    }
                    else{
                       // name.setBackgroundColor(Color.WHITE);
                    }
                    Toast.makeText(getApplicationContext(), "Please Fill all the fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    BigInteger n = new BigInteger(num.getText().toString());
                    String p = pass.getText().toString();
                    String na = name.getText().toString();
                    if(db.chkemail(n) == true)
                    {
                        Boolean insert = db.insert(n,na,p);
                        if(insert==true)
                        {
                            Toast.makeText(getApplicationContext(), "Registeration Complete", Toast.LENGTH_SHORT).show();
                            Intent in = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(in);
                        }
                    }
                    else{

                        Toast.makeText(getApplicationContext(), "Registeration Failed! This number already exists ", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
    }
    public void openSignin(){

        Intent in = new Intent(this, MainActivity.class);
        startActivity(in);
    }
}
