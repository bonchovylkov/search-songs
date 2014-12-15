package com.homeassignment.myapplication;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.Serializable;


public class SongDetails extends Activity {

    LinearLayout mainLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //creating Linear Layout programatically
        mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(mainLayout);
        //get the serializable object from the extra
        Song selectedSong = (Song)getIntent().getSerializableExtra("selectedSong");

        //create text view for the Song name
        TextView songName = new TextView(this);
        songName.setText(selectedSong.getName());
        songName.setTextSize(48);
        songName.setId(selectedSong.getId());
        songName.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        ((LinearLayout) mainLayout).addView(songName);

        //create text view for the Song artist
        TextView songArtist = new TextView(this);
        songArtist.setText("by " + selectedSong.getArtist());
        songArtist.setTextSize(20);
        songArtist.setTextColor(Color.BLUE);
        songArtist.setId(selectedSong.getId()+1);
        songArtist.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        ((LinearLayout) mainLayout).addView(songArtist);

        //create text view for the Song description
        TextView songDescription = new TextView(this);
        songDescription.setText(selectedSong.getDescription());
        songDescription.setTextSize(23);
        songDescription.setId(selectedSong.getId()+2);
        songDescription.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        ((LinearLayout) mainLayout).addView(songDescription);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_song_details, menu);
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
}
