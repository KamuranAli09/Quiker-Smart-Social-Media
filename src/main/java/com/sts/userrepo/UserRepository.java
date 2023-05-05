package com.sts.userrepo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sts.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	@Query("select u from User u where u.username = :username")
	public User getUserByUserName(@Param("username") String username);
	
	@Modifying
	@Query("UPDATE User u SET u.name = :newName, u.img = :newImg WHERE u.username = :username")
	User updateUser(@Param("username") String username, @Param("newName") String newName, @Param("newImg") String newImg);

}
