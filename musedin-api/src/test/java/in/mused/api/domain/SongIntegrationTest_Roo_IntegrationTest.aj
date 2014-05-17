// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package in.mused.api.domain;

import in.mused.api.domain.SongDataOnDemand;
import in.mused.api.domain.SongIntegrationTest;
import in.mused.api.service.SongService;
import java.util.List;
import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

privileged aspect SongIntegrationTest_Roo_IntegrationTest {
    
    declare @type: SongIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: SongIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext*.xml");
    
    @Autowired
    SongDataOnDemand SongIntegrationTest.dod;
    
    @Autowired
    SongService SongIntegrationTest.songService;
    
    @Test
    public void SongIntegrationTest.testCountAllSongs() {
        Assert.assertNotNull("Data on demand for 'Song' failed to initialize correctly", dod.getRandomSong());
        long count = songService.countAllSongs();
        Assert.assertTrue("Counter for 'Song' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void SongIntegrationTest.testFindSong() {
        Song obj = dod.getRandomSong();
        Assert.assertNotNull("Data on demand for 'Song' failed to initialize correctly", obj);
        ObjectId id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Song' failed to provide an identifier", id);
        obj = songService.findSong(id);
        Assert.assertNotNull("Find method for 'Song' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Song' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void SongIntegrationTest.testFindAllSongs() {
        Assert.assertNotNull("Data on demand for 'Song' failed to initialize correctly", dod.getRandomSong());
        long count = songService.countAllSongs();
        Assert.assertTrue("Too expensive to perform a find all test for 'Song', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Song> result = songService.findAllSongs();
        Assert.assertNotNull("Find all method for 'Song' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Song' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void SongIntegrationTest.testFindSongEntries() {
        Assert.assertNotNull("Data on demand for 'Song' failed to initialize correctly", dod.getRandomSong());
        long count = songService.countAllSongs();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Song> result = songService.findSongEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'Song' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Song' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void SongIntegrationTest.testSaveSong() {
        Assert.assertNotNull("Data on demand for 'Song' failed to initialize correctly", dod.getRandomSong());
        Song obj = dod.getNewTransientSong(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Song' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Song' identifier to be null", obj.getId());
        songService.saveSong(obj);
        Assert.assertNotNull("Expected 'Song' identifier to no longer be null", obj.getId());
    }
    
    @Test
    public void SongIntegrationTest.testDeleteSong() {
        Song obj = dod.getRandomSong();
        Assert.assertNotNull("Data on demand for 'Song' failed to initialize correctly", obj);
        ObjectId id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Song' failed to provide an identifier", id);
        obj = songService.findSong(id);
        songService.deleteSong(obj);
        Assert.assertNull("Failed to remove 'Song' with identifier '" + id + "'", songService.findSong(id));
    }
    
}
