package src.main.java.com.repository;

import src.main.java.com.model.User;

public interface IUserRepository {
    boolean add(User user);
    User get(String username);
}