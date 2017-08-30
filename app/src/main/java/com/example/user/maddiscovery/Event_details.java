package com.example.user.maddiscovery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Event_details extends Activity implements View.OnClickListener{

    EditText nameText,locationText,dateText,timeText,organizerText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);


        nameText = (EditText) findViewById(R.id.txtevname);
        locationText = (EditText) findViewById(R.id.txtevloc);
        dateText = (EditText) findViewById(R.id.txtdate);
        timeText = (EditText) findViewById(R.id.txttime);
        organizerText = (EditText) findViewById(R.id.txtlocation );

       // btnCreate.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCreate:
                startActivity(new Intent(this, Event_details.class));
                break;
        }
    }


    public void btn_save(View view) {
        Intent intent = new Intent(Event_details.this, Display.class);
        startActivity(intent);


    }
}



