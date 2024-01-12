package com.rohini.institute.management.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private long id;
	private String role;
	private boolean status;
	@ManyToOne 
	@JoinColumn(name = "user_id")
	private User user;

	public Role() {
		super();
	}

	public Role(long id, String role, boolean status, User user) {
		super();
		this.id = id;
		this.role = role;
		this.status = status;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public User getUsername() {
		return user;
	}

	public void setUsername(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "RoleDTO [id=" + id + ", role=" + role + ", status=" + status + ", user=" + user + "]";
	}

}
