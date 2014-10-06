package com.bohdamyr.store.manager.interfaces;

import com.bohdamyr.store.entity.User;

public interface IUserManager {

	public void save(User user);

	public User findById(Integer id);

	public User findByLogin(String login);

	public User findByPhoneNumber(String phoneNumber);

	public User findByEmail(String email);
}
