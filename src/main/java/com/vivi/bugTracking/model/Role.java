package com.vivi.bugTracking.model;

import java.util.HashSet;
import java.util.Set;

public class Role {
    private int id;
    private String name;
    private Set<Permission> permissions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Permission> getPermissions() {
        if (permissions == null) {
            permissions = new HashSet<Permission>();
        }
        return permissions;
    }

    public void addPermission(Permission permission) {
        this.getPermissions().add(permission);
    }
}
