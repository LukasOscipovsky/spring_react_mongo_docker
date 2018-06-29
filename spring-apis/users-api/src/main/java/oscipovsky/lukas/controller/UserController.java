package oscipovsky.lukas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import oscipovsky.lukas.dto.UserRequest;
import oscipovsky.lukas.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/signup")
    public void signup(@RequestBody UserRequest user) {
        userService.save(user);
    }
}
