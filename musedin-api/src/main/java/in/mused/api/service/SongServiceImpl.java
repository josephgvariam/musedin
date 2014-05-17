package in.mused.api.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Async;

import flexjson.JSONDeserializer;

import in.mused.api.domain.Song;


public class SongServiceImpl implements SongService {
	
	Logger log = LogManager.getLogger(SongServiceImpl.class);
	

}
