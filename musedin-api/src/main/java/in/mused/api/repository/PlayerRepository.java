package in.mused.api.repository;

import in.mused.api.domain.Player;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoRepository;

@RooMongoRepository(domainType = Player.class)
public interface PlayerRepository extends PlayerRepositoryCustom {

    List<in.mused.api.domain.Player> findAll();
    
    Player findByUserIdAndActive(ObjectId userId, boolean active);
    Player findByCode(String code);
}
