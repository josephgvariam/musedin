// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package in.mused.api.domain;

import in.mused.api.domain.Playlist;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Persistent;

privileged aspect Playlist_Roo_Mongo_Entity {
    
    declare @type: Playlist: @Persistent;
    
    @Id
    private ObjectId Playlist.id;
    
    public ObjectId Playlist.getId() {
        return this.id;
    }
    
    public void Playlist.setId(ObjectId id) {
        this.id = id;
    }
    
}
