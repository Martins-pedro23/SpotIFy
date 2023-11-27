package com.spotify.enums;

public enum ArtistSearchParam {
    ID("id"),
    NAME("name"),
    VIEW_COUNT("view_count"),
    BIO("bio"),
    VERIFIED("verified"),
    GENRE("genre");

    private String param;

    private ArtistSearchParam(String param){
        this.param = param;
    }

    public String getParam(){
        return this.param;
    }
}
