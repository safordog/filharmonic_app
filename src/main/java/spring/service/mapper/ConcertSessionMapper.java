package spring.service.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;
import spring.dto.request.ConcertSessionRequestDto;
import spring.dto.response.ConcertSessionResponseDto;
import spring.model.ConcertSession;
import spring.service.ConcertHallService;
import spring.service.ConcertService;
import spring.util.DateTimePatternUtil;

@Component
public class ConcertSessionMapper
        implements RequestDtoMapper<ConcertSessionRequestDto, ConcertSession>,
        ResponseDtoMapper<ConcertSessionResponseDto, ConcertSession> {
    private final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern(DateTimePatternUtil.DATE_TIME_PATTERN);
    private final ConcertHallService concertHallService;
    private final ConcertService concertService;

    public ConcertSessionMapper(ConcertHallService concertHallService,
                                ConcertService concertService) {
        this.concertHallService = concertHallService;
        this.concertService = concertService;
    }

    @Override
    public ConcertSession mapToModel(ConcertSessionRequestDto dto) {
        ConcertSession concertSession = new ConcertSession();
        concertSession.setMovie(concertService.get(dto.getConcertId()));
        concertSession.setCinemaHall(concertHallService.get(dto.getConcertHallId()));
        concertSession.setShowTime(LocalDateTime.parse(dto.getShowTime(), formatter));
        return concertSession;
    }

    @Override
    public ConcertSessionResponseDto mapToDto(ConcertSession concertSession) {
        ConcertSessionResponseDto responseDto = new ConcertSessionResponseDto();
        responseDto.setConcertSessionId(concertSession.getId());
        responseDto.setConcertHallId(concertSession.getCinemaHall().getId());
        responseDto.setConcertId(concertSession.getMovie().getId());
        responseDto.setConcertTitle(concertSession.getMovie().getTitle());
        responseDto.setShowTime(concertSession.getShowTime().format(formatter));
        return responseDto;
    }
}
