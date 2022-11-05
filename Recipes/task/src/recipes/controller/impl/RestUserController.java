package recipes.controller.impl;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import recipes.businesslayer.User;
import recipes.businesslayer.UserService;
import recipes.controller.UserController;

@RestController
public class RestUserController implements UserController {

    private final UserService userService;

    public RestUserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void registerUser(User user) {
        if (userService.isUserExists(user.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        userService.createUser(user);
    }
}
