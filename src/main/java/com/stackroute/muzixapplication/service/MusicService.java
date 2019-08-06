package com.stackroute.muzixapplication.service;

import com.stackroute.muzixapplication.domain.Music;

import java.util.List;

//created interface
 interface MusicService {
    //defined different methods

    public void saveTrack(Music music); //method for saving tracks

    public void deleteTrack(int trackId); //method for deleting track

    public List<Music> getAllTracks(); //method for getting all tracks

    public boolean updateTrack(Music music,int trackId); //method for updating track

    public List<Music> getTrackByName(String trackName);
}
