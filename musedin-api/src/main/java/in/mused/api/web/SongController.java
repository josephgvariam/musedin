package in.mused.api.web;

import in.mused.api.domain.Song;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/songs")
@Controller
@RooWebScaffold(path = "songs", formBackingObject = Song.class)
@RooWebJson(jsonObject = Song.class)
public class SongController {
}
