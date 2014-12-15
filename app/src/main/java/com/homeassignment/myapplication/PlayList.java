package com.homeassignment.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class PlayList extends Activity implements View.OnClickListener {

    //global variables for the buttons
    Button btnAddNewSong;
    Button btnBrowse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_list);

        //setting buttons listeners
        btnAddNewSong = (Button) findViewById(R.id.btnAddNewSong);
        btnAddNewSong.setOnClickListener(this);
        btnBrowse = (Button) findViewById(R.id.btnBrowse);
        btnBrowse.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_play_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        //get the clicked button and start it's intent
        switch (v.getId()) {
            case R.id.btnAddNewSong:

                Intent intentAddNewSong = new Intent(this, AddNewSong.class);

                startActivity(intentAddNewSong);
                break;

            case R.id.btnBrowse:
                Intent intentPlayListBrowse = new Intent(this, PlayListBrowse.class);
                startActivity(intentPlayListBrowse);
                break;


        }
    }
}
