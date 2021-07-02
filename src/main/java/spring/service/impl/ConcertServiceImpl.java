package spring.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import spring.dao.ConcertDao;
import spring.exception.DataProcessingException;
import spring.model.Concert;
import spring.service.ConcertService;

@Service
public class ConcertServiceImpl implements ConcertService {
    private final ConcertDao concertDao;

    public ConcertServiceImpl(ConcertDao concertDao) {
        this.concertDao = concertDao;
    }

    @Override
    public Concert add(Concert concert) {
        return concertDao.add(concert);
    }

    @Override
    public Concert get(Long id) {
        return concertDao.get(id).orElseThrow(
                () -> new DataProcessingException("Can't get movie by id " + id));
    }

    @Override
    public List<Concert> getAll() {
        return concertDao.getAll();
    }
}
