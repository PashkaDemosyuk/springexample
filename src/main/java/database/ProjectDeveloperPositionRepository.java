package database;

import models.AbstractUser;
import models.ProjectDeveloperPositions;
import models.ProjectManager;
import org.hibernate.Query;
import org.hibernate.Session;

public class ProjectDeveloperPositionRepository implements IRepository<ProjectDeveloperPositions> {

    private Session _session;

    public ProjectDeveloperPositionRepository(Session session) {
        _session = session;
    }

    public void Insert(ProjectDeveloperPositions entity) {
        _session.beginTransaction();
        Query query = _session.createSQLQuery("INSERT INTO project_developers_positions( PROJECT_ID, DEVELOPER_POSITION_ID  ) VALUES(:value1, :value2)");
        query.setParameter("value1", entity.getProject().getId());
        query.setParameter("value2", entity.getDevPos().getId());
        query.executeUpdate();
        _session.getTransaction().commit();
    }
}
