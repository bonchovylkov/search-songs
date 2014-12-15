package com.homeassignment.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class AddNewSong extends Activity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_song);

        //set the listener
        Button addTheSong = (Button)findViewById(R.id.btnAddTheSong);
        addTheSong.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_new_song, menu);
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
        switch (v.getId()){
            case R.id.btnAddTheSong:
                //add the song add show the list
                TextView name = (TextView)findViewById(R.id.tbxNewSongName);
                TextView artist = (TextView)findViewById(R.id.tbxNewSongArtist);
                TextView description = (TextView)findViewById(R.id.tbxNewSongDescription);
                if(name.getText().toString().equals("") || artist.getText().toString().equals("")
                        || description.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(),"The name,artist and description are mandatory" , Toast.LENGTH_SHORT).show();
                }else{

                    SongManager manager = new SongManager().getInstance();
                    manager.addNewSong(name.getText().toString(),artist.getText().toString(),description.getText().toString());
                    Toast.makeText(getApplicationContext(),"New song added " + name.getText().toString() , Toast.LENGTH_SHORT).show();
                    Intent intentPlayListBrowse = new Intent(this, PlayListBrowse.class);
                    startActivity(intentPlayListBrowse);

                }

                break;
        }
    }
}
