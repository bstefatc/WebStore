package com.bohdamyr.store.manager.interfaces;

import org.springframework.data.domain.Page;

import com.bohdamyr.store.entity.Lot;

public interface IBasketManager {

	public void addToWatchlist(String login, Integer lotId);

	Page<Lot> findAllBasket(String login, Integer pageNumber,
			Integer countItems, String sorterItem, String direction);

	public void deleteBasket(String login, int lotId);
}
