package spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.dto.request.ConcertHallRequestDto;
import spring.dto.response.ConcertHallResponseDto;
import spring.model.ConcertHall;
import spring.service.ConcertHallService;
import spring.service.mapper.ConcertHallMapper;

@RestController
@RequestMapping("/concerts-halls")
public class ConcertHallController {
    private final ConcertHallService concertHallService;
    private final ConcertHallMapper concertHallMapper;

    public ConcertHallController(ConcertHallService concertHallService,
                                 ConcertHallMapper concertHallMapper) {
        this.concertHallService = concertHallService;
        this.concertHallMapper = concertHallMapper;
    }

    @PostMapping
    public ConcertHallResponseDto add(@RequestBody @Valid ConcertHallRequestDto requestDto) {
        ConcertHall concertHall = concertHallService.add(concertHallMapper.mapToModel(requestDto));
        return concertHallMapper.mapToDto(concertHall);
    }

    @GetMapping
    public List<ConcertHallResponseDto> getAll() {
        return concertHallService.getAll()
                .stream()
                .map(concertHallMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
