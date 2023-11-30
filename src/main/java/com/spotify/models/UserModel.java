package com.spotify.models;

import com.spotify.interfaces.IUser;

public class UserModel extends IUser {
    private int id;
    private String name;
    private String email;
    private String password;
    private String birth_date;
    private String[] favorite_genres;

    public UserModel(String name, String email, String password, String birth_date, String[] favorite_genres) {
        this.setBirth_date(birth_date);
        this.setEmail(email);
        this.setFavorite_genres(favorite_genres);
        this.setName(name);
        this.setPassword(password);
    }

    public UserModel(int id, String name, String email, String password, String birth_date, String[] favorite_genres) {
        this.setId(id);
        this.setBirth_date(birth_date);
        this.setEmail(email);
        this.setFavorite_genres(favorite_genres);
        this.setName(name);
        this.setPassword(password);
    }

    public UserModel() {
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public String[] getFavorite_genres() {
        return favorite_genres;
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


    public void setEmail(String email) {
        

        this.email = email;
    }

    public void setBirth_date(String birth_date) {
        

        this.birth_date = birth_date;
    }

    public void setFavorite_genres(String[] favorite_genres) {
        this.favorite_genres = favorite_genres;
    }

    public void setPassword(String password) {


        this.password = password;
    }
}
