package model;

public class User {
    private String userName;
    private String userPass;

    public User(){

    }

    public User(String userName,String userPass){
        this.userName = userName;
        this.userPass = userPass;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserPass(String userPass){
        this.userPass = userPass;
    }

    public String getUserPass(){
        return userPass;
    }
}
