package spring.service;

import java.util.List;
import spring.model.ConcertHall;

public interface ConcertHallService {
    ConcertHall add(ConcertHall concertHall);

    ConcertHall get(Long id);

    List<ConcertHall> getAll();
}
