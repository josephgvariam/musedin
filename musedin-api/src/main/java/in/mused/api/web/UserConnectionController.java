package in.mused.api.web;

import in.mused.api.domain.UserConnection;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/userconnections")
@Controller
@RooWebScaffold(path = "userconnections", formBackingObject = UserConnection.class)
@RooWebJson(jsonObject = UserConnection.class)
public class UserConnectionController {
}
