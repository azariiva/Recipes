package recipes.businesslayer;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    void createUser(User user);

    boolean isUserExists(String email);
}
