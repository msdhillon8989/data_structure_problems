package MovieReview;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private static UserRepository repository;
    private Map<String, User> map = new HashMap<>();

    private UserRepository() {

    }

    public static UserRepository getInstance() {
        if (repository == null) {
            repository = new UserRepository();
        }
        return repository;

    }

    public User addUser(String name) {
        User user = new User(name);
        map.put(name, user);
        return user;
    }


    public User getUser(String name) {
        return map.get(name);
    }
}
