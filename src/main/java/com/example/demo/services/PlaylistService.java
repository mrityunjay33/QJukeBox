package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.Exceptions.PlaylistNotFoundException;
import com.example.demo.Exceptions.SongNotFoundException;
import com.example.demo.entities.Playlist;
import com.example.demo.entities.PlaylistStatus;
import com.example.demo.entities.Song;
import com.example.demo.entities.SongStatus;
import com.example.demo.repositories.IPlaylistRepository;
import com.example.demo.repositories.ISongRepository;

public class PlaylistService implements IPlaylistService {

    ISongRepository iSongRepository;
    IPlaylistRepository iPlaylistRepository;

    
    public PlaylistService(ISongRepository iSongRepository, IPlaylistRepository iPlaylistRepository) {
        this.iSongRepository = iSongRepository;
        this.iPlaylistRepository = iPlaylistRepository;
    }


    @Override
    public Playlist createPlaylist(String playListName, List<String> listOfSongIds) {
        // TODO Auto-generated method stub
        List<Song> listOfSongs= new ArrayList<Song>();
        for(int i=0;i<listOfSongIds.size();i++){
            listOfSongs.add(iSongRepository.findById(listOfSongIds.get(i)).orElseThrow(()->new SongNotFoundException()));
        }

        Playlist playlist= new Playlist(playListName, listOfSongs);
        
        return iPlaylistRepository.save(playlist);
    }


    @Override
    public String addSongToPlaylist(String playListName, String id) {
        // TODO Auto-generated method stub
        Song song= iSongRepository.findAll().stream().filter(t->t.getId().equals(id)).findAny().get();
        Playlist playlist= iPlaylistRepository.findByName(playListName).orElseThrow(()->new PlaylistNotFoundException());
        playlist.getListOfSongs().add(song);
        List<Song> updatedList=playlist.getListOfSongs();

        return "Playlist " + playListName + " is revised with " + updatedList;
    }


    @Override
    public String deleteSongFromPlaylist(String playListName, String id) {
        // TODO Auto-generated method stub
        
        Song song= iSongRepository.findAll().stream().filter(t->t.getId().equals(id)).findAny().get();
        Playlist playlist= iPlaylistRepository.findByName(playListName).orElseThrow(()->new PlaylistNotFoundException());
        playlist.getListOfSongs().remove(song);
        List<Song> updatedList=playlist.getListOfSongs();

        return "Playlist " + playListName + " is revised with " + updatedList;
    }


    @Override
    public String deletePlaylist(String playListName) {
        // TODO Auto-generated method stub
        Playlist playlist= iPlaylistRepository.findByName(playListName).orElseThrow(()->new PlaylistNotFoundException());
        iPlaylistRepository.delete(playlist);
        return "Playlist " + playListName + " is deleted!";
    }


    @Override
    public String loadPlaylist(String playListName) {
        // TODO Auto-generated method stub
        List<Playlist> pList=iPlaylistRepository.findAll();
        Playlist oldPlaylist=null;
        for(Playlist p:pList){
            if(p.getPlaylistStatus().equals(PlaylistStatus.LOADED)){
                oldPlaylist=p;
                p.setPlaylistStatus(PlaylistStatus.NOT_LOADED);
            }
        }

        // for(Song s:oldPlaylist.getListOfSongs()){
        //     if(!s.getSongStatus().equals(SongStatus.NOT_PLAYED)){
        //         s.setSongStatus(SongStatus.NOT_PLAYED);
        //     }
        // }

        Playlist playlist= iPlaylistRepository.findByName(playListName).orElseThrow(()->new PlaylistNotFoundException());
        playlist.setPlaylistStatus(PlaylistStatus.LOADED);
        return "Playlist " + playListName + " is loaded!";
    }
    
}
