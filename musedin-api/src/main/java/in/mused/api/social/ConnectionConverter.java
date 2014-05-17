package in.mused.api.social;

import in.mused.api.domain.UserConnection;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionData;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.stereotype.Component;

/**
 * A converter class between Mongo document and
 * Spring social connection.
 */
//@Component
public class ConnectionConverter {
	private final ConnectionFactoryLocator connectionFactoryLocator;
	private final TextEncryptor textEncryptor;
	
	Logger log = LogManager.getLogger(ConnectionConverter.class);

	@Autowired
	public ConnectionConverter(ConnectionFactoryLocator connectionFactoryLocator,
		TextEncryptor textEncryptor) {
	
		this.connectionFactoryLocator = connectionFactoryLocator;
		this.textEncryptor = textEncryptor;
	}
	
	public Connection<?> convert(UserConnection cnn) {
		if (cnn==null) return null;
		
		ConnectionData connectionData = fillConnectionData(cnn);
		ConnectionFactory<?> connectionFactory = connectionFactoryLocator.getConnectionFactory(connectionData.getProviderId());
		return connectionFactory.createConnection(connectionData);
	}
	
	private ConnectionData fillConnectionData(UserConnection uc) {
		return new ConnectionData(uc.getProviderId(),
			uc.getProviderUserId(),
			uc.getDisplayName(),
			uc.getProfileUrl(),
			uc.getImageUrl(),
			decrypt(uc.getAccessToken()),
			decrypt(uc.getSecret()),
			decrypt(uc.getRefreshToken()),
			uc.getExpireTime());
	}
	
	public UserConnection convert(Connection<?> cnn) {
		ConnectionData data = cnn.createData();
		
		UserConnection userConn = new UserConnection();
		userConn.setProviderId(data.getProviderId());
		userConn.setProviderUserId(data.getProviderUserId());
		userConn.setDisplayName(data.getDisplayName());
		userConn.setProfileUrl(data.getProfileUrl());
		userConn.setImageUrl(data.getImageUrl());
		userConn.setAccessToken(encrypt(data.getAccessToken()));
		userConn.setSecret(encrypt(data.getSecret()));
		userConn.setRefreshToken(encrypt(data.getRefreshToken()));
		userConn.setExpireTime(data.getExpireTime());
		return userConn;
	}
	
	// helper methods
	
	private String decrypt(String encryptedText) {
		return encryptedText != null ? textEncryptor.decrypt(encryptedText) : encryptedText;
	}

	private String encrypt(String text) {
		return text != null ? textEncryptor.encrypt(text) : text;
	}
}