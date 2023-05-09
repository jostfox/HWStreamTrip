public class Trip {

private String source;
private String destination;
private String hours;
private Double price;
private String startDate;
private String returnDate;

    public Trip(String source, String destination, Double price, String startDate, String returnDate, String hours) {
        this.source = source;
        this.destination = destination;
        this.hours = hours;
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

    public String getHours() {
        return hours;
    }

    public Double getPrice() {
        return price;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", hours='" + hours + '\'' +
                ", price=" + price +
                ", startDate='" + startDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                '}';
    }
}
