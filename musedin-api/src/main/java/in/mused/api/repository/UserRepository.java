package in.mused.api.repository;

import in.mused.api.domain.User;
import java.util.List;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoRepository;

@RooMongoRepository(domainType = User.class)
public interface UserRepository {

    List<User> findAll();
    User findByEmail(String email);
    User findByUsername(String email);
}
