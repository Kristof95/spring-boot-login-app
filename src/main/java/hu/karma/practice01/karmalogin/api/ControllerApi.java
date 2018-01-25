package hu.karma.practice01.karmalogin.api;


import hu.karma.practice01.karmalogin.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ControllerApi {

    @GetMapping("/")
    String test();

    @GetMapping("/admin")
    List<User> listUsers();

    @PostMapping("/register")
    ResponseEntity<User> register(@RequestBody User user);

    @PostMapping("/login")
    ResponseEntity<User> login(@RequestBody User user);

}
