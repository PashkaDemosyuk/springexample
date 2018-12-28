package com.javacodegeeks.snippets.enterprise;

import database.UnitOfWork;
import models.Developer;
import models.ProjectDeveloperPositions;
import models.ViewsBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/delete")
public class WebControllerDelete {

    @RequestMapping(value = "/developer", method = RequestMethod.POST)
    public ModelAndView projectPosition(@ModelAttribute Developer developer, BindingResult bindingResult, ModelMap model) {
        UnitOfWork unit = UnitOfWork.getInstance();
        unit.GetProjectManagerRepository().deleteDeveloper(developer);
        return ViewsBuilder.creteEntity("projectManagerPage");
    }
}
