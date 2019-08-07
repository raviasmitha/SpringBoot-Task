package com.stackroute.SpringBootTask.services;

import com.stackroute.SpringBootTask.domain.Muzix;
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
    public Muzix saveTrack(Muzix muzix) {
        Muzix savedMuzix = muzixRepository.save(muzix);
        return savedMuzix;
    }

    @Override
    public List<Muzix> getAllTracks() {

        return (List<Muzix>) muzixRepository.findAll();
    }

    @Override
    public Muzix getTrackById(int id) {
        Optional<Muzix> user_id = muzixRepository.findById(id);

        return user_id.get();
    }

    @Override
    public Muzix deleteTrackById(int id) {
        muzixRepository.deleteById(id);
        MuzixService muzixService=null;
        return muzixService.getTrackById(id);

    }

    @Override
    public Muzix updateTrackById(Muzix musix, int id) {

        Optional<Muzix> userOptional = muzixRepository.findById(id);

        if (!userOptional.isPresent())
        musix.setId(id);
        muzixRepository.save(musix);
        MuzixService muzixService=null;
        return muzixService.getTrackById(id);

    }


}
