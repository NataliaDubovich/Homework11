package Task3;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String[] inputArray = {"1, 2, 0", "4, 5"};
        String result = Arrays.stream(inputArray)   // Перетворення масиву на стрім
                .flatMap(s -> Arrays.stream(s.split(", "))) // Розділення кожного рядка на частини
                .map(Integer::parseInt)                     // Перетворення кожної частини на число
                .sorted()                                   // Сортування чисел
                .map(String::valueOf)                       // Перетворення чисел назад у рядки
                .collect(Collectors.joining(", "));         // Об'єднання рядків із комами
        System.out.println(result);
    }
}
