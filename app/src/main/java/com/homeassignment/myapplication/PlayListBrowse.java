package com.homeassignment.myapplication;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;
import java.io.Serializable;


public class PlayListBrowse extends Activity implements AdapterView.OnItemClickListener {

    SongManager songManager;
    ListView listSongs;
    CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_list_browse);
        listSongs = (ListView) findViewById(R.id.listSongs);
        songManager = new SongManager().getInstance();

        Intent intent = getIntent();
        loadListViewData(intent);


        //Set the click listener of a row from the list view
        listSongs.setOnItemClickListener(this);

        //just for test
        listSongs.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Song number " + (position +1) +" was clicked - long", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }

    @Override
    protected void onNewIntent(Intent intent) {
        //Intent intent = getIntent();
        loadListViewData(intent);
    }

    private void loadListViewData(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            doMySearch(query);
        }
        else{

            customAdapter = new CustomAdapter(this,songManager);
            listSongs.setAdapter(customAdapter);
        }
    }

    private void doMySearch(String query) {

        Toast.makeText(getApplicationContext(), query, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_play_list_browse, menu);
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
        }else if(id==R.id.search){
            onSearchRequested();
        }

        return super.onOptionsItemSelected(item);
    }

      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
          //Loading the details activity
          Intent intentAddNewSong = new Intent(this, SongDetails.class);
          //i am able to put the "Song" type object directly becouse the class implements Serializable
          intentAddNewSong.putExtra("selectedSong",customAdapter.getItem(position));
          startActivity(intentAddNewSong);

      }
}
