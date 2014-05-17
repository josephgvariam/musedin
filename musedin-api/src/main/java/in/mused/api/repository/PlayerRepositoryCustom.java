package in.mused.api.repository;

import java.util.List;
import java.util.Map;

import in.mused.api.domain.Activity;
import in.mused.api.domain.Player;
import in.mused.api.domain.Song;

import org.bson.types.ObjectId;

public interface PlayerRepositoryCustom {
	public void pushPlaylistSong(ObjectId playerId, Song song);
	public void updatePlaylistSong(ObjectId playerId, Song song);
	public void updatePlayerShallow(Player player);
	public void destroyPlaylistSong(ObjectId playerId, Song song);
	public void pushActivity(ObjectId playerId, Activity activity);
	public Song findSong(ObjectId playerId, ObjectId songId);
	public List<Map> search(Map query);
	public void updateLastActivityTime(ObjectId playerId);
	public void updateLastPolledTime(ObjectId playerId);
}
