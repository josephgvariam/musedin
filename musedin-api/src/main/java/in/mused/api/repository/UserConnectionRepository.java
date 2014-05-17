package in.mused.api.repository;

import in.mused.api.domain.UserConnection;
import java.util.List;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoRepository;

@RooMongoRepository(domainType = UserConnection.class)
public interface UserConnectionRepository {

    List<in.mused.api.domain.UserConnection> findAll();
}
