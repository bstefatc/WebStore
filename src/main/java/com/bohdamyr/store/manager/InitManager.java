package com.bohdamyr.store.manager;

/**
 * Filling the database by first time
 */
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bohdamyr.store.dao.LotDao;
import com.bohdamyr.store.dao.RoleDao;
import com.bohdamyr.store.dao.UserDao;
import com.bohdamyr.store.entity.Lot;
import com.bohdamyr.store.entity.Role;
import com.bohdamyr.store.entity.User;
import com.bohdamyr.store.manager.interfaces.ILotManager;

@Service
@Transactional
public class InitManager {

	private BCryptPasswordEncoder encoder;

	@Autowired
	private ILotManager lotManager;
	@Autowired
	private LotDao lotDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;

	private User user;

	private Role userRole;

	private Lot lot1;
	private Lot lot2;
	private Lot lot3;
	private Lot lot4;
	private Lot lot5;
	private Lot lot6;
	private Lot lot7;
	private Lot lot8;

	@PostConstruct
	public void init() {

		roleDao.save(roles());
		userDao.save(users());
		List<Lot> lots = lots();
		lotManager.save(lots);
	}

	private List<Role> roles() {

		List<Role> roles = new ArrayList<Role>();
		userRole = new Role();
		userRole.setName("ROLE_USER");
		roles.add(userRole);
		return roles;
	}

	private List<User> users() {

		encoder = new BCryptPasswordEncoder();
		List<User> users = new ArrayList<User>();
		List<Role> roles = new ArrayList<Role>();

		roles.add(userRole);
		user = new User();
		user.setLogin("user");
		user.setPassword(encoder.encode("user"));
		user.setEmail("user@mail.com");
		user.setPhoneNumber("(032)9113235");
		user.setEnabled(true);
		user.setRoles(roles);

		users.add(user);

		return users;
	}

	private List<Lot> lots() {

		List<Lot> lots = new ArrayList<Lot>();

		lot1 = new Lot();
		lot1.setLotName("AppleNet 12");
		lot1.setPrice(20.0);

		lots.add(lot1);

		lot2 = new Lot();
		lot2.setLotName("Sumsung S6");
		lot2.setPrice(15.0);

		lots.add(lot2);

		lot3 = new Lot();
		lot3.setLotName("GSmart 202");
		lot3.setPrice(100.0);

		lots.add(lot3);

		lot4 = new Lot();
		lot4.setLotName("Gelexy Tab");
		lots.add(lot4);

		lot5 = new Lot();
		lot5.setLotName("iPod 1.8");
		lot5.setPrice(50.0);

		lots.add(lot5);

		lot6 = new Lot();
		lot6.setLotName("Canon EOS 450d");
		lot6.setPrice(300.0);

		lots.add(lot6);

		lot7 = new Lot();
		lot7.setLotName("iPed 1.8");
		lot7.setPrice(230.0);

		lots.add(lot7);

		lot8 = new Lot();
		lot8.setLotName("Nikon D5300");
		lot8.setPrice(1.0);

		lots.add(lot8);

		return lots;
	}
}
