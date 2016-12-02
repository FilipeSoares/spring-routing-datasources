package br.com.f2r.routingdatasource.controller;

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

import br.com.f2r.routingdatasource.model.CustomUserDetails;
import br.com.f2r.routingdatasource.service.ProductService;

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

	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public String getAccountPage() {
		return "account";
	}

	@RequestMapping(value = "/card", method = RequestMethod.GET)
	public String getCardPage() {
		return "card";
	}

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public String getCategoryPage() {
		return "category";
	}

	@RequestMapping(value = "/launch", method = RequestMethod.GET)
	public String getLaunchPage() {
		return "launch";
	}

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String getDashPage() {
		return "dashboard";
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
