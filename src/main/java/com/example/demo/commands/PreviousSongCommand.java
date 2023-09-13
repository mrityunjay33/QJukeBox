package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.ISongService;

public class PreviousSongCommand implements ICommand{

    ISongService iSongService;

    public PreviousSongCommand(ISongService iSongService) {
        this.iSongService = iSongService;
    }

    // PREVIOUS_SONG
    // Eg: PREVIOUS_SONG
    // Output : Song [id=2] is playing!
    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        System.out.println(iSongService.previousSong());
    }

    
    
}
