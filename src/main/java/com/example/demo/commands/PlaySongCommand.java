package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.ISongService;

public class PlaySongCommand implements ICommand {

    ISongService iSongService;

    

    public PlaySongCommand(ISongService iSongService) {
        this.iSongService = iSongService;
    }

    // PLAY_SONG 
    // Eg: PLAY_SONG
    // Output :Song [id=2] is playing!

    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        System.out.println(iSongService.playSong());
    }
    
}
