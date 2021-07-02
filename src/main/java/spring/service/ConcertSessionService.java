package spring.service;

import java.time.LocalDate;
import java.util.List;
import spring.model.ConcertSession;

public interface ConcertSessionService {
    List<ConcertSession> findAvailableSessions(Long movieId, LocalDate date);

    ConcertSession add(ConcertSession session);

    ConcertSession get(Long id);

    ConcertSession update(ConcertSession concertSession);

    void delete(Long id);
}
