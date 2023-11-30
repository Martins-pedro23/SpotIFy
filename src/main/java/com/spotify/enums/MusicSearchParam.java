package com.spotify.enums;

public enum MusicSearchParam {
    ID("id"),
    NAME("name"),
    LISTENER_COUNT("listenerCount"),
    ALBUM_ID("albumId"),
    DURATION("duration"),
    ARTIST_ID("artistId");

    private String param;

    private MusicSearchParam(String param){
        this.param = param;
    }

    public String getParam(){
        return this.param;
    }

}
