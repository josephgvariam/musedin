// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package in.mused.api.web;

import in.mused.api.domain.Song;
import in.mused.api.service.SongService;
import in.mused.api.web.SongController;
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

privileged aspect SongController_Roo_Controller {
    
    @Autowired
    SongService SongController.songService;
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String SongController.create(@Valid Song song, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, song);
            return "songs/create";
        }
        uiModel.asMap().clear();
        songService.saveSong(song);
        return "redirect:/songs/" + encodeUrlPathSegment(song.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String SongController.createForm(Model uiModel) {
        populateEditForm(uiModel, new Song());
        return "songs/create";
    }
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String SongController.show(@PathVariable("id") ObjectId id, Model uiModel) {
        uiModel.addAttribute("song", songService.findSong(id));
        uiModel.addAttribute("itemId", id);
        return "songs/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String SongController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("songs", songService.findSongEntries(firstResult, sizeNo));
            float nrOfPages = (float) songService.countAllSongs() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("songs", songService.findAllSongs());
        }
        return "songs/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String SongController.update(@Valid Song song, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, song);
            return "songs/update";
        }
        uiModel.asMap().clear();
        songService.updateSong(song);
        return "redirect:/songs/" + encodeUrlPathSegment(song.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String SongController.updateForm(@PathVariable("id") ObjectId id, Model uiModel) {
        populateEditForm(uiModel, songService.findSong(id));
        return "songs/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String SongController.delete(@PathVariable("id") ObjectId id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Song song = songService.findSong(id);
        songService.deleteSong(song);
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/songs";
    }
    
    void SongController.populateEditForm(Model uiModel, Song song) {
        uiModel.addAttribute("song", song);
    }
    
    String SongController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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
