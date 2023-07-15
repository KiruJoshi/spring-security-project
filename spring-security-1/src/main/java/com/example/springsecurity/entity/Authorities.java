package com.example.springsecurity.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "authorities")
@IdClass(AuthorityId.class)
public class Authorities {
    @Id
    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username", nullable = false)
    private Users users;

    @Id
    @Column(name = "authority", length = 50, nullable = false)
    private String authority;

    public Authorities() {
        // Default constructor
    }

    public Authorities(Users users, String authority) {
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
	public String toString() {
		return "Authorities [users=" + users + ", authority=" + authority + "]";
	}

    // Additional methods, if needed
}