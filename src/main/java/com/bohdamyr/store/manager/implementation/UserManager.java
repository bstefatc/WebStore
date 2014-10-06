package com.bohdamyr.store.manager.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bohdamyr.store.dao.RoleDao;
import com.bohdamyr.store.dao.UserDao;
import com.bohdamyr.store.entity.Role;
import com.bohdamyr.store.entity.User;
import com.bohdamyr.store.manager.interfaces.IUserManager;

@Service
public class UserManager implements IUserManager {

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;

	@Override
	@Transactional
	public void save(User user) {
		user.setEnabled(true);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		List<Role> roles = new ArrayList<>();
		roles.add(roleDao.findByName("ROLE_USER"));
		user.setRoles(roles);
		userDao.save(user);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public User findById(Integer id) {
		return userDao.findOne(id);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public User findByLogin(String login) {
		return userDao.findByLogin(login);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public User findByPhoneNumber(String phoneNumber) {
		return userDao.findByPhoneNumber(phoneNumber);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}

}
