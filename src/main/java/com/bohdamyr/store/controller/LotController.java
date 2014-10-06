package com.bohdamyr.store.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bohdamyr.store.entity.Lot;
import com.bohdamyr.store.manager.interfaces.IBasketManager;
import com.bohdamyr.store.manager.interfaces.ILotManager;
import com.bohdamyr.store.manager.interfaces.IUserManager;
import com.bohdamyr.store.util.PagingUtil;

@Controller
public class LotController {

	@Autowired
	private ILotManager lotManager;
	@Autowired
	private IUserManager userManager;
	@Autowired
	private IBasketManager basketManager;

	PagingUtil<Lot> page;

	@RequestMapping(value = "/lots/{lotId}/addToBasket")
	public String addToWatchlist(@PathVariable int lotId, Principal principal) {
		basketManager.addToWatchlist(principal.getName(), lotId);
		return "redirect:/";
	}
}