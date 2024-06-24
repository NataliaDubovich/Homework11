package Task5;


import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import java.util.Spliterator;
import java.util.Spliterators;

public class Main {

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();

        Iterator<T> zippedIterator = new Iterator<>() {
            private boolean isFirst = true;

            @Override
            public boolean hasNext() {
                return firstIterator.hasNext() && secondIterator.hasNext();
            }

            @Override
            public T next() {
                T nextElement;
                if (isFirst) {
                    nextElement = firstIterator.next();
                } else {
                    nextElement = secondIterator.next();
                }
                isFirst = !isFirst;
                return nextElement;
            }
        };

        Spliterator<T> spliterator = Spliterators.spliteratorUnknownSize(zippedIterator, Spliterator.ORDERED);
        return StreamSupport.stream(spliterator, false);
    }

    public static void main(String[] args) {
        Stream<Integer> first = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> second = Stream.of(10, 20, 30, 40);

        Stream<Integer> zipped = zip(first, second);
        zipped.forEach(System.out::println);
    }
}