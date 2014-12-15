package com.homeassignment.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Bon on 12/6/2014.
 */
public class CustomAdapter extends BaseAdapter {

    public SongManager manager;
    private Context context;

    private static CustomAdapter instance = null;


    public CustomAdapter(Context context,SongManager manager) {
        if(instance==null) {

            this.context = context;
            this.manager = manager;

        }

    }


    @Override
    public int getCount() {
        return manager.songsList.size();
    }

    @Override
    public Song getItem(int position) {
        return  manager.songsList.get(position);

    }

    @Override
    public long getItemId(int position) {
        return  manager.songsList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //the two text fields from the custom list row
        TextView songName;
        TextView songArtist;

        if (convertView == null) {
            //get the custom row and set tags to the view
            convertView = LayoutInflater.from(context).inflate(R.layout.catalog_row, parent, false);
            songName = (TextView) convertView.findViewById(R.id.lbSongName);
            songArtist = (TextView) convertView.findViewById(R.id.lbArtist);
            convertView.setTag(R.id.lbSongName, songName);
            convertView.setTag(R.id.lbArtist, songArtist);

        } else {
            songName = (TextView) convertView.getTag(R.id.lbSongName);
            songArtist = (TextView) convertView.getTag(R.id.lbArtist);
        }

        //set the text the text fields by the current position
        songName.setText("" + getItem(position).getName());
        songArtist.setText(""+getItem(position).getArtist());
        return convertView;
    }



}
