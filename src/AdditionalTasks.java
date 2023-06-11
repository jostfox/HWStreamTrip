import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class AdditionalTasks {
    public static void main(String[] args) {
        LocalDateTime myBirthday = LocalDateTime.of(1981, 12, 30, 0, 0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd  LLLL yyyy");

        printTask(1);
        System.out.println(myBirthday.format(formatter));

        printTask(2);
        System.out.println(myBirthday.format(formatter) +
                " is Friday: " + "friday".toUpperCase().equals(myBirthday.getDayOfWeek()));

        printTask(3);
        System.out.println("Minus 10 years: " + myBirthday.minusYears(10).format(formatter));

        printTask(4);
        ZoneId zonePac = ZoneId.of("Pacific/Midway");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(myBirthday, zonePac);
        System.out.println(zonedDateTime);

    }
    private static void printTask(int num){
        System.out.println("\nTask " + num);
        System.out.println("===============");
    }
}
