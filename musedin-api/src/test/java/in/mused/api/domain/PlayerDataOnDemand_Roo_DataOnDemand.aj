// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package in.mused.api.domain;

import in.mused.api.domain.Player;
import in.mused.api.domain.PlayerDataOnDemand;
import in.mused.api.domain.Song;
import in.mused.api.service.PlayerService;
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

privileged aspect PlayerDataOnDemand_Roo_DataOnDemand {
    
    declare @type: PlayerDataOnDemand: @Component;
    
    private Random PlayerDataOnDemand.rnd = new SecureRandom();
    
    private List<Player> PlayerDataOnDemand.data;
    
    @Autowired
    PlayerService PlayerDataOnDemand.playerService;
    
    public Player PlayerDataOnDemand.getNewTransientPlayer(int index) {
        Player obj = new Player();
        setActive(obj, index);
        setCode(obj, index);
        setDescription(obj, index);
        setLastActivityTime(obj, index);
        setLastPolledTime(obj, index);
        setLocation(obj, index);
        setName(obj, index);
        setNowPlayingSong(obj, index);
        setPlaying(obj, index);
        setUserId(obj, index);
        return obj;
    }
    
    public void PlayerDataOnDemand.setActive(Player obj, int index) {
        Boolean active = true;
        obj.setActive(active);
    }
    
    public void PlayerDataOnDemand.setCode(Player obj, int index) {
        String code = "code_" + index;
        obj.setCode(code);
    }
    
    public void PlayerDataOnDemand.setDescription(Player obj, int index) {
        String description = "description_" + index;
        obj.setDescription(description);
    }
    
    public void PlayerDataOnDemand.setLastActivityTime(Player obj, int index) {
        Long lastActivityTime = new Integer(index).longValue();
        obj.setLastActivityTime(lastActivityTime);
    }
    
    public void PlayerDataOnDemand.setLastPolledTime(Player obj, int index) {
        Long lastPolledTime = new Integer(index).longValue();
        obj.setLastPolledTime(lastPolledTime);
    }
    
    public void PlayerDataOnDemand.setLocation(Player obj, int index) {
        double[] location = { new Integer(index).doubleValue(), new Integer(index).doubleValue() };
        obj.setLocation(location);
    }
    
    public void PlayerDataOnDemand.setName(Player obj, int index) {
        String name = "name_" + index;
        obj.setName(name);
    }
    
    public void PlayerDataOnDemand.setNowPlayingSong(Player obj, int index) {
        Song nowPlayingSong = null;
        obj.setNowPlayingSong(nowPlayingSong);
    }
    
    public void PlayerDataOnDemand.setPlaying(Player obj, int index) {
        Boolean playing = true;
        obj.setPlaying(playing);
    }
    
    public void PlayerDataOnDemand.setUserId(Player obj, int index) {
        ObjectId userId = null;
        obj.setUserId(userId);
    }
    
    public Player PlayerDataOnDemand.getSpecificPlayer(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Player obj = data.get(index);
        ObjectId id = obj.getId();
        return playerService.findPlayer(id);
    }
    
    public Player PlayerDataOnDemand.getRandomPlayer() {
        init();
        Player obj = data.get(rnd.nextInt(data.size()));
        ObjectId id = obj.getId();
        return playerService.findPlayer(id);
    }
    
    public boolean PlayerDataOnDemand.modifyPlayer(Player obj) {
        return false;
    }
    
    public void PlayerDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = playerService.findPlayerEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Player' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Player>();
        for (int i = 0; i < 10; i++) {
            Player obj = getNewTransientPlayer(i);
            try {
                playerService.savePlayer(obj);
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
