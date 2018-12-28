package database;

import models.Developer;
import models.DevelopersPositions;
import org.hibernate.Query;
import org.hibernate.Session;

public class DeveloperPositionsRepository implements IRepository<DevelopersPositions> {

    private Session _session;

    public DeveloperPositionsRepository(Session session) {
        _session = session;
    }

    public void Insert(DevelopersPositions entity) {
        _session.beginTransaction();
        Query query = _session.createSQLQuery("INSERT INTO Developers_Positions( MONTH, SALARY, DEVELOPER_ID, POSITION_ID ) VALUES(:value2, :value3, :value4, :value5)");
        query.setParameter("value2", entity.getMonth());
        query.setParameter("value3", entity.getSalary());
        query.setParameter("value4", entity.getDeveloper().getId());
        query.setParameter("value5", entity.getPosition().getId());
        query.executeUpdate();
        _session.getTransaction().commit();
    }
}