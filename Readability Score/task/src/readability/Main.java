package readability;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    private static final double A = 4.71;
    private static final double B = 0.5;
    private static final double C = 21.43;
    private static final String[] AGE = {"None", "5-6", "6-7", "7-9", "9-10",
            "10-11", "11-12", "12-13", "13-14", "14-15", "15-16", "16-17", "17-18", "18-24", "24+"};

    public static void main(String[] args) {
        String text = getText(args[0]);
        System.out.println("The text is:");
        System.out.println(text);
        System.out.println();
        int words = countWords(text);
        int sentences = countSentences(text);
        int characters = countCharacters(text);
        double score = calculateScore(sentences, words, characters);
        String age = calculateAge(AGE, score);
        System.out.println(String.format("Words: %d", words));
        System.out.println(String.format("Sentences: %d", sentences) );
        System.out.println(String.format("Characters: %d", characters));
        System.out.println(String.format("The score is: %.2f", score));
        System.out.println(String.format("This text should be understood by %s year olds.", age));
    }

    public static void checkEasyWord() {
        String string = new Scanner(System.in).nextLine();
        if (string.length() <= 100) {
            System.out.println("EASY");
        } else {
            System.out.println("HARD");
        }
    }

    public static void checkEasySentence() {
        String[] sentences = new Scanner(System.in).nextLine().split("[.!?]");
        int sum = 0;
        for (String sentence: sentences) {
            sum += sentence.strip().split("\\s+").length;
        }
        System.out.println((double) sum / sentences.length > 10 ? "HARD" : "EASY");
    }

    public static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public static int countSentences(String str) {
        return str.split("[.!?]").length;
    }

    public static int countWords(String str) {
        String[] sentences = str.split("[.!?]");
        int sum = 0;
        for (String sentence: sentences) {
            sum += sentence.strip().split("\\s+").length;
        }
        return sum;
    }

    public static String getText(String pathToFile) {
        try {
            return readFileAsString(pathToFile);
        } catch (IOException e) {
            System.out.println("Cannot read file: " + e.getMessage());
            return null;
        }
    }

    public static int countCharacters(String text) {
        return text.replaceAll("\\s+", "").length();
    }

    public static double calculateScore(int sentences, int words, int characters) {
        double score = A * ((double) characters / words) + B * ((double) words / sentences) - C;
        return Math.floor(score * 100) / 100;
    }

    public static String calculateAge(String[] ageTable, double score) {
        return ageTable[(int) (score + 0.9)];
    }
}
