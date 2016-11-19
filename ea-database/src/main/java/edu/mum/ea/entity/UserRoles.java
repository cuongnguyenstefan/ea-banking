package edu.mum.ea.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import edu.mum.ea.entity.enumtype.Role;

@Entity
public class UserRoles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userRoleId;
	
	@ManyToOne
	@JoinColumn(name = "username")
	private User user;
	
	@Enumerated(EnumType.STRING)
	private Role role;

	public Integer getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	

}
