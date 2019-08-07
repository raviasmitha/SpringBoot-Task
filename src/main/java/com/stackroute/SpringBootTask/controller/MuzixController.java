package com.stackroute.SpringBootTask.controller;

import com.stackroute.SpringBootTask.domain.Muzix;
import com.stackroute.SpringBootTask.services.MuzixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class MuzixController {

    private MuzixService muzixService;

    @Autowired
    public MuzixController(MuzixService muzixService){
        this.muzixService = muzixService;
    }


    @PostMapping("/track")

    public ResponseEntity<?> saveTrack(@RequestBody Muzix muzix){
        ResponseEntity responseEntity;
        muzixService.saveTrack(muzix);
        responseEntity= new ResponseEntity("Successfully created", HttpStatus.CREATED);
        return responseEntity;
    }

    /* This method will retrive musix by using Query parameter */

    @GetMapping("/tracks")

    public ResponseEntity<List<Muzix>> getAllTracks() {

        List<Muzix> musixes = muzixService.getAllTracks();
        return new ResponseEntity<List<Muzix>>(musixes, HttpStatus.OK);


    }

    @GetMapping("/track/{id}")

    public ResponseEntity<?> getTrackById(@PathVariable int id)  {

        Muzix muzix = null;
        muzix = muzixService.getTrackById(id);

        return new ResponseEntity<Muzix>(muzix, HttpStatus.OK);
    }

    /*
     This method will delete data by id
     */

    @DeleteMapping("/track/{id}")
    public ResponseEntity<Muzix> deleteTrackById(@PathVariable int id) {
        muzixService.deleteTrackById(id);
        Muzix muzix = muzixService.getTrackById(id);
        return new ResponseEntity<Muzix>(muzix,HttpStatus.OK);
    }

    /*
    This method will update data by id
     */

    @PutMapping("/track/{id}")
    public ResponseEntity<Muzix> updateTrackById(@RequestBody Muzix muzix, @PathVariable int id) {

        muzixService.updateTrackById(muzix, id);
        Muzix muzix1 = muzixService.getTrackById(id);
        return new ResponseEntity<Muzix>(muzix, HttpStatus.OK);


    }
    @GetMapping("/track/{name}")
    public ResponseEntity<List<Muzix>> getTrackByname(@PathVariable String name) {
        List<Muzix> musix = muzixService.getBYName(name);
        return new ResponseEntity<List<Muzix>>(musix, HttpStatus.OK);
    }



}

