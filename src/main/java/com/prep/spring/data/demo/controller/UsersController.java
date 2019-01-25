package com.prep.spring.data.demo.controller;

import com.prep.spring.data.demo.model.Users;
import com.prep.spring.data.demo.repository.UserJpaRespository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UsersController {

    private UserJpaRespository userJpaRespository;

    public UsersController(UserJpaRespository userJpaRespository) {
        this.userJpaRespository = userJpaRespository;
    }

    @GetMapping(value = "/all")
    public List<Users> findAll() {
        SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        return userJpaRespository.findAll();
    }

    @GetMapping(value = "/{name}")
    public Users findByName(@PathVariable final String name) {
        return userJpaRespository.findByName(name);
    }

    @PostMapping(value = "/load")
    public Users load(@RequestBody final Users users) {
        userJpaRespository.save(users);
        return userJpaRespository.findByName(users.getName());
    }

    @GetMapping(value = "/allString")
    public List<Users> findAllRequestParam(@RequestParam Map<String, String> queryString) {
        queryString.forEach((key, value) -> {
            System.out.println("Key : " + key + " Value : " + value);
        });
        return userJpaRespository.findAll();
    }

}
