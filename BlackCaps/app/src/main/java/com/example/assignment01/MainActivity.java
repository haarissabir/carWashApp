package com.example.assignment01;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.math.BigInteger;

public class MainActivity extends AppCompatActivity
{
    public static BigInteger id1;
    EditText number ;
    EditText password ;
    BroadcastReciever broadcastReciever = new
            BroadcastReciever();
    DatabaseHelper db;
    Button signup;
    Button home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //linking
        number = findViewById(R.id.number);
        password = findViewById(R.id.password);
        home = (Button) findViewById(R.id.btnSave);
        signup = (Button) findViewById(R.id.signup);
        db = new DatabaseHelper(this);
        //listeners
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignup();
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(number.getText()) || password.getText().equals(""))
                {
                    Toast.makeText(MainActivity.this, "Please Enter your Credentials", Toast.LENGTH_SHORT).show();
                }
                else {

                    openHome();
                }
            }
        });



    }
    public void openSignup(){
        Intent in = new Intent(this, Signup.class);
        startActivity(in);

    }
    public void openHome(){
        BigInteger num = new BigInteger(number.getText().toString());
        String pass = password.getText().toString();
        Boolean login = db.login(num,pass);
        if(login == true) {
            id1 = num;
            Intent in2 = new Intent(this, nav_act.class);
            startActivity(in2);
        }
        else
        {
            Toast.makeText(this, "Wrong number or password!", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(broadcastReciever,filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadcastReciever);
    }
}
