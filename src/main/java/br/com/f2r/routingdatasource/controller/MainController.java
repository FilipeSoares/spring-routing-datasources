package br.com.f2r.routingdatasource.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String getIndexPage(HttpServletRequest request) {
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage() {
		return "login";
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String getUserPage() {
		return "user";
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
