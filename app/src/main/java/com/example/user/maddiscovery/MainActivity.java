package com.example.user.maddiscovery;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()) {
            case R.id.myprofile:
                Bundle profile = new Bundle();
                profile.putInt("id", 0);
                Intent prof = new Intent(getApplicationContext(), ContactsContract.Profile.class);
                prof.putExtras(profile);
                startActivity(prof);
                finish();
                return true;



            case R.id.createevent:
                Bundle eventcreated = new Bundle();
                eventcreated.putInt("id", 0);
                Intent eve = new Intent(getApplicationContext(), Event_details.class);
                eve.putExtras(eventcreated);
                startActivity(eve);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
