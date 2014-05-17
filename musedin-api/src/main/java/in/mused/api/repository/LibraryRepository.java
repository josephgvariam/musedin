package in.mused.api.repository;

import in.mused.api.domain.Library;
import java.util.List;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoRepository;

@RooMongoRepository(domainType = Library.class)
public interface LibraryRepository {

    List<in.mused.api.domain.Library> findAll();
}
