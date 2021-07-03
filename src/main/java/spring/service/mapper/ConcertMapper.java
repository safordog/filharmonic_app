package spring.service.mapper;

import org.springframework.stereotype.Component;
import spring.dto.request.ConcertRequestDto;
import spring.dto.response.ConcertResponseDto;
import spring.model.Concert;

@Component
public class ConcertMapper implements RequestDtoMapper<ConcertRequestDto, Concert>,
        ResponseDtoMapper<ConcertResponseDto, Concert> {
    @Override
    public Concert mapToModel(ConcertRequestDto dto) {
        Concert concert = new Concert();
        concert.setTitle(dto.getConcertTitle());
        concert.setDescription(dto.getConcertDescription());
        return concert;
    }

    @Override
    public ConcertResponseDto mapToDto(Concert concert) {
        ConcertResponseDto responseDto = new ConcertResponseDto();
        responseDto.setConcertId(concert.getId());
        responseDto.setConcertTitle(concert.getTitle());
        responseDto.setConcertDescription(concert.getDescription());
        return responseDto;
    }
}
