package oscipovsky.lukas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @ResponseBody
    @GetMapping(value = "/test")
    public String test() {
        return "Authorized";
    }
}
