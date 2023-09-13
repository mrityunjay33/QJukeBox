package com.example.demo.repositories;

import java.util.Optional;
import com.example.demo.entities.Playlist;

public interface IPlaylistRepository extends CRUDRepository<Playlist, String>{
    public Optional<Playlist> findByName(String playListName);
}
