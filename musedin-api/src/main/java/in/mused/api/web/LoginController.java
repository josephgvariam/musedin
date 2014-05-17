package in.mused.api.web;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import flexjson.JSONSerializer;

@Controller
public class LoginController {

    @RequestMapping(value = "/signin/account", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> signinAccount() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        String json = new JSONSerializer().exclude("*.class", "description").serialize("OK");
        ResponseEntity<String> re = new ResponseEntity<String>(json, headers, HttpStatus.OK);
        return re;
    }
	
}
