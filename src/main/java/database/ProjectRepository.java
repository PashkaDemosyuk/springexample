package database;

import models.*;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.access.annotation.Secured;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepository implements IRepository<Project> {

    private Session _session;

    public ProjectRepository(Session session) {
        _session = session;
    }

//    @Secured(value = {"ROLE_ADMIN"})
    public void Insert(Project entity) {
        _session.beginTransaction();
        Query query = _session.createSQLQuery("INSERT INTO PROJECT( BEGIN_DATE, CUSTOMER, END_DATE, PROJECTMANAGER_ID ) VALUES(:value1, :value2, :value3, :value4)");

        query.setParameter("value1", entity.getBeginDate());
        query.setParameter("value2", entity.getCustomer());
        query.setParameter("value3", entity.getEndDate());
        query.setParameter("value4", entity.getProjectManager().getId());

        query.executeUpdate();
        _session.getTransaction().commit();
    }

    public List<Developer> Find(String p, String l, String pn) {
        _session.beginTransaction();
        Query query = _session.createSQLQuery("SELECT D.ID, D.LOGIN, D.PASSWORD, D.EXPERIENCE, D.BIRTHDAY, D.ADDRESS_ID " +
                " FROM PROJECT AS P INNER JOIN project_developers_positions AS PD ON P.ID = PD.PROJECT_ID " +
                " INNER JOIN developers_positions AS DP ON  PD.DEVELOPER_POSITION_ID = DP.id " +
                " INNER JOIN developers AS D ON DP.developer_id = D.ID " +
                "  where P.ID = :value1");

        query.setParameter("value1",p);
        query.setFirstResult((Integer.parseInt(pn)-1)*Integer.parseInt(l));
        query.setMaxResults(Integer.parseInt(l));
        List<Developer> list = query.list();
        _session.getTransaction().commit();
        return list;
    }


    public List<Project> getDeveloperProject(){
        List<ProjectDeveloperPositions> listProjDvPos = new ArrayList<ProjectDeveloperPositions>();
        List listProject = new ArrayList<Project>();

        Criteria criteria = _session.createCriteria(DevelopersPositions.class);
        Criteria criteriaProjDevPos = _session.createCriteria(ProjectDeveloperPositions.class);
        Criteria criteriaProj = _session.createCriteria(Project.class);

                List<DevelopersPositions> listDevPos = criteria.add(Restrictions.ge("developer", Developer.id)).list();

        for(DevelopersPositions item : listDevPos){
            listProjDvPos.addAll(criteriaProjDevPos.add(Restrictions.eq("devPos", item)).list());
        }

        for(ProjectDeveloperPositions item : listProjDvPos){
            listProject.addAll(criteriaProj.add(Restrictions.eq("id", item.getProject().getId())).list());
        }
        return listProject;
    }

    public Integer getRate(){
        Integer sum = 0;

        Criteria criteria = _session.createCriteria(DevelopersPositions.class);

        List<DevelopersPositions> listDevPos = criteria.add(Restrictions.eq("developer", Developer.id)).add(Restrictions.between("month", Date.valueOf(LocalDate.now().minusMonths(1)),Date.valueOf(LocalDate.now()))).list();

        for(DevelopersPositions item : listDevPos){
            sum += item.getSalary();
        }

        return sum;
    }

    public List<Developer> getProject(){

        List<ProjectDeveloperPositions> listProjDvPos = new ArrayList<ProjectDeveloperPositions>();
        List<DevelopersPositions> listDevPosition = new ArrayList<DevelopersPositions>();
        List listDeveloper = new ArrayList<Developer>();
        Integer sum = 0;

        Criteria criteria = _session.createCriteria(Project.class);
        Criteria criteriaProjDevPos = _session.createCriteria(ProjectDeveloperPositions.class);
        Criteria criterialDevelop = _session.createCriteria(Developer.class);
        Criteria criterialDevPos = _session.createCriteria(DevelopersPositions.class);

        List<Project> listDevPos = criteria.add(Restrictions.eq("projectManager.id", ProjectManager.id)).list();

        for(Project item : listDevPos){
            listProjDvPos.addAll(criteriaProjDevPos.add(Restrictions.eq("project", item)).list());
        }

        for(ProjectDeveloperPositions item : listProjDvPos){
            listDevPosition.addAll(criterialDevPos.add(Restrictions.eq("id", item.getDevPos().getId())).list());
        }

        for(DevelopersPositions item : listDevPosition){
            listDeveloper.addAll(criterialDevelop.add(Restrictions.eq("id", item.getDeveloper().getId())).list());
        }

        return listDeveloper;
    }
}
