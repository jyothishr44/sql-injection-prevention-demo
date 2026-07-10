package in.demo.SQLInjection.controller;

import in.demo.SQLInjection.model.User;
import in.demo.SQLInjection.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    private final UserService service;

    @PostMapping("/register")
    public String register(@RequestBody User user) {

        return service.register(user);
    }

    @PostMapping("/login-statement")
    public String loginStatement(@RequestBody User user) {

        return service.loginStatement(user);
    }

    @PostMapping("/login-prepared")
    public String loginPrepared(@RequestBody User user) {

        return service.loginPrepared(user);
    }

}
