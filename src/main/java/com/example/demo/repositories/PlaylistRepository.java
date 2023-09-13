package com.example.demo.repositories;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.demo.entities.Playlist;

public class PlaylistRepository implements IPlaylistRepository {

    Integer _c=0;
    Map<String,Playlist> PlaylistData;
    
    
    public PlaylistRepository() {
        this.PlaylistData=new HashMap<>();
    }

    @Override
    public Playlist save(Playlist entity) {
        // TODO Auto-generated method stub
        if (entity.getId() == null) {

            _c++;

            Playlist playlist = new Playlist(Integer.toString(_c), entity.getPlayListName(), entity.getListOfSongs());
            PlaylistData.put(playlist.getId(), playlist);
            return playlist;
        } else {
            return PlaylistData.get(entity.getId());

        }
    }

    @Override
    public List<Playlist> findAll() {
        // TODO Auto-generated method stub
        return PlaylistData.values().stream().collect(Collectors.toList());
    }

    @Override
    public Optional<Playlist> findById(String id) {
        // TODO Auto-generated method stub
        return Optional.ofNullable(PlaylistData.get(id));
    }

    @Override
    public boolean existsById(String id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void delete(Playlist entity) {
        // TODO Auto-generated method stub
        PlaylistData.remove(entity.getId());
    }

    @Override
    public void deleteById(String id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Optional<Playlist> findByName(String playListName) {
        // TODO Auto-generated method stub
        return PlaylistData.values().stream().filter(x -> x.getPlayListName().equals(playListName)).findAny();
    }
    
}
