package com.example.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Users;

public interface UserRepository extends JpaRepository<Users,Integer>{
	
	@Query("SELECT n.name from Users n")
	String findNames();
	
	@Query("SELECT n.name from Users n where n.name = :name")
	String findName(@Param("name") String name);
	
	@Query("SELECT n from Users n LEFT JOIN n.userContact u where n.name = :name")
	List<Users> findAllUsers(@Param("name") String name);
}
