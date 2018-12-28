package BeansConfig;

import models.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Date;
import java.util.Set;

@Configuration
//@EnableWebMvc
public class AppContext {
//методы жизненного цикла
    @Bean(initMethod="init",destroyMethod="destroy")
    @Scope(value = "prototype") // область действия
    @Lazy(value = true)
    public Developer developer(@Value("0")long id, @Value("1") String password, @Value("1")String login, @Value("0")int experience, @Value("01/01/2011")Date birtday, Address address){
        return new Developer(id, password, login, experience, birtday, address);
    }

    @Bean(initMethod="init",destroyMethod="destroy")
    @Scope(value = "prototype")
    @Lazy(value = true)
    public ProjectManager projectManager(@Value("0")long id,@Value("")String password, @Value("")String login){
        return new ProjectManager(id, password, login);
    }

    @Bean(initMethod="init",destroyMethod="destroy")
    @Scope(value = "prototype")
    @Lazy(value = true)
    //@Qualifier( "address-1")
    public Address address(@Value("0")long id, @Value("")String street, @Value("0")int homeNumber, @Value("0")int roomNumber){
        return new Address(id, street, homeNumber, roomNumber);
    }

    @Bean(initMethod="init",destroyMethod="destroy")
    @Scope(value = "prototype")
    @Lazy(value = true)
    public Project project(@Value("0")long id, @Value("01/01/2011")Date beginDate, @Value("01/01/2011") Date endDate, ProjectManager projectManager, @Value("")String customer){
        return new Project(id, beginDate, endDate, projectManager, customer);
    }

    @Bean(initMethod="init",destroyMethod="destroy")
    @Scope(value = "prototype")
    @Lazy(value = true)
    public Technologies technologie(@Value("0")long id, @Value("")String technologyName){
        return new Technologies(id, technologyName);
    }

    @Bean(initMethod="init",destroyMethod="destroy")
    @Scope(value = "prototype")
    @Lazy(value = true)
    public Positions position(@Value("1")long id,@Value("") String positionName){
        return new Positions(id, positionName);
    }

    @Bean(initMethod="init",destroyMethod="destroy")
    @Scope(value = "prototype")
    @Lazy(value = true)
    public DevelopersPositions developersPositions(@Value("0")long id, Developer developer, Positions position, Set<Project> projects, @Value("0")int salary, @Value("01/01/2011")Date month){
        return new DevelopersPositions(id, developer, position, projects, salary, month);
    }

    @Bean
    @Scope(value = "prototype")
    @Lazy(value = true)
    public AbstractUser abstractUser(@Value("0")long id, @Value("")String login, @Value("")String password){
        return new AbstractUser(id, password, login);
    }

    @Bean
    @Scope(value = "prototype")
    @Lazy(value = true)
    public ProjectDeveloperPositions projDevPos(@Value("0")long id,Project project, DevelopersPositions devPos){
        return new ProjectDeveloperPositions(id, project, devPos);
    }
}
