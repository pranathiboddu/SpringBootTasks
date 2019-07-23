package com.stackroute.muzixapplication.service;

import com.stackroute.muzixapplication.domain.Music;
import com.stackroute.muzixapplication.repository.MusicRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MusicServiceImpl implements MusicService
{
    MusicRepository musicRepository;

    public MusicServiceImpl(MusicRepository musicRepository)
    {
        this.musicRepository = musicRepository;
    }

    //method to save track
    @Override
    public void saveTrack(Music music) {
         musicRepository.save(music);

    }

    //method to delete track
    @Override
    public  void deleteTrack(int trackId) {
        musicRepository.deleteById(trackId);

    }

    //metod to get all tracks
    @Override
    public List<Music> getAllTracks() {
        return musicRepository.findAll();
    }


    //method to update track by id
    @Override
    public boolean updateTrack(Music music, int trackId)
    {
        Optional<Music> optionalMusic=musicRepository.findById(trackId);
        if(!optionalMusic.isPresent())
            return false;

        music.setTrackId(trackId);
        musicRepository.save(music);
        return true;
    }

}
