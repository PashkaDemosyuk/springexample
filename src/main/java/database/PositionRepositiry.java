package database;

import models.Developer;
import models.Positions;
import org.hibernate.Session;

public class PositionRepositiry implements IRepository<Positions> {

    private Session _session;

    public PositionRepositiry(Session session) {
        _session = session;
    }

    public void Insert(Positions entity) {
        _session.beginTransaction();
        _session.save(entity);
        _session.getTransaction().commit();
    }
}
