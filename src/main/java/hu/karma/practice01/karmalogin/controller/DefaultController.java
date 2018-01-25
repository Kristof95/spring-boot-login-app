package hu.karma.practice01.karmalogin.controller;

import hu.karma.practice01.karmalogin.api.ControllerApi;
import hu.karma.practice01.karmalogin.common.CommonUtil;
import hu.karma.practice01.karmalogin.model.User;
import hu.karma.practice01.karmalogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DefaultController implements ControllerApi {

    @Autowired
    private UserService userService;

    @Autowired
    private CommonUtil util;

    @Override
    public String test() {
        return "It's working!";
    }

    @Override
    public List<User> listUsers() {
        return userService.getAllUsers();
    }

    @Override
    public ResponseEntity<User> register(User user) {
        try {
            boolean isUserNotExist = userService.isUserNotExist(user.getUsername());
            if(isUserNotExist) {
                userService.addUser(user);
                return new ResponseEntity<>(user, HttpStatus.OK);
            } return new ResponseEntity<>(user, HttpStatus.CONFLICT);
        } catch(Exception e) {
            e.printStackTrace();
        } return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<User> login(User user) {
        try {
            User queriedUser = userService.findUserById(user.getId());
            if(queriedUser != null) {
                if(util.isPasswordEquals(queriedUser, user)) {
                    return new ResponseEntity<>(user, HttpStatus.OK);
                } return new ResponseEntity<>(user, HttpStatus.UNAUTHORIZED);
            }
        } catch(Exception e) {
            e.printStackTrace();
        } return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
    }
}
