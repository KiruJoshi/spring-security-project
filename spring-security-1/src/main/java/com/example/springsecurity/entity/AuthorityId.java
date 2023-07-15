package com.example.springsecurity.entity;

import java.io.Serializable;
import java.util.Objects;

public class AuthorityId implements Serializable {
    private Users users;
    private String authority;

    public AuthorityId() {
        // Default constructor
    }

    public AuthorityId(Users users, String authority) {
        this.users = users;
        this.authority = authority;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorityId that = (AuthorityId) o;
        return Objects.equals(users, that.users) &&
                Objects.equals(authority, that.authority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users, authority);
    }

	@Override
	public String toString() {
		return "AuthorityId [users=" + users + ", authority=" + authority + "]";
	}
    
    
    
}