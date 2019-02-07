package model;


public class User {
    private int id;
    private String name;
    private String pass;

    public User(){

    }

    public User(String name,String userPass){
        this.name = name;
        this.name = pass;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){ return id;}

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setPass(String pass){
        this.pass = pass;
    }

    public String getPass(){
        return pass;
    }
}
