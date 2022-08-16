package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin(origins = "https://gateway.marvel.com/*")
@RequestMapping("/user")
@PreAuthorize("isAuthenticated()")
public class UserController {

    private UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(path="/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable int id, Principal principal) {
        return userDao.getUserById(id);
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(path = "/get/id", method = RequestMethod.GET)
    public int getUserId(Principal principal) {
        if (principal != null) {
            return userDao.findIdByUsername(principal.getName());
        }
        return 0;
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(path = "/get/id/{name}", method = RequestMethod.GET)
    public int getUserIdByName(@PathVariable String name, Principal principal) {
        return userDao.findIdByUsername(name);
    }

}
