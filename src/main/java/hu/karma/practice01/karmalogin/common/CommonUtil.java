package hu.karma.practice01.karmalogin.common;

import hu.karma.practice01.karmalogin.model.User;
import org.springframework.stereotype.Component;

@Component
public class CommonUtil {

    public boolean isPasswordEquals(User queriedUser, User user) {
        return queriedUser.getPassword().equals(user.getPassword());
    }
}
