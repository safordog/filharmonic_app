package spring.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ConcertSessionRequestDto {
    @Positive
    private Long concertId;
    @Positive
    private Long concertHallId;
    @NotNull
    private String showTime;

    public Long getConcertId() {
        return concertId;
    }

    public Long getConcertHallId() {
        return concertHallId;
    }

    public String getShowTime() {
        return showTime;
    }
}
