package com.example.gabriella.gabriellaapriliana_1202150272_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {

    private EditText user;
    private EditText pwd;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user = (EditText) findViewById(R.id.user);
        pwd = (EditText) findViewById(R.id.pwd);
        login = (Button) findViewById(R.id.login);
    }
    public void onClick(View view) {
        if (user.getText().toString().equals("EAD")&& pwd.getText().toString().equals("MOBILE") ) {
            Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show();
            Intent intentlogin = new Intent(this, MainActivity.class);
            startActivity(intentlogin);
        } else {
            Toast.makeText(this,"Login Gagal", Toast.LENGTH_SHORT).show();
        }
    }
}


