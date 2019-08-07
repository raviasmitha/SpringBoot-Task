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

    MuzixService muzixService;

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
    public String deleteTrackById(@PathVariable int id) {
        muzixService.deleteById(id);
        return "Data deleted";
    }

    /*
    This method will update data by id
     */

    @PutMapping("/track/{id}")
    public ResponseEntity<Muzix> updateTrackById(@RequestBody Muzix muzix, @PathVariable int id) {

        if (muzixService.updateTrackById(muzix, id)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }


}

