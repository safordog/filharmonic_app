package spring.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import spring.dao.ConcertHallDao;
import spring.exception.DataProcessingException;
import spring.model.ConcertHall;
import spring.service.ConcertHallService;

@Service
public class ConcertHallServiceImpl implements ConcertHallService {
    private final ConcertHallDao concertHallDao;

    public ConcertHallServiceImpl(ConcertHallDao concertHallDao) {
        this.concertHallDao = concertHallDao;
    }

    @Override
    public ConcertHall add(ConcertHall concertHall) {
        return concertHallDao.add(concertHall);
    }

    @Override
    public ConcertHall get(Long id) {
        return concertHallDao.get(id).orElseThrow(
                () -> new DataProcessingException("Can't get cinema hall by id " + id));
    }

    @Override
    public List<ConcertHall> getAll() {
        return concertHallDao.getAll();
    }
}
