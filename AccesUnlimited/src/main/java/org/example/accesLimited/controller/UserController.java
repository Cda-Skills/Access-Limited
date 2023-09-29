package org.example.accesLimited.controller;

import org.example.accesLimited.model.User;
import org.example.accesLimited.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin("*")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping("/public/inscription")
	public String formulaire() {

		return "formulaire.html";
	}
	
	@RequestMapping("/save")
	public String Inscrit(@ModelAttribute("userAddtribute") User user) {
		userService.saveUser(user);
		return "formulaire.html";
	}

	@RequestMapping("/public/philosophie")
	public String philo() {

		return "philosophie.html";
	}
	
	@RequestMapping("/public/nosOffres")
	public String offres() {

		return "nosOffres.html";
	}
	
	@RequestMapping("/user/simulateur")
	public String simulateur() {

		return "simulateur.html";
	}
	
	@RequestMapping("/user/calendrier")
	public String calendrier() {

		return "calendrier.html";
	}
	
	@RequestMapping("/user/documents")
	public String documents() {

		return "documents.html";
	}
	
	
	@RequestMapping("/admin/liste")
	public String liste() {

		return "adminList.html";
	}
	
	
	/*
	 * @RequestMapping("/") public String fo() {
	 * 
	 * return ".html"; }
	 */
	
	/*
	 * @RequestMapping("/admin/liste") public String listUser(ModelMap modelMap) {
	 * modelMap.addAttribute("users", userService.getAllUsers());
	 * System.out.println("je tente de récupérer les données de la BDD");
	 * System.out.println(userService.getAllUsers()); return "adminList"; }
	 */

}