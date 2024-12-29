package es.ulpgc.Control;

import com.google.gson.Gson;
import es.ulpgc.Model.User;
import es.ulpgc.RandomUserResponse;
import org.jsoup.Jsoup;

import java.io.IOException;

public class RandomUserProvider implements UserProvider{
    private static final String RANDOM_USER_URL = "https://randomuser.me/api";
    @Override
    public User provideNewUser() throws IOException {
        String text = Jsoup.connect(RANDOM_USER_URL).ignoreContentType(true).get().text();
        RandomUserResponse response = new Gson().fromJson(text, RandomUserResponse.class);
        return new RandomUserAdapter().adapt(response);
    }
}
