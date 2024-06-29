package Task5;


import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Main {

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();

        return Stream.generate(() -> {
                    if
                    (firstIterator.hasNext() && secondIterator.hasNext()) {
                        return Arrays.asList(firstIterator.next(), secondIterator.next());
                    } else {
                        return null;
                    }
                })
                .takeWhile(Objects::nonNull)
                .flatMap(List::stream);
    }

    public static void main(String[] args) {
        Stream<Integer> first = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> second = Stream.of(10, 20, 30, 40);

        Stream<Integer> zipped = zip(first, second);
        zipped.forEach(System.out::println);
    }
}
