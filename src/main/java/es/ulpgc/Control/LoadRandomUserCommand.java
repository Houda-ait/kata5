package es.ulpgc.Control;

import es.ulpgc.Model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadRandomUserCommand implements Command{

    private final int count;

    private final List<User> users = new ArrayList<>();

    public LoadRandomUserCommand(int count) {
        this.count = count;
    }

    @Override
    public void execute() {
        users.clear();
        RandomUserProvider provider = new RandomUserProvider();
        for(int i= 0 ; i<count; i++){
            try {
                users.add(provider.provideNewUser());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<User> getUsers() {
        return users;
    }
}
