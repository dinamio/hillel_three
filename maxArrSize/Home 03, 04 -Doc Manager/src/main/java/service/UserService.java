package service;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> usersList = new ArrayList<>();

    public UserService() {
     User admin = new User("admin", "admin");
    }

    public void addUser(User user){
        usersList.add(user);
    }

    public void deleteUser(User user){
        if (checkRegisteredUsers(user)){
            usersList.remove(user);
        }
    }

    public boolean checkRegisteredUsers(User user) {
        boolean isUserExists = false;
        if ((user.getUserName() != null) && (user.getUserPass() != null)) {
            if ( (user.getUserName().equals("admin"))&& (user.getUserPass().equals("admin"))) {
                isUserExists = true;
            } else {
                for (User _user : usersList) {
                    if ((_user.getUserName() == user.getUserName()) && (_user.getUserPass() == user.getUserPass())) {
                        isUserExists = true;
                    }
                }
            }
        }
        return isUserExists;
    }
}
