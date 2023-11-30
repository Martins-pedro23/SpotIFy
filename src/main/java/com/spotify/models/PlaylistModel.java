package com.spotify.models;

import com.spotify.interfaces.IPlaylist;

public class PlaylistModel extends IPlaylist {
    private int id;
    private String name;
    private String bio;
    private int[] songs_id;
    private int likes;
    private int user_id;

    public PlaylistModel(String name, String bio, int[] songs_id, int likes, int user_id) {
        this.setName(name); 
        this.setBio(bio);
        this.setSongs_id(songs_id);
        this.setLikes(likes);
        this.setUser_id(user_id);
    }

    public PlaylistModel(int id, String name, String bio, int[] songs_id, int likes, int user_id) {
        this.setId(id);
        this.setName(name); 
        this.setBio(bio);
        this.setSongs_id(songs_id);
        this.setLikes(likes);
        this.setUser_id(user_id);
    }

    public PlaylistModel() {
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getBio() {
        return bio;
    }

    public int[] getSongs_id() {
        return songs_id;
    }

    public int getLikes() {
        return likes;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setName(String name) {
        
        this.name = name;
    }

    public void setBio(String bio) {
        
        this.bio = bio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSongs_id(int[] songs_id) {
        this.songs_id = songs_id;
    }

    public void setLikes(int likes) {
        
        this.likes = likes;
    }

    public void setUser_id(int user_id) {
        
        this.user_id = user_id;
    }
}
