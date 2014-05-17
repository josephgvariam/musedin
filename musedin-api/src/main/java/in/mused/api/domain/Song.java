package in.mused.api.domain;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import in.mused.api.util.ObjectIdTransformer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.bson.types.ObjectId;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoEntity;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooMongoEntity(identifierType = ObjectId.class)
@RooJson
public class Song {
	
	@NotNull
	private String fileName;

    @NotNull
    private String title;

    private String artist;

    private String album;

    private String year;

    private String genre;

    private String comment;

    private String iconUrl;

    private int upVotes;

    private int downVotes;

    @NotNull
    private String songUrl;

	public String toJson() {
        //return new JSONSerializer().exclude("*.class").serialize(this);
        JSONSerializer serializer = new JSONSerializer().transform(new ObjectIdTransformer(), org.bson.types.ObjectId.class);
        return serializer.exclude("*.class").serialize(this);
    }

	public static Song fromJsonToSong(String json) {
        //return new JSONDeserializer<Song>().use(clazz, factory).use(null, Song.class).deserialize(json);
    	return new JSONDeserializer<Song>().use(org.bson.types.ObjectId.class, new ObjectIdTransformer()).use(null, Song.class).deserialize(json);
    }

	public static String toJsonArray(Collection<Song> collection) {
        return new JSONSerializer().exclude("*.class").serialize(collection);
    }

	public static Collection<Song> fromJsonArrayToSongs(String json) {
        return new JSONDeserializer<List<Song>>().use(null, ArrayList.class).use("values", Song.class).deserialize(json);
    }
}
