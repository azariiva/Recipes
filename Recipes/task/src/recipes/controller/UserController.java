package recipes.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import recipes.businesslayer.User;

import javax.validation.Valid;

@RequestMapping(path = "/api")
public interface UserController {

    @RequestMapping(path = "/register")
    @ResponseStatus(HttpStatus.OK)
    void registerUser(@RequestBody @Valid User user);
}
