package com.leinadb.trains.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@Entity
public class Role {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @NotNull
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public String getName() {
        return name;
    }

    public Role(String id, String name, Set<User> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }

    public Role(){}

    @Override
    public boolean equals(Object object) {
        if (this == object) { return true; }
        if (!(object instanceof Role)) { return false; }
        Role role = (Role) object;
        return id.equals(role.id) && name.equals(role.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
