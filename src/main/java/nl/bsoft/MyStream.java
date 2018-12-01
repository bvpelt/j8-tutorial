package nl.bsoft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

public class MyStream {
    private final Logger logger = LoggerFactory.getLogger(MyStream.class);

    public void doFilter() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        filtered.forEach(System.out::println);
    }

    public void doPrint() {
        Random random = new Random();
        random.ints(1, 10).limit(20).forEach(System.out::println);
    }

    public void doMap() {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        //get list of unique squares
        List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        squaresList.stream().sorted().forEach(System.out::println);
    }

    public void doParallel() {
        Random random = new Random();
        random.ints(1, 10).parallel().limit(200).distinct().forEach(System.out::println);

        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");

        //get count of empty string
        long count = strings.parallelStream().filter(string -> string.isEmpty()).count();
        logger.info("count: {}", count);

    }

    public void doCollectors() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        logger.info("Filtered List: {}", filtered);
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        logger.info("Merged String: {}", mergedString);
    }

    public void statistics() {
        List numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        List<Integer> integers = new ArrayList<>();
        IntSummaryStatistics stats = integers.parallelStream().mapToInt((x) -> x).summaryStatistics();

        logger.info("Highest number in List : {}", stats.getMax());
        logger.info("Lowest number in List  : {}", stats.getMin());
        logger.info("Sum of all numbers     : {}", stats.getSum());
        logger.info("Average of all numbers : {}", stats.getAverage());
    }

    public void pipeline() {
        List<String> myList =
                Arrays.asList("a1", "a2", "b1", "c2", "c1");

        myList
                .stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }

    public void findFirst() {
        Arrays.asList("first", "second", "third")
                .stream()
                .findFirst()
                .ifPresent(System.out::println);  // first
    }

    public void sum01() {
        Arrays.stream(new int[] {1, 2, 3})
                .average()
                .ifPresent(System.out::println);  // 6/3=2

        Arrays.stream(new int[] {1, 2, 3}) // 3+5+7/3 = 15/3=5
                .map(n -> 2 * n + 1)
                .average()
                .ifPresent(System.out::println);  // 5.0
    }
}
