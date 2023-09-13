package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.IPlaylistService;

public class DeleteSongFromPlaylistCommand implements ICommand{
    IPlaylistService iPlaylistService;

    public DeleteSongFromPlaylistCommand(IPlaylistService iPlaylistService) {
        this.iPlaylistService = iPlaylistService;
    }

    
    // DELETE_SONG_FROM_PLAYLIST <playlist-name> <song-id>
    // Eg : DELETE_SONG_FROM_PLAYLIST PLAYLIST_2 9
    // Output : Playlist PLAYLIST_2 is revised with [Song [id=1], Song [id=3], Song [id=5], Song [id=7], Song [id=8]]
    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        System.out.println(iPlaylistService.deleteSongFromPlaylist(tokens.get(1), tokens.get(2)));
    }

    
}
