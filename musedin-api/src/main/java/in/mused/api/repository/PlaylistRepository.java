package in.mused.api.repository;

import in.mused.api.domain.Playlist;
import java.util.List;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoRepository;

@RooMongoRepository(domainType = Playlist.class)
public interface PlaylistRepository {

    List<in.mused.api.domain.Playlist> findAll();
}
