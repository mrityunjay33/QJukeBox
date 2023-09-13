package com.example.demo.services;

import java.util.List;
import com.example.demo.entities.Playlist;

public interface IPlaylistService {
    public Playlist createPlaylist(String playListName, List<String> listOfSongs);
    public String addSongToPlaylist(String playListName, String id);
    public String deleteSongFromPlaylist(String playListName, String id);
    public String deletePlaylist(String playListName);
    public String loadPlaylist(String playListName);
}
