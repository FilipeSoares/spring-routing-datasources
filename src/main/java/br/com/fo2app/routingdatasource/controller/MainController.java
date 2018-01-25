package br.com.fo2app.routingdatasource.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.fo2app.routingdatasource.model.CustomUserDetails;
import br.com.fo2app.routingdatasource.service.ProductService;

@Controller
public class MainController {
	
	@Autowired
	@Qualifier("productServiceImpl")
	ProductService ps;

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public ModelAndView getIndexPage() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		CustomUserDetails detail = (CustomUserDetails) authentication.getPrincipal();
		return new ModelAndView("index", "persistence", currentPrincipalName + " ( " + detail.getConnection() + " ) ");
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage() {
		return "login";
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView getProductsPage() {
		return new ModelAndView("products", "list", ps.list());
	}

	@RequestMapping(value = "/denied", method = RequestMethod.GET)
	public String getDeniedPage() {
		return "denied";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		if (SecurityContextHolder.getContext().getAuthentication() != null) {
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		return "redirect:/login";
	}
}
