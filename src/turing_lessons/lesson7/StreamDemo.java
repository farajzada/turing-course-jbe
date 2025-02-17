package turing_lessons.lesson7;

import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.spi.ToolProvider.findFirst;

public class StreamDemo implements Serializable {
    public static void main(String[] args) {
        /*int[] arr = {1, 2, 3, 4, 5,6,7,8,9,10};
        for (int j : arr) {
            if (j == 5) {
                System.out.println("Found 5");
                break;
            }
        }*/

//        foo(null);
//        foo("Hello");

        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .filter(integer -> integer % 2 == 0)
                .reduce(Integer::sum)
                .ifPresent(System.out::println);
    }

    public static void foo(String value) {

        try {
            Optional<String> optional = Optional.of(value);

        } catch (Exception e) {
            Optional<String> optional1 = Optional.ofNullable(value);

        }

        Collection<Integer> integers = Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Stream<Collection<Integer>> integers1 = Stream.of(integers);

        integers.stream()
                .filter(i -> i == 5)
                .findFirst()
                .ifPresent(i -> System.out.println("Found 5"));
//        Stream.of().reduce()

//        Stream.of(integers)
//                .filter(i -> i == 5)
//                .findFirst()
//                .ifPresent(i -> System.out.println("Found 5"));



    }
}
