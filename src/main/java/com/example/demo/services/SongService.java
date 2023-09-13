package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.entities.Playlist;
import com.example.demo.entities.PlaylistStatus;
import com.example.demo.entities.Song;
import com.example.demo.entities.SongStatus;
import com.example.demo.repositories.IPlaylistRepository;
import com.example.demo.repositories.ISongRepository;

public class SongService implements ISongService {
    ISongRepository iSongRepository;
    IPlaylistRepository iPlaylistRepository;

    public SongService(ISongRepository iSongRepository, IPlaylistRepository iPlaylistRepository) {
        this.iSongRepository = iSongRepository;
        this.iPlaylistRepository = iPlaylistRepository;
    }

    @Override
    public Song addSong(String songName, String artistName, String album, String genre) {
        // TODO Auto-generated method stub
        Song song= new Song(songName, artistName, album, genre);
        return iSongRepository.save(song);
    }

    @Override
    public String playSong() {
        // TODO Auto-generated method stub
        List<Playlist> pList= iPlaylistRepository.findAll();
        List<Song> sList= new ArrayList<Song>();
        
        for(Playlist p:pList){
            if(p.getPlaylistStatus().equals(PlaylistStatus.LOADED)){
                sList=p.getListOfSongs();
                break;
            }
        }
        
        for(Song s:sList){
            if(s.getSongStatus().equals(SongStatus.PLAYING)){
                return s+" is paused!";
            }
        }

        Song song=sList.get(0);
        song.setSongStatus(SongStatus.PLAYING);

        return song + " is playing!";
    }

    @Override
    public String nextSong() {
        // TODO Auto-generated method stub
        List<Playlist> pList= iPlaylistRepository.findAll();
        List<Song> sList= new ArrayList<Song>();
        
        for(Playlist p:pList){
            if(p.getPlaylistStatus().equals(PlaylistStatus.LOADED)){
                sList=p.getListOfSongs();
                break;
            }
        }
        
        Song song=null;
        for(int i=0; i<sList.size(); i++){
            if(sList.get(i).getSongStatus().equals(SongStatus.PLAYING)){
                sList.get(i).setSongStatus(SongStatus.NOT_PLAYED);
                if(i==sList.size()-1){
                    song=sList.get(0);
                }
                else{
                    song=sList.get(i+1);
                }
                break;
            }
        }
        song.setSongStatus(SongStatus.PLAYING);

        return song + " is playing!";
    }

    @Override
    public String previousSong() {
        // TODO Auto-generated method stub
        List<Playlist> pList= iPlaylistRepository.findAll();
        List<Song> sList= new ArrayList<Song>();
        
        for(Playlist p:pList){
            if(p.getPlaylistStatus().equals(PlaylistStatus.LOADED)){
                sList=p.getListOfSongs();
                break;
            }
        }
        
        Song song=null;
        for(int i=0; i<sList.size(); i++){
            if(sList.get(i).getSongStatus().equals(SongStatus.PLAYING)){
                sList.get(i).setSongStatus(SongStatus.NOT_PLAYED);
                if(i==0){
                    song=sList.get(sList.size()-1);
                }
                else{
                    song=sList.get(i-1);
                }
                break;
            }
        }
        song.setSongStatus(SongStatus.PLAYING);

        return song + " is playing!";
    }

    @Override
    public String stopSong() {
        // TODO Auto-generated method stub
        List<Playlist> pList= iPlaylistRepository.findAll();
        List<Song> sList= new ArrayList<Song>();
        
        for(Playlist p:pList){
            if(p.getPlaylistStatus().equals(PlaylistStatus.LOADED)){
                sList=p.getListOfSongs();
                break;
            }
        }
        
        Song song=null;
        for(int i=0; i<sList.size(); i++){
            if(sList.get(i).getSongStatus().equals(SongStatus.PLAYING)){
                song=sList.get(i);
            }
        }
        song.setSongStatus(SongStatus.NOT_PLAYED);

        return song + " is stopped!";
    }

    @Override
    public String listSongs() {
        // TODO Auto-generated method stub
        List<Song> lSong= iSongRepository.findAll();
        return lSong.toString();
    }
    
}
