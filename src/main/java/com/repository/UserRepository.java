package src.main.java.com.repository;

import java.util.HashMap;
import java.util.Map;
import src.main.java.com.model.User;

public class UserRepository implements IUserRepository{
    private final Map<String, User> users = new HashMap<>();

    @Override
    public boolean add(User user) {
        if (users.containsKey(user.getUsername())) {
            return false;
        }
        users.put(user.getUsername(), user);
        return true;
    }

    @Override
    public User get(String username) {
        return users.get(username);
    }
    
}