package Task4;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        long a = 25214903917L;
        long c = 11;
        long m = 2 ^ 48;
        long seed = System.currentTimeMillis() % m;
        Stream<Long> randomNumbers = linearCongruentialGenerator(seed, a, c, m);//безкінечний стрім
        //перших 10 випадкових чисел зі стріму
        randomNumbers.limit(10).forEach(System.out::println);
    }

    public static Stream<Long> linearCongruentialGenerator(long seed, long a, long c, long m) {
        return Stream.iterate(seed, x -> (a * x + c) % m);
    }
}
