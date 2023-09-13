package com.example.demo.entities;


public class Song extends BaseEntity{
    String songName;
    String artistName;
    String album;
    String genre;
    SongStatus songStatus=SongStatus.NOT_PLAYED;

    public Song(String songName, String artistName, String album, String genre) {
        this.songName = songName;
        this.artistName = artistName;
        this.album = album;
        this.genre = genre;
    }

    public Song(String id, String songName, String artistName, String album, String genre) {
        this.songName = songName;
        this.artistName = artistName;
        this.album = album;
        this.genre = genre;
        this.id=id;
    }

    public String getSongName() {
        return songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getAlbum() {
        return album;
    }

    public String getGenre() {
        return genre;
    }

    public SongStatus getSongStatus() {
        return songStatus;
    }

    public void setSongStatus(SongStatus songStatus) {
        this.songStatus = songStatus;
    }

    @Override
    public String toString() {
        return "Song [id=" + getId() +  "]";
    }
    
}
