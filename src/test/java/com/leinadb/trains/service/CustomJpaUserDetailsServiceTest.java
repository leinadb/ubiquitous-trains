package com.leinadb.trains.service;

import com.leinadb.trains.dao.UserRepository;
import com.leinadb.trains.model.Role;
import com.leinadb.trains.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)
class CustomJpaUserDetailsServiceTest {

    public static final String NON_EXISTING_USER_NAME = "nonexiting_user";
    public static final String EXISTING_USER_NAME = "exiting_user";
    public static final String ROLE = "TESTING_ROLE";
    public static final String PASSWORD = "password";
    public static final String USER_UUID = "uuid";
    @Mock
    private UserRepository userRepository;

    private CustomJpaUserDetailsService userDetailsService;

    @BeforeEach
    public void setup() {
        userDetailsService = new CustomJpaUserDetailsService(userRepository);
    }

    @Test
    public void shouldLoadUserFromDatabaseAndCorrectlyMapItsDataToUserDetails() {
        User user = prepareUser();
        List<Role> userRoles = prepareUserRoles();
        Mockito.when(userRepository.findByName(eq(EXISTING_USER_NAME))).thenReturn(user);
        Mockito.when(userRepository.getUserRolesByUserId(eq(USER_UUID))).thenReturn(userRoles);

        UserDetails userDetails = userDetailsService.loadUserByUsername(EXISTING_USER_NAME);

        assertThat(userDetails.getUsername()).isEqualTo(EXISTING_USER_NAME);
        assertThat(userDetails.getPassword()).isEqualTo(PASSWORD);
        assertThat(userDetails.getAuthorities().stream().findFirst().get().getAuthority()).isEqualTo(ROLE);
    }

    @Test
    public void shouldThrowExceptionWithDescriptiveMessageWhenUserIsNotFound() {
        Mockito.when(userRepository.findByName(eq(NON_EXISTING_USER_NAME))).thenReturn(null);

        Throwable thrown = catchThrowable(() -> userDetailsService.loadUserByUsername(NON_EXISTING_USER_NAME));

        assertThat(thrown).isInstanceOf(UsernameNotFoundException.class)
                .hasMessageContaining("Could not find user:")
                .hasMessageContaining(NON_EXISTING_USER_NAME);
    }

    private User prepareUser() {
        return new User(USER_UUID, EXISTING_USER_NAME,PASSWORD,"email@email.com", "full name", new HashSet());
    }

    private List<Role> prepareUserRoles() {
        return Arrays.asList(new Role("uuid", ROLE, new HashSet()));
    }
}
