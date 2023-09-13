package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.ISongService;

public class StopSongCommand implements ICommand{

    ISongService iSongService;

    public StopSongCommand(ISongService iSongService) {
        this.iSongService = iSongService;
    }

    // STOP_SONG
    // Eg: STOP_SONG
    // Output : Song [id=2] is stopped!
    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        System.out.println(iSongService.stopSong());
    }

    
    
}
