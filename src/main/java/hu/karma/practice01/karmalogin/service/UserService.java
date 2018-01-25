package hu.karma.practice01.karmalogin.service;

import hu.karma.practice01.karmalogin.model.User;
import hu.karma.practice01.karmalogin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public boolean isUserNotExist(String username) {
        return userRepository.findByUsername(username) != null;
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public User findUserById(int id) {
        return userRepository.findById(id);
    }
}
