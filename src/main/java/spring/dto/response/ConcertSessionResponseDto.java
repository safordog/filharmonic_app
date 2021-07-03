package spring.dto.response;

public class ConcertSessionResponseDto {
    private Long concertSessionId;
    private Long concertId;
    private String concertTitle;
    private Long concertHallId;
    private String showTime;

    public Long getConcertSessionId() {
        return concertSessionId;
    }

    public void setConcertSessionId(Long concertSessionId) {
        this.concertSessionId = concertSessionId;
    }

    public Long getConcertId() {
        return concertId;
    }

    public void setConcertId(Long concertId) {
        this.concertId = concertId;
    }

    public String getConcertTitle() {
        return concertTitle;
    }

    public void setConcertTitle(String concertTitle) {
        this.concertTitle = concertTitle;
    }

    public Long getConcertHallId() {
        return concertHallId;
    }

    public void setConcertHallId(Long concertHallId) {
        this.concertHallId = concertHallId;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }
}
