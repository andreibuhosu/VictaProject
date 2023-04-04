package com.victa.victawebsite.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Roles {
    @Id
    @GeneratedValue
    private int ID;
    private String Role;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<User> users;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "ID=" + ID +
                ", Role='" + Role + '\'' +
                '}';
    }
}
