// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package in.mused.api.domain;

import in.mused.api.domain.Playlist;
import in.mused.api.domain.Song;
import java.util.Set;

privileged aspect Playlist_Roo_JavaBean {
    
    public Set<Song> Playlist.getSongs() {
        return this.songs;
    }
    
    public void Playlist.setSongs(Set<Song> songs) {
        this.songs = songs;
    }
    
}
