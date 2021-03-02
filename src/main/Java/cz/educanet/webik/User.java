package cz.educanet.webik;

public class User {
    public String username, password, gender;
    private int id;

    public String getUserName() {
        return username;
    }
    public void setUserName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public int getID() {
        return id;
    }
    public void setID(int id) {
         this.id = id;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    




}

