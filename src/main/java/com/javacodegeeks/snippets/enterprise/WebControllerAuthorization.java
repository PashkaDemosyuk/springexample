package com.javacodegeeks.snippets.enterprise;

import BeansConfig.AppContext;
import database.UnitOfWork;
import models.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class WebControllerAuthorization {

    static AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView authorization(@Valid @ModelAttribute AbstractUser user, BindingResult bindingResult, ModelMap model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("message", "Incorrect data");
            return ViewsBuilder.creteEntity("projectManagerPage");
        }

        UnitOfWork unit = UnitOfWork.getInstance();
        ModelAndView modelDevPage;
        String userRole = unit.GetProjectManagerRepository().CheckUser(user);

        if(userRole.equals("PM")){
            modelDevPage = ViewsBuilder.creteEntity("projectManagerPage");
            //modelDevPage.addObject("developerList", unit.GetProjectRepository().getProject());
            return ViewsBuilder.creteEntity("projectManagerPage");
        }
        else if(userRole.equals("D")){
            modelDevPage = ViewsBuilder.creteEntity("developerPage");
            modelDevPage.addObject("rate", unit.GetProjectRepository().getRate());
            modelDevPage.addObject("developerList",unit.GetProjectRepository().getDeveloperProject());
            return  modelDevPage;
        }
        return null;
    }
}
