package com.leinadb.trains.dao;

import com.leinadb.trains.model.Role;
import com.leinadb.trains.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail(String email);

    User findByName(String name);

    @Query("SELECT user.roles FROM User user WHERE user.id = :id")
    public List<Role> getUserRolesByUserId(@Param("id") String id);
}
