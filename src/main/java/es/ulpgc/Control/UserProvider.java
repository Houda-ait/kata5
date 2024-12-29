package es.ulpgc.Control;

import es.ulpgc.Model.User;

import java.io.IOException;

public interface UserProvider {
    User provideNewUser() throws IOException;

}
