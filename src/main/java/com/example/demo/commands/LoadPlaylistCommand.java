package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.IPlaylistService;

public class LoadPlaylistCommand implements ICommand {

    IPlaylistService iPlaylistService;

    
    
    public LoadPlaylistCommand(IPlaylistService iPlaylistService) {
        this.iPlaylistService = iPlaylistService;
    }


    //LOAD_PLAYLIST <playlist-name>
    //Eg: LOAD_PLAYLIST PLAYLIST_2
    //Output : Playlist PLAYLIST_2 is loaded!
    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        System.out.println(iPlaylistService.loadPlaylist(tokens.get(1)));
    }
    
}
