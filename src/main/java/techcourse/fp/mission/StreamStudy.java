package techcourse.fp.mission;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamStudy {

    public static long countWords() throws IOException {
        String contents = Files.readString(Paths
            .get("/Users/jyeost/java-chess/src/main/resources/techcourse/fp/war-and-peace.txt"));
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        return words.stream()
            .filter(word -> word.length() > 12)
            .count();
    }

    public static List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers.stream()
            .map(number -> 2 * number)
            .collect(Collectors.toList());
    }

    public static long sumAll(List<Integer> numbers) {
        return numbers.stream()
            .mapToInt(number -> number)
            .sum();
    }

    public static long sumOverThreeAndDouble(List<Integer> numbers) {
        return numbers.stream()
            .filter(number -> number > 3)
            .map(number -> number * 2)
            .reduce(Integer::sum)
            .orElse(0);
    }

    public static void printLongestWordTop100() throws IOException {
        String contents = Files.readString(Paths
            .get("/Users/jyeost/java-chess/src/main/resources/techcourse/fp/war-and-peace.txt"));
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        words.stream()
            .filter(word -> word.length() > 12)
            .sorted(Comparator.comparingInt(String::length).reversed())
            .map(String::toLowerCase)
            .distinct()
            .limit(100)
            .forEach(System.out::println);

        //System.out.println(words);
        //System.out.println(words.size());
    }
}
