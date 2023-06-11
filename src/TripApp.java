import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class TripApp {

    public static void main(String[] args) {

        Trip tripOne = new Trip("Haren", "Hannover", 34.12,
                LocalDateTime.of(2023, 5, 20, 14, 15),
                LocalDateTime.of(2023, 5, 21, 02, 10));
        Trip tripTwo = new Trip("Berlin", "Dusseldorf", 87.56,
                LocalDateTime.of(2023, 5, 22, 8, 27),
                LocalDateTime.of(2023, 5, 22, 15, 25));
        Trip tripThree = new Trip("Haren", "Keln", 21.79,
                LocalDateTime.of(2023, 5, 24, 8, 44),
                LocalDateTime.of(2023, 5, 24, 11, 47));
        Trip tripFour = new Trip("Hannover", "Berlin", 39.45,
                LocalDateTime.of(2023, 5, 19, 8, 31),
                LocalDateTime.of(2023, 5, 19, 10, 16));
        Trip tripFive = new Trip("Hannover", "Hamburg", 35.87,
                LocalDateTime.of(2023, 5, 20, 9, 20),
                LocalDateTime.of(2023, 5, 21, 10, 36));
        Trip tripSix = new Trip("Haren", "Hannover", 42.95,
                LocalDateTime.of(2023, 5, 17, 7, 23),
                LocalDateTime.of(2023, 5, 17, 15, 38));
        Trip tripSeven = new Trip("Berlin", "Dusseldorf", 65.87,
                LocalDateTime.of(2023, 5, 20, 11, 34),
                LocalDateTime.of(2023, 5, 21, 20, 50));

        List<Trip> tripList = Arrays.asList(tripOne, tripTwo, tripThree, tripFour,
                tripFive, tripSix, tripSeven);

        Scanner scanner = new Scanner(System.in);

        ScannerDecorator scannerDecorator = new ScannerDecorator(scanner);

        try {
            while (true) {
                new TripDialog().initialDialog();
                String choice = scanner.nextLine();

                switch (choice.toUpperCase()) {
                    case "A" -> tripList.stream()
                            .map(x -> x.getSource() + " - " + x.getDestination())
                            .collect(Collectors.toList())
                            .forEach(System.out::println);
                    case "B" -> tripList.stream()
                            .map(x -> x.getPrice() + " Eur" + " - " + x.getSource() + " - " + x.getDestination())
                            .sorted(Comparator.naturalOrder())
                            .collect(Collectors.toList())
                            .forEach(System.out::println);
                    case "C" -> tripList.stream()
                            .map(x -> x.getPrice() + " Eur" + " - " + x.getSource() + " - " + x.getDestination())
                            .sorted(Comparator.reverseOrder())
                            .collect(Collectors.toList())
                            .forEach(System.out::println);
                    case "D" -> {
                        double lowPrice = scannerDecorator.getDouble("Задайте нижнюю границу цен:");
                        double highPrice = scannerDecorator.getDouble("Задайте верхнюю границу цен:");
                        tripList.stream()
                                .filter(x -> x.getPrice() >= lowPrice && x.getPrice() <= highPrice)
                                .map(x -> x.getSource() + " - " + x.getDestination() + " - " + x.getPrice() + " Eur")
                                .collect(Collectors.toList())
                                .forEach(System.out::println);
                    }
                    case "E" -> {
                        String sourceCity = scannerDecorator.getString("Введите город отправления: ");
                        tripList.stream()
                                .filter(x -> sourceCity.equals(x.getSource()))
                                .map(x -> x.getSource() + " - " + x.getDestination() +
                                        " - " + x.getStartDate() + " - " + x.getReturnDate() +
                                        " - " + x.getPrice() + " Eur")
                                .sorted(Comparator.naturalOrder())
                                .collect(Collectors.toList())
                                .forEach(System.out::println);
                    }
                    case "F" -> {
                        String destinationCity = scannerDecorator.getString("Введите город назначения: ");
                        tripList.stream()
                                .filter(x -> destinationCity.equals(x.getDestination()))
                                .map(x -> x.getSource() + " - " + x.getDestination() +
                                        " - " + x.getStartDate() + " - " + x.getReturnDate() +
                                        " - " + x.getPrice() + " Eur")
                                .sorted(Comparator.naturalOrder())
                                .collect(Collectors.toList())
                                .forEach(System.out::println);
                    }
                    case "G" -> {
                        System.out.println("Всего доступных рейсов: " + tripList.size());
                        System.out.println("==================");
                        System.out.println("Диапозон цен: ");
                        tripList.stream()
                                .map(x -> x.getPrice() + " Eur")
                                .sorted(Comparator.naturalOrder())
                                .collect(Collectors.toList())
                                .forEach(System.out::println);
                        System.out.println("==================");
                        System.out.println("Города отправления: ");
                        System.out.println("--------------------");
                        tripList.stream()
                                .map(Trip::getSource)
                                .collect(Collectors.toSet())
                                .forEach(System.out::println);
                        System.out.println("==================");
                        System.out.println("Города прибытия: ");
                        System.out.println("--------------------");
                        tripList.stream()
                                .map(Trip::getDestination)
                                .collect(Collectors.toSet())
                                .forEach(System.out::println);
                    }
                    case "H" -> {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
                        String dateDeparture = scannerDecorator.getString("\nВведите дату отправления " +
                                "(в формате ДД.ММ.ГГГГ ЧЧ:ММ): ");
                        LocalDateTime dateStart = LocalDateTime.parse(dateDeparture, formatter);
                        String dateArrival = scannerDecorator.getString("\nВведите дату прибытия " +
                                "(в формате ДД.ММ.ГГГГ ЧЧ:ММ): ");
                        LocalDateTime dateFinish = LocalDateTime.parse(dateArrival, formatter);
                        tripList.stream().filter(x -> x.getStartDate().isAfter(dateStart) &&
                                        x.getReturnDate().isBefore(dateFinish))
                                .map(x -> x.getSource() + "(" + x.getStartDate() + ")" + " - " +
                                        x.getDestination() + "(" + x.getReturnDate() + ")")
                                .collect(Collectors.toList())
                                .forEach(System.out::println);
                    }
                    case "I" -> {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                        String startDate = scannerDecorator.getString("\nВведите интересующую Вас дату " +
                                "(в формате ДД.ММ.ГГГГ): ");
                        LocalDate dateFrom = LocalDate.parse(startDate, formatter);
                        long days = scannerDecorator.getLong("\nВведите временной интервал (в днях): ");
                        System.out.printf("\nОт Вашей даты в течение %d дней доступны следующие поездки: \n", days);
                        System.out.println("-------------------------------------------------------");
                        tripList.stream().filter(x -> x.getStartDate().isAfter(dateFrom.atStartOfDay()) &&
                                        x.getStartDate().isBefore(dateFrom.plusDays(days).atStartOfDay()))
                                .map(x -> x.getSource() + "(" + x.getStartDate() + ")" + " - " +
                                        x.getDestination() + "(" + x.getReturnDate() + ")")
                                .collect(Collectors.toList())
                                .forEach(System.out::println);
                        System.out.printf("\nДо Вашей даты в течение %d дней доступны следующие поездки: \n", days);
                        System.out.println("-------------------------------------------------------");
                        tripList.stream().filter(x -> x.getStartDate().isAfter(dateFrom.minusDays(days).atStartOfDay()) &&
                                        x.getStartDate().isBefore(dateFrom.atStartOfDay()))
                                .map(x -> x.getSource() + "(" + x.getStartDate() + ")" + " - " +
                                        x.getDestination() + "(" + x.getReturnDate() + ")")
                                .collect(Collectors.toList())
                                .forEach(System.out::println);
                    }
                    case "J" -> {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                        String finishDate = scannerDecorator.getString("\nВведите интересующую Вас дату " +
                                "(в формате ДД.ММ.ГГГГ): ");
                        LocalDate dateFrom = LocalDate.parse(finishDate, formatter);
                        long days = scannerDecorator.getLong("\nВведите временной интервал (в днях): ");
                        System.out.printf("\nПосле Вашей даты в течение %d дней доступны следующие поездки: \n", days);
                        System.out.println("-------------------------------------------------------");
                        tripList.stream().filter(x -> x.getReturnDate().isAfter(dateFrom.atStartOfDay()) &&
                                        x.getReturnDate().isBefore(dateFrom.plusDays(days).atStartOfDay()))
                                .map(x -> x.getSource() + "(" + x.getStartDate() + ")" + " - " +
                                        x.getDestination() + "(" + x.getReturnDate() + ")")
                                .collect(Collectors.toList())
                                .forEach(System.out::println);
                        System.out.printf("\nДо Вашей даты в течение %d дней доступны следующие поездки: \n", days);
                        System.out.println("-------------------------------------------------------");
                        tripList.stream().filter(x -> x.getReturnDate().isAfter(dateFrom.minusDays(days).atStartOfDay()) &&
                                        x.getReturnDate().isBefore(dateFrom.atStartOfDay()))
                                .map(x -> x.getSource() + "(" + x.getStartDate() + ")" + " - " +
                                        x.getDestination() + "(" + x.getReturnDate() + ")")
                                .collect(Collectors.toList())
                                .forEach(System.out::println);
                    }
                    case "X" -> System.exit(0);
                    default -> System.out.println("Выберете букву из предложенных. ");
                }
            }

        } catch (IllegalStateException | NoSuchElementException e) {
        }
    }
}
