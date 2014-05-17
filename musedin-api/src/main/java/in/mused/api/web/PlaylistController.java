package in.mused.api.web;

import in.mused.api.domain.Playlist;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/playlists")
@Controller
@RooWebScaffold(path = "playlists", formBackingObject = Playlist.class)
@RooWebJson(jsonObject = Playlist.class)
public class PlaylistController {
}
