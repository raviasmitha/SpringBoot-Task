package com.stackroute.SpringBootTask.repository;

import com.stackroute.SpringBootTask.domain.Muzix;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MuzixRepositoryTest {

  @Autowired
  MuzixRepository repository;
  Muzix track;
  @Before
  public void setUp() {
    track = new Muzix(1, "Name",5,"Comments");
  }

  @After
  public void tearDown(){

    repository.deleteAll();
  }

  @Test
  public void testSaveTrack(){
    repository.save(track);
    Muzix fetchTrack = repository.findById(track.getId()).get();
    Assert.assertEquals(1,fetchTrack.getId());

  }

  @Test
  public void testSaveTrackFailure(){
    Muzix track1 = new Muzix(11, "Name",5, "Comments");
    repository.save(track);
    Muzix fetchTrack = repository.findById(track.getId()).get();
    Assert.assertNotSame(track1,track);
  }

  @Test
  public void testGetAllTracks(){
    Muzix track1 = new Muzix(1, "Name",5, "Comments");

    Muzix track2 = new Muzix(2, "Name2",5, "Comments2");
    repository.save(track1);
    repository.save(track2);
    List<Muzix> list = (List<Muzix>) repository.findAll();
    Assert.assertEquals("Name",list.get(0).getName());
  }

}
