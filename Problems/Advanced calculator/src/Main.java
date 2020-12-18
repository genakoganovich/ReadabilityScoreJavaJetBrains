import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

class Problem {
    private static final int MAX = 9999;

    public static void main(String[] args) {
        String pathToFile = "c:\\Users\\Gena\\Downloads\\dataset_91065.txt";
        File file = new File(pathToFile);
        try(Scanner scanner = new Scanner(file)) {
            int count = 0;
            while (scanner.hasNext()) {
                int value = scanner.nextInt();
                if (value == 0) {
                    break;
                }
                if (value % 2 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + pathToFile);
        }
    }
    public static void countBig() {
        String pathToFile = "c:\\Users\\Gena\\Downloads\\dataset_91022.txt";
        File file = new File(pathToFile);
        try(Scanner scanner = new Scanner(file)) {
            int count = 0;
            while (scanner.hasNextInt()) {
                if (scanner.nextInt() >= MAX) {
                    count++;
                }
            }
            System.out.println(count);
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + pathToFile);
        }
    }
    public static void sum() {
        String pathToFile = "c:\\Users\\Gena\\Downloads\\dataset_91033.txt";
        File file = new File(pathToFile);
        try(Scanner scanner = new Scanner(file)) {
            int sum = 0;
            while (scanner.hasNextInt()) {
                sum += scanner.nextInt();
            }
            System.out.println(sum);
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + pathToFile);
        }
    }
    public static void findMaxIncrease() {
        String pathToFile = "c:\\Users\\Gena\\Downloads\\dataset_91069.txt";
        File file = new File(pathToFile);
        try(Scanner scanner = new Scanner(file)) {
            scanner.nextLine();
            String[] columns = scanner.nextLine().split("\\s+");
            String maxYear = columns[0];
            long previousPopulation = NumberFormat
                    .getNumberInstance(Locale.US)
                    .parse(columns[1])
                    .longValue();
            long maxIncrease = 0;

            while (scanner.hasNext()) {
                columns = scanner.nextLine().split("\\s+");
                String year = columns[0];
                long population = NumberFormat
                        .getNumberInstance(Locale.US)
                        .parse(columns[1])
                        .longValue();
                if (population - previousPopulation > maxIncrease) {
                    maxIncrease = population - previousPopulation;
                    maxYear = year;
                }
                previousPopulation = population;
            }
            System.out.println(maxYear);
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + pathToFile);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public static void printMax() {
        String pathToFile = "c:\\Users\\Gena\\Downloads\\dataset_91007.txt";
        File file = new File(pathToFile);
        try(Scanner scanner = new Scanner(file)) {
            int max = scanner.nextInt();
            while (scanner.hasNext()) {
                int value = scanner.nextInt();
                if (value > max) {
                    max = value;
                }
            }
            System.out.println(max);
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + pathToFile);
        }
    }
}