// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package in.mused.api.domain;

import in.mused.api.domain.Song;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Persistent;

privileged aspect Song_Roo_Mongo_Entity {
    
    declare @type: Song: @Persistent;
    
    @Id
    private ObjectId Song.id;
    
    public ObjectId Song.getId() {
        return this.id;
    }
    
    public void Song.setId(ObjectId id) {
        this.id = id;
    }
    
}
