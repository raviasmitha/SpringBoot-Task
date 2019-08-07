package com.stackroute.SpringBootTask.services;

import com.stackroute.SpringBootTask.domain.Muzix;
import com.stackroute.SpringBootTask.exceptions.TrackAlreadyExistsException;
import com.stackroute.SpringBootTask.exceptions.TrackNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MuzixService {

    
    public Muzix saveMusix(Muzix musix) throws TrackAlreadyExistsException;

    public Muzix getTrackById(int id) throws TrackNotFoundException;

    public List<Muzix> getAllTracks();

    public Muzix deleteTrackById(int id);

    public Muzix updateTrackById(Muzix musix, int id);

    public List<Muzix> getTrackBYName(String name);



}
