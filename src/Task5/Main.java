package Task5;

import java.util.Iterator;
import java.util.stream.Stream;

public class Main {

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> secondIterator = second.iterator();

        return first
                .filter(ignore -> secondIterator.hasNext())
                .flatMap(item -> Stream.of(item, secondIterator.next()));
    }

    public static void main(String[] args) {
        Stream<Integer> first = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> second = Stream.of(10, 20, 30, 40);

        Stream<Integer> zipped = zip(first, second);
        zipped.forEach(System.out::println);
    }
}
