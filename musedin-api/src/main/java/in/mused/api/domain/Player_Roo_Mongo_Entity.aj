// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package in.mused.api.domain;

import in.mused.api.domain.Player;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Persistent;

privileged aspect Player_Roo_Mongo_Entity {
    
    declare @type: Player: @Persistent;
    
    @Id
    private ObjectId Player.id;
    
    public ObjectId Player.getId() {
        return this.id;
    }
    
    public void Player.setId(ObjectId id) {
        this.id = id;
    }
    
}
