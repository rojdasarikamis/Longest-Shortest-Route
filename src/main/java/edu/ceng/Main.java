package edu.ceng;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import org.paukov.combinatorics3.Generator;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Main class
 */
public class Main {

   public static void main(String[] args) {
       // your code goes here
    }

    private static Route find(int n, P p) {

        switch (p) {
            case SHORTEST:
                return findShortest(n);
            case LONGEST:
                return findLongest(n);
            default:
                throw new AssertionError(p);
        }

    }

    static Route findLongest(int n) {
        Optional<Route> max = Generator.combination(IntStream.rangeClosed(0, 80).boxed().collect(Collectors.toList()))
                .simple(n)
                .stream()
                .map(Route::new)
                .max((c1, c2) -> c1.distance() - c2.distance());
        return max.get();
    }

    static Route findShortest(int n) {
        Optional<Route> max = Generator.combination(IntStream.rangeClosed(0, 80).boxed().collect(Collectors.toList()))
                .simple(n)
                .stream()
                .map(Route::new)
                .min((c1, c2) -> c1.distance() - c2.distance());
        return max.get();
    }
}
