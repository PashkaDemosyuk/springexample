package com.javacodegeeks.snippets.enterprise;

import BeansConfig.AppContext;
import models.AbstractUser;
import models.ProjectManager;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/auth")
public class InitialController {

	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration(ModelMap model) {
		return new ModelAndView("registration", "projectManager-entity", ctx.getBean(ProjectManager.class));
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(ModelMap model) {
		return new ModelAndView("login", "abstractUser-entity", ctx.getBean("abstractUser"));
	}
	}
