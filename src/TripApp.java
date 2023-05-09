import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TripApp {

    public static void main(String[] args) {

        Trip tripOne = new Trip("Haren", "Hannover", 34.12,
                "20.05.2023 14:15", "21.05.2023 02:10", "11:55");
        Trip tripTwo = new Trip("Berlin", "Dusseldorf", 87.56,
                "20.05.2023 08:27", "20.05.2023 15:25", "06:58");
        Trip tripThree = new Trip("Haren", "Keln", 21.79,
                "21.05.2023 08:44", "21.05.2023 11:47", "03:03");
        Trip tripFour = new Trip("Hannover", "Berlin", 39.45,
                "21.05.2023 08:31", "21.05.2023 10:16", "01:45");
        Trip tripFive = new Trip("Hannover", "Hamburg", 35.87,
                "20.05.2023 09:20", "21.05.2023 10:36", "01:16");
        Trip tripSix = new Trip("Haren", "Hannover", 42.95,
                "20.05.2023 07:23", "20.05.2023 15:38", "08:15");
        Trip tripSeven = new Trip("Berlin", "Dusseldorf", 65.87,
                "21.05.2023 11:34", "21.05.2023 20:50", "09:16");

        List<Trip> tripList = new ArrayList<>();
        tripList.add(tripOne);
        tripList.add(tripTwo);
        tripList.add(tripThree);
        tripList.add(tripFour);
        tripList.add(tripFive);
        tripList.add(tripSix);
        tripList.add(tripSeven);


        while (true) {
            new TripDialog().initialDialog();

            Scanner scanner = new Scanner(System.in);
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
                    Scanner scannerLowPrice = new Scanner(System.in);
                    Scanner scannerHighPrice = new Scanner(System.in);
                    System.out.println("Задайте нижнюю границу цен:");
                    double lowPrice = scannerLowPrice.nextDouble();
                    System.out.println("Задайте верхнюю границу цен:");
                    double highPrice = scannerHighPrice.nextDouble();
                    tripList.stream()
                            .filter(x -> x.getPrice() >= lowPrice & x.getPrice() <= highPrice)
                            .map(x -> x.getSource() + " - " + x.getDestination() + " - " + x.getPrice() + " Eur")
                            .collect(Collectors.toList())
                            .forEach(System.out::println);
                }
                case "E" -> {
                    Scanner scannerSource = new Scanner(System.in);
                    System.out.println("Введите город отправления:");
                    String sourceCity = scannerSource.nextLine();
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
                    Scanner scannerDestination = new Scanner(System.in);
                    System.out.println("Введите город назначения:");
                    String destinationCity = scannerDestination.nextLine();
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
                case "X" -> System.exit(0);
                default -> System.out.println("Выберете букву из предложенных. ");
            }
        }
    }
}
