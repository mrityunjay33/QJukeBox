package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.ISongService;

public class NextSongCommand implements ICommand{

    ISongService iSongService;

    

    public NextSongCommand(ISongService iSongService) {
        this.iSongService = iSongService;
    }


    // NEXT_SONG
    // Eg: NEXT_SONG
    // Output : Song [id=4] is playing!
    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        System.out.println(iSongService.nextSong());
    }
    
}
