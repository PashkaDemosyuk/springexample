package database;

import models.AbstractUser;
import models.Developer;
import models.ProjectManager;
import org.hibernate.Query;
import org.hibernate.Session;

public class ProjectManagerRepository implements IRepository<ProjectManager> {
    private Session _session;

    public ProjectManagerRepository(Session session) {
        _session = session;
    }

    public void Insert(ProjectManager entity) {
        _session.beginTransaction();
        _session.save(entity);
        _session.getTransaction().commit();
    }

    public String CheckUser(AbstractUser user){
        _session.beginTransaction();
        if((_session.createQuery("SELECT id FROM ProjectManager WHERE login = '" + user.getLogin() + "' AND password = '" + user.getPassword() + "'").list().size()) != 0){
            ProjectManager.id =  Integer.valueOf(_session.createQuery("SELECT id FROM ProjectManager WHERE login = '" + user.getLogin() + "' AND password = '" + user.getPassword() + "'").iterate().next().toString());
            return "PM";
        }
        else
            if((Developer.id = Integer.valueOf(_session.createQuery("SELECT id FROM Developer WHERE login = '" + user.getLogin() + "' AND password = '" + user.getPassword() + "'").iterate().next().toString())) != 0){
            return "D";
        }
        return  "";
    }

    public void deleteDeveloper(Developer entity){
        _session.beginTransaction();
        Query query = _session.createSQLQuery("DELETE FROM DEVELOPERS WHERE ID = :value1");
        query.setParameter("value1", entity.getId());
        query.executeUpdate();
        _session.getTransaction().commit();
    }
}
