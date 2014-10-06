package com.bohdamyr.store.manager.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.bohdamyr.store.dao.BasketDao;
import com.bohdamyr.store.dao.LotDao;
import com.bohdamyr.store.dao.UserDao;
import com.bohdamyr.store.entity.Basket;
import com.bohdamyr.store.entity.Lot;
import com.bohdamyr.store.entity.User;
import com.bohdamyr.store.manager.interfaces.IBasketManager;

@Service
public class BasketManager implements IBasketManager {

	@Autowired
	BasketDao basketDao;
	@Autowired
	LotDao lotDao;
	@Autowired
	UserDao userDao;

	@Override
	public void addToWatchlist(String login, Integer lotId) {
		Lot lot = lotDao.findOne(lotId);
		User user = userDao.findByLogin(login);
		basketDao.save(new Basket(user, lot));
	}

	@Override
	public Page<Lot> findAllBasket(String login, Integer pageNumber,
			Integer countItems, String sorterItem, String direction) {
		Direction usedDirection = Sort.Direction.fromString(direction);
		PageRequest request = new PageRequest(pageNumber - 1, countItems,
				usedDirection, "basketId");
		return basketDao.queryFindAllBasketByUser(login, request);
	}

	@Override
	public void deleteBasket(String login, int lotId) {
		basketDao.delete(basketDao.findBasketByUserAndLot(login, lotId));
	}

}
