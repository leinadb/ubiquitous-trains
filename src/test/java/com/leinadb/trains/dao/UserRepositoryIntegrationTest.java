package com.leinadb.trains.dao;

import com.leinadb.trains.model.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryIntegrationTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldReturnAllRolesThatGivenUserPossesses() {
        List<Role> danielRoles = userRepository.getUserRolesByUserId("1b21ca16-ea24-462d-84be-2d2eff35d168");
        List<Role> teroRoles = userRepository.getUserRolesByUserId("2d963138-2477-48fd-b8ae-1efc48c63358");

        assertThat(danielRoles.stream().map(role -> role.getName())).containsOnly("ROLE_USER");
        assertThat(teroRoles.stream().map(role -> role.getName())).containsOnly("ROLE_USER", "ROLE_SUPER_USER");
    }
}

