package com.sts.model;

import org.hibernate.validator.constraints.UniqueElements;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(unique=true)
	@NotBlank(message = "Username cannot be empty !!")
	@Size(min = 5 , max=12 ,message="Usename must be between 5 - 12 character only")
	private String username;
	@NotBlank(message = "Name cannot be empty !!")
	private String name;
	@Column(unique=true)
	@Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9+_.-]+$")
	@NotBlank(message = "Email cannot be empty !!")
	private String email;
	@Column(unique=true , length= 10)
	@NotBlank(message = "Phone number cannot be empty !!")
	private String phonenumber;
	@Column(unique=false)
	@NotBlank(message = "Password cannot be empty !!")
	@Size(min = 8 , max=100 ,message="Password must be between 8 - 15 character only and it must be unique")
	private String password;
	private String img;
	private String bio;

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public User(int id,
			@NotBlank(message = "Username cannot be empty !!") @Size(min = 5, max = 12, message = "Usename must be between 5 - 12 character only") String username,
			@NotBlank(message = "Name cannot be empty !!") String name,
			@Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9+_.-]+$") @NotBlank(message = "Email cannot be empty !!") String email,
			@NotBlank(message = "Phone number cannot be empty !!") String phonenumber,
			@NotBlank(message = "Password cannot be empty !!") @Size(min = 8, max = 100, message = "Password must be between 8 - 15 character only and it must be unique") String password,
			String img, String bio) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.email = email;
		this.phonenumber = phonenumber;
		this.password = password;
		this.img = img;
		this.bio = bio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", name=" + name + ", email=" + email + ", phonenumber="
				+ phonenumber + ", password=" + password + ", img=" + img + ", bio=" + bio + "]";
	}

	

}
