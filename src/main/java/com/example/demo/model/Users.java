package com.example.demo.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	private int user_id;
	
	private String name;
	private int age;
	private String address;
	private String email;
	
	//ONE-TO-ONE
	
	@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL, mappedBy="users")
	@JoinColumn(name="user_id")
	private UserContact userContact;
	
	public UserContact getUserContact() {
		return userContact;
	}
	public void setUserContact(UserContact userContact) {
		this.userContact = userContact;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
