package org.sda.servlets.controller;

import org.sda.servlets.domain.User;
import org.sda.servlets.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class HelloController {

    @Resource
    private UserRepository userRepository;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "hello";
    }

    @RequestMapping(value = "/registerPage", method = RequestMethod.GET)
    public String registerPage(ModelMap model) {
        return "registerUser";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String register(@Validated @ModelAttribute User user, BindingResult bindingResult,
                           @RequestParam("password") String passwordParam, ModelMap model) {
        if (bindingResult.hasErrors()) {
//            bindingResult.getAllErrors();
            return "error";
        }
        userRepository.save(user, passwordParam);

        model.put("usersList", userRepository.findAll());
        return "userTable";
    }

}
