package models;

import BeansConfig.AppContext;
import javafx.geometry.Pos;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

public class ViewsBuilder {

    static AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);

    public static ModelAndView creteEntity(String jsp){
        ModelAndView model = new ModelAndView();
        model.setViewName(jsp);
        model.addObject("developer-entity", ctx.getBean(Developer.class));
        model.addObject("developer-delete-entity", ctx.getBean(Developer.class));
        model.addObject("project-entity", ctx.getBean(Project.class));
        model.addObject("position-entity", ctx.getBean(Positions.class));
        model.addObject("position_developer-entity", ctx.getBean(DevelopersPositions.class));
        model.addObject("proj_dev_pos-entity", ctx.getBean(ProjectDeveloperPositions.class));
        return model;
    }

}
