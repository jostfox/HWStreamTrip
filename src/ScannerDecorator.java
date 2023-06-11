import java.util.Scanner;

public class ScannerDecorator implements RequestScanner{

    Scanner scanner;

    public ScannerDecorator(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public long getLong(String text) {
        System.out.println(text);
        long variableLong = scanner.nextLong();
        return variableLong;
    }

    @Override
    public String getString(String text) {
        System.out.println(text);
        String variableString = scanner.nextLine();
        return variableString;
    }

    @Override
    public double getDouble(String text) {
        System.out.println(text);
        double variableDouble = scanner.nextDouble();
        return variableDouble;
    }
}
