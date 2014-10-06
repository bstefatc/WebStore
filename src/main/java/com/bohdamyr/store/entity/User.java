package com.bohdamyr.store.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import com.bohdamyr.store.annotation.UniqueUser;

@Entity
@NamedQueries({
		@NamedQuery(name = "User.findByEmail", query = "SELECT user FROM  User  user  WHERE user.email   =:email"),
		@NamedQuery(name = "User.findByLogin", query = "SELECT user FROM  User  user  WHERE user.login   =:login"),
		@NamedQuery(name = "User.findByPhoneNumber", query = "SELECT user FROM  User  user  WHERE user.phoneNumber  = :phoneNumber") })
@UniqueUser(message = "")
@Table(name = "USER")
public class User extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;

	private String firstName;

	private String lastName;

	@Email
	@Size(min = 3, message = "Invalid email address")
	@Column(unique = true)
	private String email;

	@Size(min = 3, message = "Name must be at least 3 characters!")
	@Column(unique = true)
	private String login;

	@Size(min = 4, message = "Password must be at least 4 characters!")
	private String password;

	@Size(min = 10, message = "Phone Number must be at least 10 characters!")
	private String phoneNumber;

	private Date createDate;

	private boolean enabled;

	@ManyToMany
	@JoinTable
	private List<Role> roles;

	public User() {

	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
