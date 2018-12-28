package log;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;



@Aspect
public class AOPLogging {
    @Before("execution(* database.ProjectRepository.getProject(..))")
    public void PrintOperation()
    {
        System.out.println("Project manager get projects");
    }
    @AfterReturning("execution(* database.ProjectManagerRepository.deleteDeveloper(..))")
    public void PrintGoodExisting()
    {
        System.out.println("delete developer");
    }
    @AfterThrowing("execution(* database.ProjectManagerRepository.Insert(..))")
    public void PrintBadExisting()
    {
        System.out.println("Insert developer");
    }
}

