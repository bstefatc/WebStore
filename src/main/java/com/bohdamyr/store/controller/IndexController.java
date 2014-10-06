package com.bohdamyr.store.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bohdamyr.store.manager.interfaces.ILotManager;
import com.bohdamyr.store.manager.interfaces.IUserManager;

@Controller
public class IndexController {
	@Autowired
	private IUserManager history;
	@Autowired
	private ILotManager lotManager;

	@RequestMapping("/")
	public String index(Model model, Principal principal) {

		model.addAttribute("lots", lotManager.findAll());
		return "index";
	}
}