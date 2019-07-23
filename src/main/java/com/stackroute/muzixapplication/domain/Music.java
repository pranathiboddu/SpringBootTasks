package com.stackroute.muzixapplication.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//created entity annotation
@Entity
@Data //annotated as data for getters and setters
@NoArgsConstructor //annotated as noargsconstructor for default constructor
@AllArgsConstructor //annotated as allargsconstructor for parameterized constructor with all fields
public class Music {
    @Id
    int trackId; //annotated as id to create id as primary key
    String trackName; //created trackname and track comments
    String trackComments;
}
