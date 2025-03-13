package src.java.com.repository;

import src.java.com.model.User;

public interface IUserRepository {
    boolean add(User user);
    User get(String username);
}