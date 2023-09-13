package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.ISongService;

public class ListSongsCommand implements ICommand{

    ISongService iSongService;

    public ListSongsCommand(ISongService iSongService) {
        this.iSongService = iSongService;
    }

    // LIST_SONGS
    // Output : List of all songs with name
    // [Song [id=1], Song [id=2], Song [id=3], Song [id=4], Song [id=5], Song [id=6], Song [id=7], Song [id=8], Song [id=9], Song [id=10]]


    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        System.out.println(iSongService.listSongs());
    }

    
    
}
