// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package in.mused.api.repository;

import in.mused.api.domain.UserConnection;
import in.mused.api.repository.UserConnectionRepository;
import org.bson.types.ObjectId;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

privileged aspect UserConnectionRepository_Roo_Mongo_Repository {
    
    declare parents: UserConnectionRepository extends PagingAndSortingRepository<UserConnection, ObjectId>;
    
    declare @type: UserConnectionRepository: @Repository;
    
}
