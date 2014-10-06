package com.bohdamyr.store.manager.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bohdamyr.store.dao.LotDao;
import com.bohdamyr.store.entity.Lot;
import com.bohdamyr.store.manager.interfaces.ILotManager;

@Service
public class LotManager implements ILotManager {

	@Autowired
	private LotDao lotDao;

	@Override
	@Transactional
	public void save(List<Lot> lots) {
		lotDao.save(lots);
	}

	@Override
	@Transactional
	public void save(Lot lot) {
		lotDao.save(lot);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Lot> findAll() {
		return lotDao.findAll();
	}

}
