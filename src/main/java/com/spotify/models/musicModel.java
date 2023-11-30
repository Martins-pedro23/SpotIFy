package com.spotify.models;

import com.spotify.interfaces.IMusic;
public class MusicModel extends IMusic {
    private int id;
    private String name;
    private int listenerCount;
    private int albumId;
    private int duration;
    private int artistId;

    public MusicModel( String name, int listenerCount, int albumId, int duration, int artistId) {
        this.name = name;
        this.listenerCount = listenerCount;
        this.albumId = albumId;
        this.duration = duration;
        this.artistId = artistId;
    }

    public MusicModel() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getListenerCount() {
        return listenerCount;
    }

    public int getAlbumId() {
        return albumId;
    }

    public int getDuration() {
        return duration;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setListenerCount(int listenerCount) {
        this.listenerCount = listenerCount;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
