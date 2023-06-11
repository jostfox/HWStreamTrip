import java.time.LocalDateTime;

public class Trip {

private String source;
private String destination;
private Long duration;
private Double price;
private LocalDateTime startDate;
private LocalDateTime returnDate;

    public Trip(String source, String destination, Double price, LocalDateTime startDate, LocalDateTime returnDate) {
        this.source = source;
        this.destination = destination;
        this.price = price;
        this.startDate = startDate;
        this.returnDate = returnDate;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public Long getDuration() {
        return duration;
    }

    public Double getPrice() {
        return price;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", hours='" + duration + '\'' +
                ", price=" + price +
                ", startDate='" + startDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                '}';
    }
}
