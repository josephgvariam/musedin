// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package in.mused.api.domain;

import in.mused.api.domain.UserConnection;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Persistent;

privileged aspect UserConnection_Roo_Mongo_Entity {
    
    declare @type: UserConnection: @Persistent;
    
    @Id
    private ObjectId UserConnection.id;
    
    public ObjectId UserConnection.getId() {
        return this.id;
    }
    
    public void UserConnection.setId(ObjectId id) {
        this.id = id;
    }
    
}