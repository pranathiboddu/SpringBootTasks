package com.stackroute.muzixapplication.service;

import com.stackroute.muzixapplication.domain.Music;
import com.stackroute.muzixapplication.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixapplication.exceptions.TrackNotFoundException;
import com.stackroute.muzixapplication.repository.MusicRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicServiceImpl implements MusicService {
    MusicRepository musicRepository;

    public MusicServiceImpl(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    //method to save track
    @Override
    public Music saveTrack(Music music) throws TrackAlreadyExistsException //handling exceptions
    {
        if (musicRepository.existsById(music.getTrackId())) {
            throw new TrackAlreadyExistsException();
        }
        Music savedTrack = musicRepository.save(music);
        if (savedTrack == null) {
            throw new TrackAlreadyExistsException();
        }
        return savedTrack;

    }

    //method to delete track
    @Override
    public void deleteTrack(int trackId) throws TrackNotFoundException {
        if (!musicRepository.existsById(trackId)) {
            throw new TrackNotFoundException();
        }
        musicRepository.deleteById(trackId);

    }

    //metod to get all tracks
    @Override
    public List<Music> getAllTracks() {
        return musicRepository.findAll();
    }


    //method to update track by id
    @Override
    public boolean updateTrack(Music music, int trackId) {
        Optional<Music> optionalMusic = musicRepository.findById(trackId);
        if (!optionalMusic.isPresent()) {
            return false;
        } else {
            music.setTrackId(trackId);
            musicRepository.save(music);
            return true;
        }
    }
//method to track music by name
    @Override
    public List<Music> getTrackByName(String trackName) throws TrackNotFoundException
    {
        List<Music> optionalMusic = musicRepository.findTrackByName(trackName);
        if (optionalMusic.isEmpty())  //checking if track exists or not
        {
            throw new TrackNotFoundException();
        }
        else
            {
            List<Music> musicTrack = musicRepository.findTrackByName(trackName);
            return musicTrack;
        }

    }
}