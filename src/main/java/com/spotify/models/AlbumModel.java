package com.spotify.models;

import com.spotify.interfaces.IAlbum;

public class AlbumModel extends IAlbum {
    int id;
    String name;
    int artistId;
    int year;
    String songs;
    int listener_count;

    public AlbumModel(String name, int artistId, int year, String songs, int listener_count) {
        this.name = name;
        this.artistId = artistId;
        this.year = year;
        this.songs = songs;
        this.listener_count = listener_count;
    }

    public AlbumModel(int id, String name, int artistId, int year, String songs, int listener_count) {
        this.id = id;
        this.name = name;
        this.artistId = artistId;
        this.year = year;
        this.songs = songs;
        this.listener_count = listener_count;
    }

    public AlbumModel() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getArtistId() {
        return artistId;
    }

    public int getYear() {
        return year;
    }

    public String getSongs() {
        return songs;
    }

    public int getListener_count() {
        return listener_count;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setSongs(String songs) {
        this.songs = songs;
    }

    public void setListener_count(int listener_count) {
        this.listener_count = listener_count;
    }

    public void setName(String name) {
        this.name = name;
    }

}
