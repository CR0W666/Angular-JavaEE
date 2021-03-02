package cz.educanet.webik;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UsersManager {

    private ArrayList<User> userList = new ArrayList<>();

    public ArrayList<User> getAllUserNames(){
        return userList;
    }

    public boolean createUser(User user) {
        user.setID(userList.size());
        return userList.add(user);
    }

    public User getUserName(int id){
        return userList.stream()
                .filter(userListStream -> id == userListStream.getID())
                .findAny()
                .orElse(null);
    }

    public boolean removeUserName(int id){
        return  userList.remove(getUserName(id));
    }

}
