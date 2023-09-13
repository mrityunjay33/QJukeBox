package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.IPlaylistService;

public class AddSongToPlaylistCommand implements ICommand {

    IPlaylistService iPlaylistService;
    
    public AddSongToPlaylistCommand(IPlaylistService iPlaylistService) {
        this.iPlaylistService = iPlaylistService;
    }

    // ADD_SONG_TO_PLAYLIST <playlist-name> <song-id>
    // Eg : ADD_SONG_TO_PLAYLIST  PLAYLIST_2  8
    // Output : Playlist PLAYLIST_2 is revised with [Song [id=1], Song [id=3], Song [id=5], Song [id=7], Song [id=9], Song [id=8]]
    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        
        System.out.println(iPlaylistService.addSongToPlaylist(tokens.get(1), tokens.get(2)));
    }
    
}
