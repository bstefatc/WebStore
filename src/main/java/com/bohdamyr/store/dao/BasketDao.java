package com.bohdamyr.store.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bohdamyr.store.entity.Basket;
import com.bohdamyr.store.entity.Lot;
import com.bohdamyr.store.entity.User;

@Repository
public interface BasketDao extends JpaRepository<Basket, Integer> {
	public List<User> findBasketUserForLot(Integer lotId);

	@Query(name = "query", value = "select l from Basket w JOIN w.buyer b JOIN w.lot l where b.login = ?1")
	Page<Lot> queryFindAllBasketByUser(String login, Pageable pageable);

	Basket findBasketByUserAndLot(String login, int lotId);
}
