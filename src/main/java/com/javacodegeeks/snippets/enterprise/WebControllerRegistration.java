package com.javacodegeeks.snippets.enterprise;

import BeansConfig.AppContext;
import database.DeveloperPositionsRepository;
import database.UnitOfWork;
import models.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/add")
public class WebControllerRegistration {

    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);

    @RequestMapping(value = "/projectmanager", method = RequestMethod.POST)
    public String projManag(@Valid @ModelAttribute ProjectManager projectManager,  BindingResult bindingResult, ModelMap model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("message", "Incorrect data");
            return null;
        }
        UnitOfWork unit = UnitOfWork.getInstance();
        unit.GetProjectManagerRepository().Insert(projectManager);
        return "hello";
    }

    @RequestMapping(value = "/developer", method = RequestMethod.POST)
    public ModelAndView developer(@Valid @ModelAttribute Developer developer, BindingResult bindingResult, ModelMap model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("message", "Incorrect data");
            return ViewsBuilder.creteEntity("projectManagerPage");
        }
        UnitOfWork unit = UnitOfWork.getInstance();
        unit.GetAddressRepository().Insert(developer.getAddress());
        unit.GetDevelooperRepository().Insert(developer);
        return ViewsBuilder.creteEntity("projectManagerPage");
    }

    @RequestMapping(value = "/position", method = RequestMethod.POST)
    public ModelAndView position(@Valid @ModelAttribute Positions position, BindingResult bindingResult, ModelMap model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("message", "Incorrect data");
            return ViewsBuilder.creteEntity("projectManagerPage");
        }
        UnitOfWork unit = UnitOfWork.getInstance();
        unit.GetPositionRepository().Insert(position);
        return ViewsBuilder.creteEntity("projectManagerPage");
    }

    @RequestMapping(value = "/developer_positions", method = RequestMethod.POST)
    public ModelAndView position( @ModelAttribute DevelopersPositions devPos, BindingResult bindingResult, ModelMap model) {
        devPos.getDeveloper().setLogin("1");
        devPos.getDeveloper().setPassword("3");
        devPos.getDeveloper().setBirthday(new Date("02/02/2012"));
        devPos.getDeveloper().setExperience(2);
        devPos.getPosition().setPositionName("A");
        UnitOfWork unit = UnitOfWork.getInstance();
        unit.GetDeveloperPositions().Insert(devPos);
        return ViewsBuilder.creteEntity("projectManagerPage");
    }

    @RequestMapping(value = "/project", method = RequestMethod.POST)
    public ModelAndView project(@Valid @ModelAttribute Project project, BindingResult bindingResult, ModelMap model) {
        if(bindingResult.hasErrors() || project.getBeginDate().after( project.getEndDate())){
            model.addAttribute("message", "Incorrect data");
            return ViewsBuilder.creteEntity("projectManagerPage");
        }
        UnitOfWork unit = UnitOfWork.getInstance();
        unit.GetProjectRepository().Insert(project);
        return ViewsBuilder.creteEntity("projectManagerPage");
    }

    @RequestMapping(value = "/project_position", method = RequestMethod.POST)
    public ModelAndView projectPosition(@ModelAttribute ProjectDeveloperPositions project, BindingResult bindingResult, ModelMap model) {
        UnitOfWork unit = UnitOfWork.getInstance();
        unit.GetProjectDeveloperPosition().Insert(project);
        return ViewsBuilder.creteEntity("projectManagerPage");
    }
    @RequestMapping(value = "/find/project", method = RequestMethod.POST)
    public ModelAndView projectFiend(@ModelAttribute Project project, BindingResult bindingResult, ModelMap model,
                                     @RequestParam("proj") String p,  @RequestParam("lim") String l,  @RequestParam("pagenum") String pn) {
        UnitOfWork unit = UnitOfWork.getInstance();
        ModelAndView modelDevPage;
        modelDevPage = ViewsBuilder.creteEntity("pagination");
        modelDevPage.addObject("developerList", unit.GetProjectRepository().Find(p, l, pn));
        return modelDevPage;
    }
}


