package com.example.user.maddiscovery;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends Activity {
    EditText userText, passText, emailText, LocationText, PhoneText;
    DBHelper dbHelper = new DBHelper(this);
    Button btnsubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        userText = (EditText) findViewById(R.id.txtuser);
        passText = (EditText) findViewById(R.id.txtpass);
        emailText = (EditText) findViewById(R.id.txtemail);
        LocationText = (EditText) findViewById(R.id.txtlocation);
        PhoneText = (EditText) findViewById(R.id.txtphone);
        btnsubmit = (Button) findViewById(R.id.btnsubmit);


    }


    public void btn_submit(View view) {
        String uname = userText.getText().toString();
        String pass = passText.getText().toString();
        String email = emailText.getText().toString();
        String location = LocationText.getText().toString();
        String phone = PhoneText.getText().toString();


        if (uname.length() == 0 || email.length() == 0 || email.length() == 0 || location.length() == 0 ||
                pass.length() == 0 || phone.length() == 0) {

            Toast.makeText(SignUp.this, "Fill in all fields", Toast.LENGTH_SHORT).show();
        } else {

            Contact c = new Contact();
            c.setUname(uname);
            c.setMail(email);
            c.setMobilephone(phone);
            c.setLocation(location);
            c.setPassword(pass);

            dbHelper.insert_event(c);

            Intent intent = new Intent(SignUp.this, Login.class);
            startActivity(intent);


        }
    }
}




