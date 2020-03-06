package com.leinadb.trains.controller;

import com.leinadb.trains.dao.UserRepository;
import com.leinadb.trains.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserResource {

    private final UserRepository repository;

    public UserResource(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/user/oauth")
    public Map<String, Object> getUserInfoFromOauth(@AuthenticationPrincipal OAuth2User principal) {
        Map<String, Object> infoByAttribute = new HashMap<>();
        infoByAttribute.put("login", principal.getAttribute("login"));
        infoByAttribute.put("name", principal.getAttribute("name"));
        infoByAttribute.put("email", principal.getAttribute("email"));
        return infoByAttribute;
    }

    @GetMapping("/user")
    public Map<String, Object> getUserInfoFromWeb(Principal principal) {
        User user = repository.findByName(principal.getName());
        Map<String, Object> infoByAttribute = new HashMap<>();
        infoByAttribute.put("login", user.getName());
        infoByAttribute.put("name", user.getFullName());
        infoByAttribute.put("email", user.getEmail());
        return infoByAttribute;
    }
}
