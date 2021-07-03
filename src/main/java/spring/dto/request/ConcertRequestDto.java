package spring.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ConcertRequestDto {
    @NotNull
    private String concertTitle;
    @Size(max = 200)
    private String concertDescription;

    public String getConcertTitle() {
        return concertTitle;
    }

    public String getConcertDescription() {
        return concertDescription;
    }
}
