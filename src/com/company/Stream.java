package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stream
{
    public static void Test1()
    {
        List<String> myList =
                Arrays.asList("a1", "a2", "b1", "c2", "c1");

        List<String> lTempList = myList
                .stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        lTempList
                .forEach(System.out::println);

    }

    public static void main( String ... argv)
    {
        Test1();
    }
}

/*

.stream()
.filter()
.map(n -> 2 * n + 1)
.sorted()
.forEach(System.out::println);
.findFirst()
.ifPresent(System.out::println);
.stream(new int[] {1, 2, 3})
.average()
.mapToInt(Integer::parseInt)
.mapToObj(i -> "a" + i)
.range(1, 4)
.of(1.0, 2.0, 3.0)
.filter(s -> {
        System.out.println("filter: " + s);
        return true;
    })
.anyMatch(s -> {
        System.out.println("anyMatch: " + s);
        return s.startsWith("A");
    });
.sorted((s1, s2) -> {
        System.out.printf("sort: %s; %s\n", s1, s2);
        return s1.compareTo(s2);
    })
stream.noneMatch(s -> true);


Supplier<Stream<String>> streamSupplier =
    () -> Stream.of("d2", "a2", "b1", "b3", "c")
            .filter(s -> s.startsWith("a"));

streamSupplier.get().anyMatch(s -> true);   // ok
streamSupplier.get().noneMatch(s -> true);  // ok


foos.stream()
    .flatMap(f -> f.bars.stream())
    .forEach(b -> System.out.println(b.name));

.flatMap(o -> Optional.ofNullable(o.nested))
*/