package edu.mum.ea.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer username;
	@NotEmpty(message="First Name is Requered")
	private String firstName;
	@NotEmpty(message="Last Name is Requered")
	private String lastName;
	@NotEmpty(message="Phone is Requered")
	@Size(min=10, max=11)
	private String phone;
	@NotEmpty(message="Email is required")
	@Email(message="Please input a valid email")
	private String email;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/YYYY")
	private Date dateOfBirth;
	@NotEmpty(message="Password is Requered")
	@Size(min=3, max=20)
	private String password;
	
	private int enabled = 1;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
	private List<UserRoles> roles = new ArrayList<UserRoles>();
	@Valid
	@Embedded
	public Address address;
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Integer getUsername() {
		return username;
	}

	public void setUsername(Integer username) {
		this.username = username;
	}

	public List<UserRoles> getRoles() {
		return roles;
	}

	public void setRoles(List<UserRoles> roles) {
		this.roles = roles;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
}
