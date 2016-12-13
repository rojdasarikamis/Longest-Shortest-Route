package edu.ceng;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import org.paukov.combinatorics3.Generator;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;



class Arguments {

    public int n;
    @Option(name = "-n", required = true, usage = "number of cities")
    void setN(int n) {

        if(n < 2 || n > 80)
            throw new IllegalArgumentException("ERROR");

        this.n = n;
    }

    @Option(name = "-p", required = true, usage = "specify type of route")
    public P p;
}

public class Main {

    public static void main(String[] args) {


        Arguments arguments = new Arguments();
        CmdLineParser parser = new CmdLineParser(arguments);

        try {

            parser.parseArgument(args);

        } catch (CmdLineException e) {

            System.exit(1);
        }

        Route route = find(arguments.n, arguments.p);
        System.out.println(route.toString());
        System.exit(0);
    }

    public static Route find(int n, P p) {
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
