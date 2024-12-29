package es.ulpgc;

import java.io.IOException;

public interface UserProvider {
    User provideNewUser() throws IOException;

}
