package com.skilloVilla.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skilloVilla.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	/* This Repository use access to data base with User entity
	 * By with the help of this we fetch the data from the data base of User entity
	 * this repository is stablish connection between the database database and entity(User Class)
	 *  */
}
