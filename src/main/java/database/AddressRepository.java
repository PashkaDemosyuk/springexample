package database;

import models.Address;
import models.Developer;
import org.hibernate.Session;

public class AddressRepository implements IRepository<Address> {

    private Session _session;

    public AddressRepository(Session session) {
        _session = session;
    }

    public void Insert(Address entity) {
        _session.beginTransaction();
        _session.save(entity);
        _session.getTransaction().commit();
    }
}
