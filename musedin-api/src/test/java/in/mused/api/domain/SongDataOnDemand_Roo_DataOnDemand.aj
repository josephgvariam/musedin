// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package in.mused.api.domain;

import in.mused.api.domain.Song;
import in.mused.api.domain.SongDataOnDemand;
import in.mused.api.service.SongService;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

privileged aspect SongDataOnDemand_Roo_DataOnDemand {
    
    declare @type: SongDataOnDemand: @Component;
    
    private Random SongDataOnDemand.rnd = new SecureRandom();
    
    private List<Song> SongDataOnDemand.data;
    
    @Autowired
    SongService SongDataOnDemand.songService;
    
    public Song SongDataOnDemand.getNewTransientSong(int index) {
        Song obj = new Song();
        setAlbum(obj, index);
        setArtist(obj, index);
        setComment(obj, index);
        setDownVotes(obj, index);
        setFileName(obj, index);
        setGenre(obj, index);
        setIconUrl(obj, index);
        setSongUrl(obj, index);
        setTitle(obj, index);
        setUpVotes(obj, index);
        setYear(obj, index);
        return obj;
    }
    
    public void SongDataOnDemand.setAlbum(Song obj, int index) {
        String album = "album_" + index;
        obj.setAlbum(album);
    }
    
    public void SongDataOnDemand.setArtist(Song obj, int index) {
        String artist = "artist_" + index;
        obj.setArtist(artist);
    }
    
    public void SongDataOnDemand.setComment(Song obj, int index) {
        String comment = "comment_" + index;
        obj.setComment(comment);
    }
    
    public void SongDataOnDemand.setDownVotes(Song obj, int index) {
        int downVotes = index;
        obj.setDownVotes(downVotes);
    }
    
    public void SongDataOnDemand.setFileName(Song obj, int index) {
        String fileName = "fileName_" + index;
        obj.setFileName(fileName);
    }
    
    public void SongDataOnDemand.setGenre(Song obj, int index) {
        String genre = "genre_" + index;
        obj.setGenre(genre);
    }
    
    public void SongDataOnDemand.setIconUrl(Song obj, int index) {
        String iconUrl = "iconUrl_" + index;
        obj.setIconUrl(iconUrl);
    }
    
    public void SongDataOnDemand.setSongUrl(Song obj, int index) {
        String songUrl = "songUrl_" + index;
        obj.setSongUrl(songUrl);
    }
    
    public void SongDataOnDemand.setTitle(Song obj, int index) {
        String title = "title_" + index;
        obj.setTitle(title);
    }
    
    public void SongDataOnDemand.setUpVotes(Song obj, int index) {
        int upVotes = index;
        obj.setUpVotes(upVotes);
    }
    
    public void SongDataOnDemand.setYear(Song obj, int index) {
        String year = "year_" + index;
        obj.setYear(year);
    }
    
    public Song SongDataOnDemand.getSpecificSong(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Song obj = data.get(index);
        ObjectId id = obj.getId();
        return songService.findSong(id);
    }
    
    public Song SongDataOnDemand.getRandomSong() {
        init();
        Song obj = data.get(rnd.nextInt(data.size()));
        ObjectId id = obj.getId();
        return songService.findSong(id);
    }
    
    public boolean SongDataOnDemand.modifySong(Song obj) {
        return false;
    }
    
    public void SongDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = songService.findSongEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Song' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Song>();
        for (int i = 0; i < 10; i++) {
            Song obj = getNewTransientSong(i);
            try {
                songService.saveSong(obj);
            } catch (ConstraintViolationException e) {
                StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getConstraintDescriptor()).append(":").append(cv.getMessage()).append("=").append(cv.getInvalidValue()).append("]");
                }
                throw new RuntimeException(msg.toString(), e);
            }
            data.add(obj);
        }
    }
    
}
