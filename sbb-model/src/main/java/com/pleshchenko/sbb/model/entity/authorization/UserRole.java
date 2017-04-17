package com.pleshchenko.sbb.model.entity.authorization;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "user_role")
public class UserRole{

	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "user")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	private User user;

	@Column(name = "role")
	@NotNull
	private String role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		UserRole userRole = (UserRole) o;

		return id.equals(userRole.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}
}