package com.leinadb.trains.service;

import com.leinadb.trains.dao.UserRepository;
import com.leinadb.trains.model.Role;
import com.leinadb.trains.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Component
public class CustomJpaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomJpaUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByName(username);
        if (user == null) { throw new UsernameNotFoundException(format("Could not find user: %s", username)); }

        List<Role> userRoles = userRepository.getUserRolesByUserId(user.getId());
        Collection<? extends GrantedAuthority> grantedAuthorities = getUserGrantedAuthorities(userRoles);

        return new org.springframework.security.core.userdetails.User(user.getName(),
                user.getPassword(),
                grantedAuthorities);
    }

    private Collection<? extends GrantedAuthority> getUserGrantedAuthorities(List<Role> userRoles) {
        return userRoles
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
