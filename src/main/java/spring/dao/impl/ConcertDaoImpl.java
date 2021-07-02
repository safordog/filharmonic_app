package spring.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import spring.dao.AbstractDao;
import spring.dao.ConcertDao;
import spring.model.Concert;

@Repository
public class ConcertDaoImpl extends AbstractDao<Concert> implements ConcertDao {
    public ConcertDaoImpl(SessionFactory factory) {
        super(factory, Concert.class);
    }
}
