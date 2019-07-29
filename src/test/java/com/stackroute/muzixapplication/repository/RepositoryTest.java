package com.stackroute.muzixapplication.repository;
import com.stackroute.muzixapplication.domain.Music;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest

public class RepositoryTest {

    @Autowired
    MusicRepository musicRepository;

    Music music;

    @Before
    public void setUp()
    {
        music=new Music();
        music.setTrackId(121);
        music.setTrackName("melodies");
        music.setTrackComments("pleasant");

    }

    @After
    public void tearDown(){

        musicRepository.deleteAll();
    }


    @Test
    public void testSavetrack(){
        musicRepository.save(music);
        Music fetchUser = musicRepository.findById(music.getTrackId()).get();
        Assert.assertEquals(121,fetchUser.getTrackId());

    }

    @Test
    public void testSaveUserFailure(){

        Music testmuzix = new Music(34,"Capital Letters","Hailee");
        musicRepository.save(music);
        Music fetchMuzix = musicRepository.findById(music.getTrackId()).get();
        Assert.assertNotSame(testmuzix,music);

    }

    @Test
    public void testGetAllUser(){


        Music music1 = new Music(67,"Treat You Better","Shawn Mendes");
        Music music2 = new Music(45,"Love Story","Taylor Swift");
        musicRepository.save(music1);
        musicRepository.save(music2);

        List<Music> list = musicRepository.findAll();
        Assert.assertEquals("Love Story",list.get(0).getTrackName());

    }

}
