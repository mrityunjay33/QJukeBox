package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.demo.entities.Song;

public class SongRepository implements ISongRepository{

    Integer _c=0;
    Map<String,Song> SongData;

    public SongRepository() {
        this.SongData = new HashMap<>();
    }

    @Override
    public Song save(Song entity) {
        // TODO Auto-generated method stub
        if (entity.getId() == null) {

            _c++;

            Song song = new Song(Integer.toString(_c), entity.getSongName(), entity.getArtistName(), entity.getAlbum(), entity.getGenre() );
            SongData.put(song.getId(), song);
            return song;
        } else {
            return SongData.get(entity.getId());

        }

    }

    @Override
    public List<Song> findAll() {
        // TODO Auto-generated method stub
        return SongData.values().stream().collect(Collectors.toList());
    }

    @Override
    public Optional<Song> findById(String id) {
        // TODO Auto-generated method stub
        return Optional.ofNullable(SongData.get(id));
    }

    @Override
    public boolean existsById(String id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void delete(Song entity) {
        // TODO Auto-generated method stub
        
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
    
}
