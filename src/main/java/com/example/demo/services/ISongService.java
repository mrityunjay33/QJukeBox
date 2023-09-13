package com.example.demo.services;

import com.example.demo.entities.Song;

public interface ISongService {
    public Song addSong(String songName,String artistName,String album,String genre);
    public String playSong();
    public String nextSong();
    public String previousSong();
    public String stopSong();
    public String listSongs();
}
