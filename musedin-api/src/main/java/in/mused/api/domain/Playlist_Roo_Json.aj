// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package in.mused.api.domain;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import in.mused.api.domain.Playlist;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

privileged aspect Playlist_Roo_Json {
    
    public String Playlist.toJson() {
        return new JSONSerializer().exclude("*.class").serialize(this);
    }
    
    public static Playlist Playlist.fromJsonToPlaylist(String json) {
        return new JSONDeserializer<Playlist>().use(null, Playlist.class).deserialize(json);
    }
    
    public static String Playlist.toJsonArray(Collection<Playlist> collection) {
        return new JSONSerializer().exclude("*.class").serialize(collection);
    }
    
    public static Collection<Playlist> Playlist.fromJsonArrayToPlaylists(String json) {
        return new JSONDeserializer<List<Playlist>>().use(null, ArrayList.class).use("values", Playlist.class).deserialize(json);
    }
    
}
