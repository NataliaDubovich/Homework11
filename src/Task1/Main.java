package Task1;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("Ivan", "Pavlo", "Petro", "Stepan", "Fedir");
        String result = getOddIndexedNames(names);
        System.out.println(result);
    }

    public static String getOddIndexedNames(List<String> names) {
        return IntStream.range(0, names.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> (i + 1) + ". " + names.get(i))  // Створення рядка з індексом і ім'ям
                .collect(Collectors.joining(", "));    // Об'єднання рядків з комами
    }

}
