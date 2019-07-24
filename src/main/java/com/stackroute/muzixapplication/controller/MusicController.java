package com.stackroute.muzixapplication.controller;

import com.stackroute.muzixapplication.domain.Music;
import com.stackroute.muzixapplication.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController //created restcontroller annotation
@RequestMapping(value = "api/v1") //set path as api/v1
public class MusicController {

    @Autowired
    MusicService musicService; //autowired Musicservice

    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }

    @PostMapping(value = "/save") //post mapping for saving the tracks
    public ResponseEntity<?> saveTrack(@RequestBody Music music) {
        ResponseEntity responseEntity;
        try {
            musicService.saveTrack(music);
            responseEntity = new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PutMapping(value = "/update/{trackId}") //put mapping for updating tracks
    public ResponseEntity<?> updateTrack(@PathVariable int trackId, Music music) {
        ResponseEntity responseEntity;
        try {
            musicService.updateTrack(music,trackId);
            responseEntity = new ResponseEntity<String>("Successfully updated", HttpStatus.CREATED);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping(value = "/get") //get mapping for getting all tracks
    public ResponseEntity<?> getAllTracks(@RequestBody Music music) {
        return new ResponseEntity<List<Music>>(musicService.getAllTracks(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{trackId}") //delete mapping for deleting track by id
    public ResponseEntity<?> deleteTrack(@PathVariable int trackId) {
        ResponseEntity responseEntity;
        try {
            musicService.deleteTrack(trackId);
            responseEntity = new ResponseEntity<String>("Succesfully deleted", HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
        return responseEntity;

    }
    @GetMapping("/name/{trackName}")
    public ResponseEntity<List<Music>> getTrackByName(@PathVariable String trackName) {
        List<Music> music = musicService.getTrackByName(trackName);
        return new ResponseEntity<List<Music>>(music, HttpStatus.OK);
    }

}