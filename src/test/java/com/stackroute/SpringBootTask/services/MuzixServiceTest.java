package com.stackroute.SpringBootTask.services;


import com.stackroute.SpringBootTask.domain.Muzix;
import com.stackroute.SpringBootTask.exceptions.TrackAlreadyExistsException;
import com.stackroute.SpringBootTask.exceptions.TrackNotFoundException;
import com.stackroute.SpringBootTask.repository.MuzixRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class MuzixServiceTest {

  Muzix muzix;

  //Create a mock for UserRepository
  @Mock
  MuzixRepository muzixRepository;

  //Inject the mocks as dependencies into UserServiceImpl
  @InjectMocks
  MuzixServiceImpl muzixService;
  List<Muzix> list= null;


  @Before
  public void setUp(){
    //Initialising the mock object
    MockitoAnnotations.initMocks(this);
    muzix = new Muzix();
    muzix.setId(26);
    muzix.setName("welcome");
    muzix.setRatings(10);
    muzix.setComment("good");
    list = new ArrayList();

    list.add(muzix);


  }

  @Test
  public void saveMuzixTestSuccess() throws TrackAlreadyExistsException {

    when(muzixRepository.save((Muzix)any())).thenReturn(muzix);
    Muzix savedMuzix = muzixService.saveMusix(muzix);
    Assert.assertEquals(muzix,savedMuzix);

    //verify here verifies that userRepository save method is only called once
    verify(muzixRepository,times(1)).save(muzix);

  }



  @Test
  public void getAllTracks(){

    muzixRepository.save(muzix);
    //stubbing the mock to return specific data
    when(muzixRepository.findAll()).thenReturn(list);
    List<Muzix> tracklist = muzixService.getMusix();
    Assert.assertEquals(list,tracklist);
  }

  @Test
  public void getTrackById() throws TrackNotFoundException {

    muzixRepository.save(muzix);
    //stubbing the mock to return specific data
    when(muzixRepository.findById(1)).thenReturn(java.util.Optional.ofNullable(muzix));
    Muzix track = muzixService.getById(1);
    Assert.assertEquals(muzix,track);
  }

  @Test
  public void getTrackByName() throws TrackNotFoundException {

    muzixRepository.save(muzix);
    //stubbing the mock to return specific data
    when(muzixRepository.findTitleByName("ashu")).thenReturn(list);
    List<Muzix> track = muzixService.getBYName("ashu");
    Assert.assertEquals(list,track);
  }
