package spring.service;

import java.util.List;
import spring.model.Concert;

public interface ConcertService {
    Concert add(Concert concert);

    Concert get(Long id);

    List<Concert> getAll();
}
