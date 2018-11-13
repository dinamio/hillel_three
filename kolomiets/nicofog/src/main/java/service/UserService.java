package service;

import dao.mysql.UserRepository;
import entity.User;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by mihail on 11/10/18.
 */
public class UserService {

    private UserRepository userRepository;
    private String resultMessage;

    public void addUser(User user) {
        userRepository = new UserRepository();

        user.setRole("user");
        user.setDateRegistration(LocalDateTime.now().toString());
        user = userRepository.add(user);
        
        if (user == null) {
            resultMessage = "Can't add user";
        } else {
            resultMessage = user.getName() + " added success";
        }
    }

    public List<User> getAll() {
        userRepository = new UserRepository();
        return userRepository.getAll();
    }

    public User getById(long id) {
        return new UserRepository().getById(id);
    }

    public void update(User user) {
        resultMessage = new UserRepository().update(user) == null ?
                "User " + user.getName() + " can't update" :
                "User " + user.getName() + " success updated";
    }

    public User getByName(String name) {
        return new UserRepository().getByName(name);
    }

    public void delete(long id) {
        userRepository = new UserRepository();
        resultMessage = userRepository.deleteById(id) ? "User deleted" : "User cant delete";
    }

    public String getResultMessage() {
        return resultMessage;
    }
}
