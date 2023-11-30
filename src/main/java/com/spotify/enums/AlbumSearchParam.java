package com.spotify.enums;

public enum AlbumSearchParam {
    ID("id"),
    NAME("name"),
    ARTIST_ID("artist_id"),
    YEAR("year"),
    SONGS("songs"),
    LISTENERCOUNT("listener_count");

    
    private String param;

    private AlbumSearchParam(String param){
        this.param = param;
    }

    public String getParam(){
        return this.param;
    }
}
