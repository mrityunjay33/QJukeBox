package com.example.demo.entities;

import java.util.List;

public class Playlist extends BaseEntity {
    String playListName;
    List<Song> listOfSongs;
    PlaylistStatus playlistStatus=PlaylistStatus.NOT_LOADED;
    
    public Playlist(String playListName, List<Song> listOfSongs) {
        this.playListName = playListName;
        this.listOfSongs = listOfSongs;
    }

    public Playlist(String id, String playListName, List<Song> listOfSongs) {
        this.id=id;
        this.playListName = playListName;
        this.listOfSongs = listOfSongs;
    }

    public String getPlayListName() {
        return playListName;
    }

    public List<Song> getListOfSongs() {
        return listOfSongs;
    }


    public void setPlaylistStatus(PlaylistStatus playlistStatus) {
        this.playlistStatus = playlistStatus;
    }

    
    public PlaylistStatus getPlaylistStatus() {
        return playlistStatus;
    }

    @Override
    public String toString() {
        return "Playlist [id=" + getId() + "]";
    }

    
}
