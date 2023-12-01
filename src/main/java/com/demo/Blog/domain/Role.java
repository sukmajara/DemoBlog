package com.demo.Blog.domain;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="role-master")
public class Role implements GrantedAuthority{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1494894504862909643L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="role_id")
	private int roleId;
	
	private String authority;
	
	public Role() {
		super();
	}

	public Role(String authority) {
		super();
		this.authority = authority;
	}

	public Role(int roleId, String authority) {
		super();
		this.roleId = roleId;
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		return this.authority;
	}
	
	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	

}
