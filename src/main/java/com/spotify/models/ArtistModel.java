package com.spotify.models;

import com.spotify.interfaces.IArtist;

public class ArtistModel extends IArtist {
    private int id;
    private String name;
    private int viwe_count;
    private String bio;
    private boolean verified;
    private String[] genre;

    public ArtistModel(String name, int viwe_count, String bio, boolean verified, String[] genre) {
        this.setBio(bio);
        this.setGenre(genre);
        this.setName(name);
        this.setVerified(verified);
        this.setViwe_count(viwe_count);
    }

    public ArtistModel() {
    }

    public String getName() {
        return name;
    }

    public int getViwe_count() {
        return viwe_count;
    }

    public String getBio() {
        return bio;
    }

    public boolean isVerified() {
        return verified;
    }

    public String[] getGenre() {
        return genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setViwe_count(int viwe_count) {
        this.viwe_count = viwe_count;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public void setGenre(String[] genre) {
        this.genre = genre;
    }

}
