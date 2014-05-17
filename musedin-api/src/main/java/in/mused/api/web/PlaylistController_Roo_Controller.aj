// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package in.mused.api.web;

import in.mused.api.domain.Playlist;
import in.mused.api.service.PlaylistService;
import in.mused.api.service.SongService;
import in.mused.api.web.PlaylistController;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect PlaylistController_Roo_Controller {
    
    @Autowired
    PlaylistService PlaylistController.playlistService;
    
    @Autowired
    SongService PlaylistController.songService;
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String PlaylistController.create(@Valid Playlist playlist, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, playlist);
            return "playlists/create";
        }
        uiModel.asMap().clear();
        playlistService.savePlaylist(playlist);
        return "redirect:/playlists/" + encodeUrlPathSegment(playlist.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String PlaylistController.createForm(Model uiModel) {
        populateEditForm(uiModel, new Playlist());
        return "playlists/create";
    }
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String PlaylistController.show(@PathVariable("id") ObjectId id, Model uiModel) {
        uiModel.addAttribute("playlist", playlistService.findPlaylist(id));
        uiModel.addAttribute("itemId", id);
        return "playlists/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String PlaylistController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("playlists", playlistService.findPlaylistEntries(firstResult, sizeNo));
            float nrOfPages = (float) playlistService.countAllPlaylists() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("playlists", playlistService.findAllPlaylists());
        }
        return "playlists/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String PlaylistController.update(@Valid Playlist playlist, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, playlist);
            return "playlists/update";
        }
        uiModel.asMap().clear();
        playlistService.updatePlaylist(playlist);
        return "redirect:/playlists/" + encodeUrlPathSegment(playlist.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String PlaylistController.updateForm(@PathVariable("id") ObjectId id, Model uiModel) {
        populateEditForm(uiModel, playlistService.findPlaylist(id));
        return "playlists/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String PlaylistController.delete(@PathVariable("id") ObjectId id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Playlist playlist = playlistService.findPlaylist(id);
        playlistService.deletePlaylist(playlist);
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/playlists";
    }
    
    void PlaylistController.populateEditForm(Model uiModel, Playlist playlist) {
        uiModel.addAttribute("playlist", playlist);
        uiModel.addAttribute("songs", songService.findAllSongs());
    }
    
    String PlaylistController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        } catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
    
}