package service;

import dao.mysql.UserRepository;
import entity.Cigarette;
import entity.User;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by mihail on 11/10/18.
 */
public class UserService {

    private UserRepository userRepository;
    private String resultMessage;

    public UserService() {
        userRepository = new UserRepository();
    }

    /**
     * Bridge with controller and repository
     * Check by user exist, if issue -> null
     */
    public User addUser(User user) {

        user.setRole("user");
        user.setDateRegistration(LocalDateTime.now().toString());
        if (userRepository.getByName(user.getName()) == null) {
            user = userRepository.add(user);
        } else {
            resultMessage = "user " + user.getName() + " is exist";
            return null;
        }

        if (user == null) {
            resultMessage = "Can't add user";
        } else {
            resultMessage = user.getName() + " added success";
        }

        return user;
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public User getById(long id) {
        return userRepository.getById(id);
    }

    public User update(User user) {
        user = userRepository.update(user);
        resultMessage = user == null ?
                "User null can't update" :
                "User " + user.getName() + " success updated";
        return user;
    }

    public User getByName(String name) {
        return userRepository.getByName(name);
    }

    public void delete(long id) {
        resultMessage = userRepository.deleteById(id) ? "User deleted" : "User cant delete";
    }

    public String getResultMessage() {
        return resultMessage;
    }
}
