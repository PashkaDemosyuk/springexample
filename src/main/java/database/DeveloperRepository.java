package database;

import models.Developer;
import models.ProjectManager;
import org.hibernate.Session;

public class DeveloperRepository implements IRepository<Developer> {

    private Session _session;

    public DeveloperRepository(Session session) {
        _session = session;
    }

    public void Insert(Developer entity) {
        _session.beginTransaction();
        _session.save(entity);
        _session.getTransaction().commit();
    }
}
