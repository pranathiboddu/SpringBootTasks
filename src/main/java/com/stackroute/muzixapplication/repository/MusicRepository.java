package com.stackroute.muzixapplication.repository;

import com.mongodb.Mongo;
import com.stackroute.muzixapplication.domain.Music;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MusicRepository extends MongoRepository<Music,Integer>
{
/*
    @Query(value = "select c from Music c where c.trackName = ?1")
    List<Music> findTrackByName(String trackName);*/
}

