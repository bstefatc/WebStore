package com.bohdamyr.store.manager.interfaces;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bohdamyr.store.entity.Lot;

@Component
public interface ILotManager {

	public void save(List<Lot> lots);

	public void save(Lot lot);

	public List<Lot> findAll();

}
