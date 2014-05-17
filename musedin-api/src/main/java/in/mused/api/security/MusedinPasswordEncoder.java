package in.mused.api.security;

import in.mused.api.service.SecurityService;
import in.mused.api.service.SecurityServiceImpl;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.crypto.codec.Utf8;

public class MusedinPasswordEncoder implements PasswordEncoder{
	
	@Autowired
	SecurityService securityService;
	
	Logger log = LogManager.getLogger(MusedinPasswordEncoder.class);

	@Override
	public String encodePassword(String rawPass, Object salt) {
		log.debug("rawPass: "+rawPass+" salt: "+salt);
		String encPass = securityService.encodePassword(salt.toString(), "musedin", rawPass);
		log.debug("encoded: "+encPass);
		return encPass;
	}

	@Override
	public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
		log.debug("encPass: "+encPass+" rawPass: "+rawPass+" salt: "+salt);
        String pass1 = "" + encPass;
        String pass2 = encodePassword(rawPass, salt);

        log.debug("comparing passwords. pass1: "+pass1+" pass2: "+pass2);
        
        return equals(pass1,pass2);
	}
	
    private boolean equals(String expected, String actual) {
        byte[] expectedBytes = bytesUtf8(expected);
        byte[] actualBytes = bytesUtf8(actual);
        int expectedLength = expectedBytes == null ? -1 : expectedBytes.length;
        int actualLength = actualBytes == null ? -1 : actualBytes.length;
        if (expectedLength != actualLength) {
            return false;
        }

        int result = 0;
        for (int i = 0; i < expectedLength; i++) {
            result |= expectedBytes[i] ^ actualBytes[i];
        }
        return result == 0;
    }
    
    private byte[] bytesUtf8(String s) {
        if(s == null) {
            return null;
        }

        return Utf8.encode(s);
    }

}
