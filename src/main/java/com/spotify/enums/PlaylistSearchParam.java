package com.spotify.enums;

public enum PlaylistSearchParam {
    ID("id"),
    NAME("name"),
    BIO("bio"),
    SONGS_ID("songs_id"),
    LIKES("likes"),
    USER_ID("user_id");

    private String value;

    PlaylistSearchParam(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
