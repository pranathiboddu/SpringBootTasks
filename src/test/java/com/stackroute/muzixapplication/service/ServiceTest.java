package com.stackroute.muzixapplication.service;

import com.stackroute.muzixapplication.domain.Music;
import com.stackroute.muzixapplication.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixapplication.repository.MusicRepository;
import junit.framework.Assert;
import org.apache.catalina.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static springfox.documentation.builders.RequestHandlerSelectors.any;

//@WebMvcTest
//@RunWith(SpringRunner.class)
public class ServiceTest {
    Music music;

    //Create a mock for UserRepository
    @Mock
    MusicRepository musicRepository;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    MusicServiceImpl musicService;

    List<Music> list = null;


    @Before
    public void setUp(){
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        //music = new Music(101,"aaa","good");
        music=new Music();
        music.setTrackId(121);
        music.setTrackName("melodies");
        music.setTrackComments("pleasant");
        list = new ArrayList();
        list.add(music);
    }

    @After
    public void tearDown() {
        music = null;
        list = null;
    }

    // Test for getAllTracks service method
    @Test
    public void getAllTracks() {

        musicRepository.save(music);
        //stubbing the mock to return specific data
        when(musicRepository.findAll()).thenReturn(list);
        List<Music> userlist = musicService.getAllTracks();
        Assert.assertEquals(list,userlist);
    }

    // Test for saveTrack service method
    @Test
    public void saveTrack() throws TrackAlreadyExistsException {
        when(musicRepository.save(music)).thenReturn(music);
        Assert.assertEquals(music,musicService.saveTrack(music));

        //verify here verifies that trackRepository save method is only called once
        verify(musicRepository,times(1)).save(music);

    }


    // Test for deleteTrack service method
  /* @Test
    public void deleteTrack() throws TrackAlreadyExistsException {
        Music music1 = new Music(102,"dbb","hhd");
        musicService.saveTrack(music1);
        musicService.saveTrack(music1);
        Assert.assertTrue(musicService.deleteTrack(121));

        //verify here verifies that trackRepository deleteById method is only called once
        verify(musicRepository,times(1)).deleteById(music1.getTrackId());
    }
*/
    // Test for updateTrack service method
    @Test
    public void updateTrack() {
        when(musicRepository.save(music)).thenReturn(music);
        when(musicRepository.existsById(music.getTrackId())).thenReturn(true);
        music.setTrackComments("worst");
        Assert.assertTrue(musicService.updateTrack(music,101));
        //verify here verifies that trackRepository save method is only called once
        verify(musicRepository,times(1)).save(music);
    }
}

