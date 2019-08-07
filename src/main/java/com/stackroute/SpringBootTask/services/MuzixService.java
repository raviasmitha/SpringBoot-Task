package com.stackroute.SpringBootTask.services;

import com.stackroute.SpringBootTask.domain.Muzix;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MuzixService {

   public Muzix saveTrack(Muzix musix);

    public List<Muzix> getAllTracks();

    public Muzix getTrackById(int id) ;

    public Muzix deleteTrackById(int id);

    public Muzix updateTrackById(Muzix musix, int id);

    public List<Muzix> getTrackBYName(String name);


}
