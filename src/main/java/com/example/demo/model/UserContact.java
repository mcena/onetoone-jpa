package com.example.demo.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class UserContact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int usercontact_id;
	
	@JsonBackReference
	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="user_id")
	private Users users;
	
	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	private int phone_number;
	

	public int getUsercontact_id() {
		return usercontact_id;
	}

	public void setUsercontact_id(int usercontact_id) {
		this.usercontact_id = usercontact_id;
	}

	public int getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}

	
	
	
}
