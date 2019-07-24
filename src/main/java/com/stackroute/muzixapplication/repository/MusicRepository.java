package com.stackroute.muzixapplication.repository;

import com.stackroute.muzixapplication.domain.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface MusicRepository extends JpaRepository<Music,Integer>
{
 //added query parameter
    @Query(value = "select c from Music c where c.trackName = ?1")
    List<Music> findTrackByName(String trackName);

}
