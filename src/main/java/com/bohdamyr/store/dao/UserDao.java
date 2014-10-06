package com.bohdamyr.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bohdamyr.store.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	public User findByLogin(@Param("login") String login);

	public User findByPhoneNumber(
			@Param(value = "phoneNumber") String phoneNumber);

	public User findByEmail(@Param(value = "email") String email);

}
