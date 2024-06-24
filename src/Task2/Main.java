package Task2;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static List<String> sortAndUppercase(List<String> input) {
        return input.stream()
                .map(String::toUpperCase)
                .sorted((s1, s2) -> s2.compareTo(s1))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> names = List.of("Ivan", "Pavlo", "Petro", "Stepan", "Fedir");
        List<String> sortedUppercase = sortAndUppercase(names);
        System.out.println(sortedUppercase);
    }
}

