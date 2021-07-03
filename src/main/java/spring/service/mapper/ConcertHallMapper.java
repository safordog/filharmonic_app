package spring.service.mapper;

import org.springframework.stereotype.Component;
import spring.dto.request.ConcertHallRequestDto;
import spring.dto.response.ConcertHallResponseDto;
import spring.model.ConcertHall;

@Component
public class ConcertHallMapper implements RequestDtoMapper<ConcertHallRequestDto, ConcertHall>,
        ResponseDtoMapper<ConcertHallResponseDto, ConcertHall> {
    @Override
    public ConcertHall mapToModel(ConcertHallRequestDto dto) {
        ConcertHall concertHall = new ConcertHall();
        concertHall.setDescription(dto.getDescription());
        concertHall.setCapacity(dto.getCapacity());
        return concertHall;
    }

    @Override
    public ConcertHallResponseDto mapToDto(ConcertHall concertHall) {
        ConcertHallResponseDto responseDto = new ConcertHallResponseDto();
        responseDto.setId(concertHall.getId());
        responseDto.setDescription(concertHall.getDescription());
        return responseDto;
    }
}
