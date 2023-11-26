package com.spotify.enums;


public enum UserSearchParam{
    ID("id"),
    NAME("name"),
    EMAIL("email"),
    PASSWORD("password"),
    BIRTH_DATE("birth_date"),
    FAVORITE_GENRES("favorite_genres");

    private String param;

    private UserSearchParam(String param){
        this.param = param;
    }

    public String getParam(){
        return this.param;
    }
}