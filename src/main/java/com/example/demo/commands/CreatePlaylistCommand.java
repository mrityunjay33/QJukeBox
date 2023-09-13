package com.example.demo.commands;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.entities.Song;
import com.example.demo.repositories.ISongRepository;
import com.example.demo.services.IPlaylistService;

public class CreatePlaylistCommand implements ICommand {

    IPlaylistService iPlaylistService;

    
    public CreatePlaylistCommand(IPlaylistService iPlaylistService) {
        this.iPlaylistService = iPlaylistService;
    }



    // CREATE_PLAYLIST <playlist-name> <song-ids>
    // Eg : CREATE_PLAYLIST  PLAYLIST_2  1 2 3
    // Output : Playlist [id=1]
    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub

        List<String> listOfSongIds= new ArrayList<>();
        for(int i=2;i<tokens.size();i++){
            listOfSongIds.add(tokens.get(i));
        }

        System.out.println(iPlaylistService.createPlaylist(tokens.get(1), listOfSongIds));
    }
    
}
