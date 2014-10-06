package com.bohdamyr.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bohdamyr.store.entity.Lot;

@Repository
public interface LotDao extends JpaRepository<Lot, Integer> {
}
