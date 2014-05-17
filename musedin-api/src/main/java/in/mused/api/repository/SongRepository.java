package in.mused.api.repository;

import in.mused.api.domain.Song;
import java.util.List;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoRepository;

@RooMongoRepository(domainType = Song.class)
public interface SongRepository {

    List<in.mused.api.domain.Song> findAll();
}
