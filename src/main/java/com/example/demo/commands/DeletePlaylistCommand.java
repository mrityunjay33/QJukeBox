package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.IPlaylistService;

public class DeletePlaylistCommand implements ICommand{
    IPlaylistService iPlaylistService;

    public DeletePlaylistCommand(IPlaylistService iPlaylistService) {
        this.iPlaylistService = iPlaylistService;
    }

    // DELETE_PLAYLIST <playlist-name>
    // Eg : DELETE_PLAYLIST PLAYLIST_1
    // Output : Playlist PLAYLIST_1 is deleted!
    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        System.out.println(iPlaylistService.deletePlaylist(tokens.get(1)));
    }

    
    
}
