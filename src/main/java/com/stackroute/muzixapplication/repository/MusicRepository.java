package com.stackroute.muzixapplication.repository;

import com.stackroute.muzixapplication.domain.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends JpaRepository<Music,Integer>
{

}
