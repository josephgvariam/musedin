package in.mused.api.web;

import in.mused.api.domain.Library;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/librarys")
@Controller
@RooWebScaffold(path = "librarys", formBackingObject = Library.class)
@RooWebJson(jsonObject = Library.class)
public class LibraryController {
}
