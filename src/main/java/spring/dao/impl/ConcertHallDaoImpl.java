package spring.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import spring.dao.AbstractDao;
import spring.dao.ConcertHallDao;
import spring.model.ConcertHall;

@Repository
public class ConcertHallDaoImpl extends AbstractDao<ConcertHall> implements ConcertHallDao {
    public ConcertHallDaoImpl(SessionFactory factory) {
        super(factory, ConcertHall.class);
    }
}
