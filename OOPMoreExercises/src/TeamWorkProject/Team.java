package TeamWorkProject;

import java.util.List;

public class Team {
    List<User> users;
    String name;

    Team(List<User> users, String name){
        this.users = users;
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public String getName() {
        return name;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
