package spring.dao;

import java.util.List;
import java.util.Optional;
import spring.model.ConcertHall;

public interface ConcertHallDao {
    ConcertHall add(ConcertHall concertHall);

    Optional<ConcertHall> get(Long id);

    List<ConcertHall> getAll();
}
