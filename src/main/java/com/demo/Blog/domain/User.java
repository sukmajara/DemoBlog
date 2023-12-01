package com.demo.Blog.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2718692090389940884L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	@Column(unique = true)
	private String username;
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name="user_role_junciton",
			joinColumns = {@JoinColumn(name="userId")},
			inverseJoinColumns = {@JoinColumn(name="roleId")}
			)
	private Set<Role> authorities;
	
	public User() {
		super();
		this.authorities = new HashSet<Role>();
	}
	
	

	public User(int userId, String username, String password, Set<Role> authorities) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	public void setAuthorities(Set<Role> authorities) {
		this.authorities = authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}
	
	
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
