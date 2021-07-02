package spring.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ConcertSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Concert concert;
    @ManyToOne
    private ConcertHall concertHall;
    private LocalDateTime showTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Concert getMovie() {
        return concert;
    }

    public void setMovie(Concert concert) {
        this.concert = concert;
    }

    public ConcertHall getCinemaHall() {
        return concertHall;
    }

    public void setCinemaHall(ConcertHall concertHall) {
        this.concertHall = concertHall;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }

    @Override
    public String toString() {
        return "ConcertSession{"
                + "id=" + id
                + ", movie=" + concert
                + ", concertHall=" + concertHall
                + ", showTime=" + showTime + '}';
    }
}
