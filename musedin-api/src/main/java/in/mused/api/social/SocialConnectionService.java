package in.mused.api.social;

import in.mused.api.domain.UserConnection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.util.MultiValueMap;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Order;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.WriteConcern;

import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.Criteria.*;

/**
 * A service for the spring connections management using Mongodb.
 *
 * @author Carlo P. Micieli
 */
@Service
public class SocialConnectionService implements ConnectionService {

	private final MongoTemplate mongoTemplate;
	private final ConnectionConverter converter;
	
	Logger log = LogManager.getLogger(SocialConnectionService.class);
	
	@Autowired
	public SocialConnectionService(MongoTemplate mongoTemplate, ConnectionConverter converter) {
		this.mongoTemplate = mongoTemplate;
		this.converter = converter;
	}
		
	/**
	 * Returns the max connection rank for the user and the provider.
	 * 
	 * @see org.springframework.social.connect.mongo.ConnectionService#getMaxRank(java.lang.String, java.lang.String)
	 */
	@Override
	public int getMaxRank(String userId, String providerId) { 
		// select coalesce(max(rank) + 1, 1) as rank from UserConnection where userId = ? and providerId = ?
		Query q = query(where("userId").is(userId).and("providerId").is(providerId));
		q.sort().on("rank", Order.DESCENDING);
		UserConnection cnn = mongoTemplate.findOne(q, UserConnection.class);
		
		if (cnn==null)
			return 1;
		
		return cnn.getRank() + 1;
	}
	
	/**
	 * Create a new connection for the user.
	 * 
	 * @see org.springframework.social.connect.mongo.ConnectionService#create(java.lang.String, org.springframework.social.connect.Connection, int)
	 */
	@Override
	public void create(String userId, Connection<?> userConn, int rank) {
		UserConnection mongoCnn = converter.convert(userConn);
		mongoCnn.setUserId(userId);
		mongoCnn.setRank(rank);
		mongoTemplate.insert(mongoCnn);
	}
	
	/**
	 * Update a connection.
	 * 
	 * @see org.springframework.social.connect.mongo.ConnectionService#update(java.lang.String, org.springframework.social.connect.Connection)
	 */
	@Override
	public void update(String userId, Connection<?> userConn) {
		UserConnection mongoCnn = converter.convert(userConn);
		mongoCnn.setUserId(userId);
		try {
			mongoTemplate.setWriteConcern(WriteConcern.SAFE);
			mongoTemplate.save(mongoCnn); 
		} catch (DuplicateKeyException e) {
			Query q = query(where("userId").is(userId).and("providerId").is(mongoCnn.getProviderId())
					.and("providerUserId").is(mongoCnn.getProviderUserId()));
			
			Update update = Update.update("expireTime", mongoCnn.getExpireTime())
					.set("accessToken", mongoCnn.getAccessToken())
					.set("profileUrl", mongoCnn.getProfileUrl())
					.set("imageUrl", mongoCnn.getImageUrl())
					.set("displayName", mongoCnn.getDisplayName());
			
			mongoTemplate.findAndModify(q, update, UserConnection.class);
		}
	}
	
	/**
	 * Remove a connection.
	 * 
	 * @see org.springframework.social.connect.mongo.ConnectionService#remove(java.lang.String, org.springframework.social.connect.ConnectionKey)
	 */
	@Override
	public void remove(String userId, ConnectionKey connectionKey) {
		//delete where userId = ? and providerId = ? and providerUserId = ?
		Query q = query(where("userId").is(userId)
				.and("providerId").is(connectionKey.getProviderId())
				.and("providerUserId").is(connectionKey.getProviderUserId()));
		mongoTemplate.remove(q, UserConnection.class);		
	}
	
	/**
	 * Remove all the connections for a user on a provider.
	 * 
	 * @see org.springframework.social.connect.mongo.ConnectionService#remove(java.lang.String, java.lang.String)
	 */
	@Override
	public void remove(String userId, String providerId) {
		// delete where userId = ? and providerId = ?
		Query q = query(where("userId").is(userId)
				.and("providerId").is(providerId));
				
		mongoTemplate.remove(q, UserConnection.class);
	}
	
	/**
	 * Return the primary connection.
	 * 
	 * @see org.springframework.social.connect.mongo.ConnectionService#getPrimaryConnection(java.lang.String, java.lang.String)
	 */
	@Override
	public Connection<?> getPrimaryConnection(String userId, String providerId) {
		// where userId = ? and providerId = ? and rank = 1
		Query q = query(where("userId").is(userId).
				and("providerId").is(providerId).
				and("rank").is(1));
		
		UserConnection mc = mongoTemplate.findOne(q, UserConnection.class);
		return converter.convert(mc);
	}
	
	/**
	 * Get the connection for user, provider and provider user id.
	 * 
	 * @see org.springframework.social.connect.mongo.ConnectionService#getConnection(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Connection<?> getConnection(String userId, String providerId, String providerUserId) {
		// where userId = ? and providerId = ? and providerUserId = ?
		Query q = query(where("userId").is(userId)
				.and("providerId").is(providerId)
				.and("providerUserId").is(providerUserId));
					
		UserConnection mc = mongoTemplate.findOne(q, UserConnection.class);
		return converter.convert(mc);
	}
	
	/**
	 * Get all the connections for an user id.
	 * 
	 * @see org.springframework.social.connect.mongo.ConnectionService#getConnections(java.lang.String)
	 */
	@Override
	public List<Connection<?>> getConnections(String userId) {
		// select where userId = ? order by providerId, rank
		Query q = query(where("userId").is(userId));
		q.sort().on("providerId", Order.ASCENDING).on("rank", Order.ASCENDING);
		
		return runQuery(q);
	}
	
	/**
	 * Get all the connections for an user id on a provider.
	 * 
	 * @see org.springframework.social.connect.mongo.ConnectionService#getConnections(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Connection<?>> getConnections(String userId, String providerId) {
		// where userId = ? and providerId = ? order by rank
		Query q = new Query(where("userId").is(userId).and("providerId").is(providerId));
		q.sort().on("rank", Order.ASCENDING);
		
		return runQuery(q);
	}
	
	/**
	 * Get all the connections for an user.
	 * 
	 * @see org.springframework.social.connect.mongo.ConnectionService#getConnections(java.lang.String, org.springframework.util.MultiValueMap)
	 */
	@Override
	public List<Connection<?>> getConnections(String userId, MultiValueMap<String, String> providerUsers) {
		// userId? and providerId = ? and providerUserId in (?, ?, ...) order by providerId, rank
		
		if (providerUsers == null || providerUsers.isEmpty()) {
			throw new IllegalArgumentException("Unable to execute find: no providerUsers provided");
		}
		
		List<Criteria> lc = new ArrayList<Criteria>();
		for (Entry<String, List<String>> entry : providerUsers.entrySet()) {
			String providerId = entry.getKey();
			
			lc.add(where("providerId").is(providerId)
				.and("providerUserId").in(entry.getValue()));
		}
		
		Criteria criteria = where("userId").is(userId);
		criteria.orOperator(lc.toArray(new Criteria[lc.size()]));
		
		Query q = new Query(criteria);
		q.sort().on("providerId", Order.ASCENDING).on("rank", Order.ASCENDING);
		
		return runQuery(q);
	}

	/**
	 * Get the user ids on the provider.
	 * 
	 * @see org.springframework.social.connect.mongo.ConnectionService#getUserIds(java.lang.String, java.util.Set)
	 */
	@Override
	public Set<String> getUserIds(String providerId, Set<String> providerUserIds) {
		//select userId from " + tablePrefix + "UserConnection where providerId = :providerId and providerUserId in (:providerUserIds)
		Query q = query(where("providerId").is(providerId)
				.and("providerUserId").in(new ArrayList<String>(providerUserIds)));
		q.fields().include("userId");
		
		List<UserConnection> results = mongoTemplate.find(q, UserConnection.class);
		Set<String> userIds = new HashSet<String>();
		for (UserConnection mc : results) {
			userIds.add(mc.getUserId());
		}
		
		return userIds;
	}
	
	/**
	 * Get the user ids on the provider with a given provider user id.
	 * 
	 * @see org.springframework.social.connect.mongo.ConnectionService#getUserIds(java.lang.String, java.lang.String)
	 */
	@Override
	public List<String> getUserIds(String providerId, String providerUserId) {
		 //select userId where providerId = ? and providerUserId = ?", 		
		Query q = query(where("providerId").is(providerId)
				.and("providerUserId").is(providerUserId));
		q.fields().include("userId");
		
		List<UserConnection> results = mongoTemplate.find(q, UserConnection.class);
		List<String> userIds = new ArrayList<String>();
		for (UserConnection mc : results) {
			userIds.add(mc.getUserId());
		}
		
		return userIds;
	}
	
	// helper methods
	
	private List<Connection<?>> runQuery(Query query) {
		List<UserConnection> results = mongoTemplate.find(query, UserConnection.class);
		List<Connection<?>> l = new ArrayList<Connection<?>>();
		for (UserConnection mc : results) {
			l.add(converter.convert(mc));
		}
		
		return l;
	}
}