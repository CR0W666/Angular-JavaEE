package cz.educanet.webik;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;

@SessionScoped
class AuthManager implements Serializable {

    @Inject
    private UsersManager userManager;

    private User loggedUser;

    public void login(User user) {

        User tempUser = userManager.getUserByName(user.getUsername());
        if(tempUser != null && tempUser.getPassword().equals(user.getPassword())) {
            loggedUser = tempUser;
        }

    }

    public boolean userState() {
        return loggedUser != null;
    }


    public User getLoggedUser() {
        System.out.println(loggedUser.toString());
        return loggedUser;
    }
}