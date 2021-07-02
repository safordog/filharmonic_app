package spring.dao.impl;

import java.time.LocalDate;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import spring.dao.AbstractDao;
import spring.dao.ConcertSessionDao;
import spring.exception.DataProcessingException;
import spring.model.ConcertSession;

@Repository
public class ConcertSessionDaoImpl extends AbstractDao<ConcertSession> implements ConcertSessionDao {
    public ConcertSessionDaoImpl(SessionFactory factory) {
        super(factory, ConcertSession.class);
    }

    @Override
    public List<ConcertSession> findAvailableSessions(Long movieId, LocalDate date) {
        try (Session session = factory.openSession()) {
            Query<ConcertSession> getAvailableSessions = session.createQuery(
                    "FROM MovieSession WHERE id = :id "
                            + "AND DATE_FORMAT(showTime, '%Y-%m-%d') = :date", ConcertSession.class);
            getAvailableSessions.setParameter("id", movieId);
            getAvailableSessions.setParameter("date", date.toString());
            return getAvailableSessions.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Session for concert with id "
                    + movieId + " and show date " + date + " not found", e);
        }
    }
}
