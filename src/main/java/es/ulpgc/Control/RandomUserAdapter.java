package es.ulpgc.Control;

import es.ulpgc.Model.User;
import es.ulpgc.RandomUser;
import es.ulpgc.RandomUserResponse;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLConnection;

public class RandomUserAdapter implements UserAdapter<RandomUserResponse>{

    @Override
    public User adapt(RandomUserResponse randomUserResponse) {
        RandomUser randomUser = randomUserResponse.getResults().getFirst();
        User user = adapt(randomUser);
        user.setPhoto(downloadPhoto(randomUser.getPicture().medium()));
        return user;
    }

    private byte[] downloadPhoto(String url) {
        try {
            URLConnection conn = new URI(url).toURL().openConnection();
            return conn.getInputStream().readAllBytes();
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private static User adapt(RandomUser randomUser) {
        User user = new User(randomUser.getName().first(),
                randomUser.getName().last(),
                randomUser.getEmail(),
                User.Gender.valueOf(firstUpperCase(randomUser.getGender())));
        return user;
    }

    private static String firstUpperCase(String value) {
        return value.substring(0,1).toUpperCase() +value.substring(1);
    }
}
