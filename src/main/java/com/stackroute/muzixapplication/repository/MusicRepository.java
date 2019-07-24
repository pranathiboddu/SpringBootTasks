package com.stackroute.muzixapplication.repository;

import com.stackroute.muzixapplication.domain.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface MusicRepository extends JpaRepository<Music,Integer>
{

    @Query(value = "select * from Music  where trackName = ?",
            nativeQuery = true)
    List<Music> findTrackeByName(String trackName);
}

