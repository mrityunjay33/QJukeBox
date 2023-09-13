package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.ISongService;

public class AddSongCommand implements ICommand{
    ISongService iSongService;  

    public AddSongCommand(ISongService iSongService) {
        this.iSongService = iSongService;
    }

    // ADD_SONG <song-name>,<artist/band-name>,<album-name>,<genre>
    // Output: Song [id=1]
    // Eg : ADD_SONG Something In the Way, Nirvana, NeverMind, Rock
    @Override
    public void invoke(List<String> tokens) {
        System.out.println(iSongService.addSong(tokens.get(1),tokens.get(2),tokens.get(3),tokens.get(4)));
    }
    
}
