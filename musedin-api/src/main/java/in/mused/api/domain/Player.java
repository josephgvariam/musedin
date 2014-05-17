package in.mused.api.domain;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import in.mused.api.util.ObjectIdTransformer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoEntity;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooMongoEntity(identifierType = ObjectId.class)
@RooJson
public class Player {

    @NotNull
    @Column(unique = true)
    @Size(min = 5)
    private String code;

    @NotNull
    private boolean active;

    @NotNull
    private ObjectId userId;

    private Song nowPlayingSong;

    private boolean playing;
    
    @GeoSpatialIndexed
    private double[] location;
    
    private String name;
    private String description;
    
    private long lastActivityTime;
    private long lastPolledTime;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Song> playlistSongs = new HashSet<Song>();

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Activity> activities = new HashSet<Activity>();

    public String toJson() {
        JSONSerializer serializer = new JSONSerializer().transform(new ObjectIdTransformer(), org.bson.types.ObjectId.class);
        return serializer.exclude("*.class").serialize(this);
    }

    public static in.mused.api.domain.Player fromJsonToPlayer(String json) {
//    	try{
        return new JSONDeserializer<Player>().use(org.bson.types.ObjectId.class, new ObjectIdTransformer()).use(null, Player.class).deserialize(json);
//    	}catch(Exception e){
//    		e.printStackTrace();
//    		return null;
//    	}
    }

    public static String toJsonArray(Collection<in.mused.api.domain.Player> collection) {
        JSONSerializer serializer = new JSONSerializer().transform(new ObjectIdTransformer(), org.bson.types.ObjectId.class);
        return serializer.exclude("*.class").include("playlist").serialize(collection);
    }

    public static Collection<in.mused.api.domain.Player> fromJsonArrayToPlayers(String json) {
        return new JSONDeserializer<List<Player>>().use(null, ArrayList.class).use("values", Player.class).deserialize(json);
    }
}
