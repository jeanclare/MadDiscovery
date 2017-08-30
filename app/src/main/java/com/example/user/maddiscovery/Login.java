package com.example.user.maddiscovery;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Login extends Activity implements View.OnClickListener {

    EditText uNameText, pNameText;
    Button btnlogin, btnsignup, btnlogout;
    DBHelper dbHelper = new DBHelper(this);
SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        uNameText = (EditText) findViewById(R.id.txtuser);
        pNameText = (EditText) findViewById(R.id.txtpass);
        btnsignup = (Button) findViewById(R.id.btnsignup);
        btnlogout = (Button) findViewById(R.id.btnlogout);

        btnsignup.setOnClickListener(this);
        btnlogout.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnsignup:
                startActivity(new Intent(this, SignUp.class));
                break;

            case R.id.btnlogout:

                break;
        }
    }

    public void btn_login(View view) {
        String username,password;
        username = uNameText.getText().toString().trim();
        password = pNameText.getText().toString().trim();

        String passwd = dbHelper.searchpassword(username);

        if (username.length() == 0 || password.length() == 0){
            Toast.makeText(getApplicationContext(),"Fill in all fields",Toast.LENGTH_LONG).show();
        }else if (password.equals(passwd)){
            Intent intent = new Intent(Login.this,Upload.class);
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(),"You have Enterd The Wrong Username or Password!",Toast.LENGTH_LONG).show();
        }
    }
}