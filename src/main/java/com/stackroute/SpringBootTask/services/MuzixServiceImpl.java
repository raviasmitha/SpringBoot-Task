package com.stackroute.SpringBootTask.services;

import com.stackroute.SpringBootTask.domain.Muzix;
import com.stackroute.SpringBootTask.exceptions.TrackAlreadyExistsException;
import com.stackroute.SpringBootTask.exceptions.TrackNotFoundException;
import com.stackroute.SpringBootTask.repository.MuzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MuzixServiceImpl implements MuzixService {

    private MuzixRepository muzixRepository;

    @Autowired
    public MuzixServiceImpl(MuzixRepository muzixRepository){
        this.muzixRepository = muzixRepository;
    }

    @Override
    public Muzix saveTrack(Muzix muzix) throws TrackAlreadyExistsException {

        if (muzixRepository.existsById(muzix.getId())) {

            throw new TrackAlreadyExistsException("Track already exists with id  : " + muzix.getId());
        }

            Muzix savedMusix = muzixRepository.save(muzix);

            return savedMusix;
    }

    @Override
    public List<Muzix> getAllTracks() {

        return (List<Muzix>) muzixRepository.findAll();
    }

    @Override
    public Muzix getTrackById(int id) throws TrackNotFoundException {
        Optional<Muzix> user_id = muzixRepository.findById(id);

        if (!user_id.isPresent())

                throw new TrackNotFoundException("Record not found");


        return user_id.get();



    }

    @Override
    public Muzix deleteTrackById(int id) throws TrackNotFoundException {
        MuzixService muzixService= null;
        Muzix muzix = muzixService.getById(id);
        muzixRepository.deleteById(id);
        return muzix;

    }
    
    @Override
    public Muzix updateTrackById(Muzix musix, int id)throws TrackNotFoundException {

        Optional<Muzix> userOptional = muzixRepository.findById(id);

        if (!userOptional.isPresent())
        musix.setId(id);
        muzixRepository.save(musix);
        MuzixService muzixService=null;
        return muzixService.getTrackById(id);

    }

    public List<Muzix> getTrackBYName(String name) throws TrackNotFoundException{
        List<Muzix> user_id = muzixRepository.findTitleByName(name);

        return user_id;
    }
}
