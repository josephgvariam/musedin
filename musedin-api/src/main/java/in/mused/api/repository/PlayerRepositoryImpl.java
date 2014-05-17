package in.mused.api.repository;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import in.mused.api.domain.Activity;
import in.mused.api.domain.Player;
import in.mused.api.domain.Song;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.geo.Distance;
import org.springframework.data.mongodb.core.geo.GeoResult;
import org.springframework.data.mongodb.core.geo.GeoResults;
import org.springframework.data.mongodb.core.geo.Metric;
import org.springframework.data.mongodb.core.geo.Metrics;
import org.springframework.data.mongodb.core.geo.Point;
import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Update.update;
import static org.springframework.data.mongodb.core.query.Query.query;

public class PlayerRepositoryImpl implements PlayerRepositoryCustom {

	Logger log = LogManager.getLogger(PlayerRepositoryImpl.class);
	
	@Autowired
    protected MongoTemplate mongoTemplate;
	
	public void pushPlaylistSong(ObjectId playerId, Song song){
		Update u = new Update()
			.push("playlistSongs", song);
			
		mongoTemplate.updateFirst(query(where("id").is(playerId)), u, Player.class);
	}
	
	public void pushActivity(ObjectId playerId, Activity activity){
		Update u = new Update()
		.push("activities", activity);
		
		mongoTemplate.updateFirst(query(where("id").is(playerId)), u, Player.class);
	}
	
	public void updatePlaylistSong(ObjectId playerId, Song song){
		Update u = update("playlistSongs.$.title", song.getTitle())
				.set("playlistSongs.$.artist", song.getArtist())
				.set("playlistSongs.$.album", song.getAlbum())
				.set("playlistSongs.$.year", song.getYear())
				.set("playlistSongs.$.genre", song.getGenre())
				.set("playlistSongs.$.comment", song.getComment())
				.set("playlistSongs.$.iconUrl", song.getIconUrl())
				.set("playlistSongs.$.upVotes", song.getUpVotes()) //use .inc in an other method
				.set("playlistSongs.$.downVotes", song.getDownVotes()); //use .inc
		
		mongoTemplate.updateFirst(query(where("id").is(playerId).and("playlistSongs.id").is(song.getId())), u, Player.class);
	}
	
	public void updatePlayerShallow(Player player){
		Update u = update("code", player.getCode())
				.set("active", player.isActive())
				.set("userId", player.getUserId())
				.set("nowPlayingSong", player.getNowPlayingSong())
				.set("playing", player.isPlaying());
				
		mongoTemplate.updateFirst(query(where("id").is(player.getId())), u, Player.class);
	}
	
	public Song findSong(ObjectId playerId, ObjectId songId){		
		Player player = mongoTemplate.findOne(query(where("id").is(playerId)),Player.class);
		
		for (Song song : player.getPlaylistSongs()) {
			if(song.getId().equals(songId)){
				return song;
			}
		}
		
		return null;
	}
	
	public void destroyPlaylistSong(ObjectId playerId, Song song){
		Update u = new Update()
		.pull("playlistSongs", song);
		mongoTemplate.updateFirst(query(where("id").is(playerId)), u, Player.class);
	}
	
	public List<Map> search(Map query){		
		try{
			List<Map> results = new ArrayList<Map>();
			
			String term = query.get("query").toString();
			double latitude = Double.parseDouble(query.get("latitude").toString());
			double longitude = Double.parseDouble(query.get("longitude").toString());
			double distance = Double.parseDouble(query.get("distance").toString());
			Metric metric =  query.get("metric").toString().equals("km")?Metrics.KILOMETERS:Metrics.MILES;
			
			Point location = new Point(latitude, longitude);
			NearQuery nearQuery = NearQuery.near(location).maxDistance(new Distance(distance, metric));

			GeoResults<Player> gResults= mongoTemplate.geoNear(nearQuery, Player.class);
			for (GeoResult<Player> geoResult : gResults) {
				Player p = geoResult.getContent();
				//log.info("Found. playerId: "+p.getId()+", playerName: "+p.getName()+", distance: "+geoResult.getDistance().toString());
				Map m = new HashMap();
				m.put("playerId", p.getId().toString());
				m.put("playerName", p.getName());
				m.put("playerDescription", p.getDescription());
				m.put("distanceString", getDistanceString(geoResult.getDistance()));
				m.put("distance", geoResult.getDistance().getValue());
				m.put("lastActivityTime", getLastTimeString(p.getLastActivityTime()));
				m.put("lastPolledTime", getLastTimeString(p.getLastPolledTime()));
				
				results.add(m);
			}
			
			return results;
		}catch(Exception e){
			return new ArrayList<Map>();
		}
	}
	
	private Object getLastTimeString(long time) {
		long elapsedMillis = new Date().getTime() - time;

		if (elapsedMillis < 60000) {
			double unit = round1(elapsedMillis / 1000.0);
			return unit + (unit == 1 ? " second" : " seconds");
		} else if (elapsedMillis < 60000 * 60) {
			double unit = round1(elapsedMillis / 60000.0);
			return unit + (unit == 1 ? " minute" : " minutes");
		} else if (elapsedMillis < 60000 * 60 * 24) {
			double unit = round1(elapsedMillis / (60000.0 * 60));
			return unit + (unit == 1 ? " hour" : " hours");
		} else {
			double unit = round1(elapsedMillis / (60000.0 * 60 * 24));
			return unit + (unit == 1 ? " day" : " days");
		}
	}
	
	private double round1(double value) {
		return Math.round(value * 10.0) / 10.0;
	}

	private String getDistanceString(Distance distance) {
		String result = "";
		
		DecimalFormat df = new DecimalFormat("#.##");
        result = df.format(distance.getValue());
        
        
        if (distance.getMetric() != Metrics.NEUTRAL) {
        	String unit = distance.getMetric().equals(Metrics.KILOMETERS)?"km":"mi";
			result = result + " " + unit;
		}
        
        return result;
	}

	public void updateLastActivityTime(ObjectId playerId){
		Update u = update("lastActivityTime", new Date().getTime());				
		mongoTemplate.updateFirst(query(where("id").is(playerId)), u, Player.class);
	}
	
	public void updateLastPolledTime(ObjectId playerId){
		Update u = update("lastPolledTime", new Date().getTime());				
		mongoTemplate.updateFirst(query(where("id").is(playerId)), u, Player.class);
	}	

}
