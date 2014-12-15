package com.homeassignment.myapplication;

import java.io.Serializable;

/**
 * Created by Bon on 12/6/2014.
 */
public class Song implements Serializable {
    private int id;
    private String name;
    private String artist;
    private String description;


    public Song(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Song(int id, String name, String artist) {
      this(id,name);
        this.artist = artist;
    }

    public Song(int id, String name, String artist, String description) {
       this(id,name,artist);
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
