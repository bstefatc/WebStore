package com.bohdamyr.store.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//import com.bohdamyr.store.manager.interfaces.IBidManager;
import com.bohdamyr.store.entity.Lot;
import com.bohdamyr.store.manager.interfaces.IBasketManager;
import com.bohdamyr.store.manager.interfaces.IUserManager;
import com.bohdamyr.store.util.PagingUtil;

@Controller
public class BasketController {

	@Autowired
	IUserManager userManager;
	@Autowired
	IBasketManager basketManager;

	private final String directionAsc = "ASC";
	private final String directionDesc = "DESC";
	private final String defaultSortItemValue = "lotId";
	private final String defaultCountItemsValue = "5";

	PagingUtil<Lot> page;
	int totalPrice;

	@RequestMapping("/basket/{pageNumber}")
	public String allBids(
			Model model,
			Principal principal,
			RedirectAttributes redirectAttributes,
			@PathVariable Integer pageNumber,
			@RequestParam(required = false, defaultValue = defaultSortItemValue, value = "sorterItem") String sorterItem,
			@RequestParam(required = false, defaultValue = defaultCountItemsValue, value = "countItems") String countItems,
			@RequestParam(required = false, defaultValue = directionAsc, value = "direction") String direction) {

		String login = principal.getName();
		if (direction.equals(directionAsc))
			direction = directionDesc;
		else
			direction = directionAsc;

		page = new PagingUtil<Lot>(
				basketManager.findAllBasket(login, pageNumber,
						Integer.parseInt(countItems), "basketId", direction));

		model.addAttribute("user", userManager.findByLogin(login));
		model.addAttribute("content", page.getPage());
		model.addAttribute("beginIndex", page.getBegin());
		model.addAttribute("endIndex", page.getEnd());
		model.addAttribute("currentIndex", page.getCurrent());
		model.addAttribute("sorterItem", sorterItem);
		model.addAttribute("countItems", countItems);
		model.addAttribute("direction", direction);
		model.addAttribute("totalPrice", totalPriceCount(page));
		return "basket";
	}

	@RequestMapping(value = "/basket", method = RequestMethod.GET)
	public String removeManagerFromList(
			Model model,
			Principal principal,
			@RequestParam(value = "lotId", required = false, defaultValue = "") int lotId) {
		String login = principal.getName();
		basketManager.deleteBasket(login, lotId);
		return "redirect:/basket/1";

	}

	public double totalPriceCount(PagingUtil<Lot> page) {
		double totalPrice = 0;
		for (Lot lot : page.getPage().getContent()) {
			totalPrice += lot.getPrice();
		}
		return totalPrice;
	}
}
