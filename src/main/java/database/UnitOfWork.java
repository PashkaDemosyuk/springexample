package database;

import models.DevelopersPositions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.*;
import org.hibernate.service.*;

public class UnitOfWork {
    private static UnitOfWork _instance;

    private UnitOfWork() {
    }

    public static UnitOfWork getInstance() {
        if (_instance == null)
            _instance = new UnitOfWork();
        return _instance;
    }

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration().configure();
            ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
            registry.applySettings(configuration.getProperties());
            ServiceRegistry serviceRegistry = registry.buildServiceRegistry();
            SessionFactory sessionFactory = configuration
                    .buildSessionFactory(serviceRegistry);
            return sessionFactory;
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public Session getSession() {
        Session result;

        result = sessionFactory.getCurrentSession();

        return result;
    }

    public void shutdown() {
        sessionFactory.close();
    }

    public void commit() {
        getSession().getTransaction().commit();
    }

    public ProjectManagerRepository GetProjectManagerRepository() {
        return new ProjectManagerRepository(getSession());
    }

    public DeveloperRepository GetDevelooperRepository() {
        return new DeveloperRepository(getSession());
    }

    public AddressRepository GetAddressRepository() {
        return new AddressRepository(getSession());
    }

    public PositionRepositiry GetPositionRepository() {
        return new PositionRepositiry(getSession());
    }

    public ProjectRepository GetProjectRepository() {
        return new ProjectRepository(getSession());
    }

    public DeveloperPositionsRepository GetDeveloperPositions() {
        return new DeveloperPositionsRepository(getSession());
    }

    public ProjectDeveloperPositionRepository GetProjectDeveloperPosition() {
        return new ProjectDeveloperPositionRepository(getSession());
    }
}
