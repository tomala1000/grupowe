package org.sda.servlets.rest;

import org.sda.servlets.domain.User;
import org.sda.servlets.repository.UserRepository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/api")
@RestController
public class RestUserController {

    @Resource
    private UserRepository userRepository;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> findUsers() {
        return userRepository.findAll();
    }
}
