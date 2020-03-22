import java.util.stream.IntStream;
import java.util.function.Function;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.DoubleStream;
import java.util.Comparator;

public class Main{
    static int[] twinPrimes(int n) {
        Function<Integer,Boolean> isPrime = g -> IntStream.range(2, g).noneMatch(x -> g % x == 0);
        IntStream stream = IntStream.rangeClosed(3, n)
            .filter(x -> isPrime.apply(x) && (isPrime.apply(x + 2) ||isPrime.apply(x - 2)));
        return stream.toArray();    
    }

    static int gcd(int m, int n) {
        return Stream.iterate(new Pair(m,n), x -> x.remainder != 0, 
                x -> new Pair(x.remainder,x.numerator % x.remainder))
            .map(x -> x.remainder).reduce((x,y) -> y).get();
    }

    static long countRepeats(int... array) {
        final Stream<Count> stream = Arrays.stream(array)
            .mapToObj(x -> new Count(1, 0, x, 0) );

        final Count totalRepeats = stream
            .reduce(new Count(1, 10, 11, 0),
                    (x, y) -> new Count (x.sequenceLength, x.currentNumber, y.currentNumber, x.totalRepeats));
        
        if(totalRepeats.sequenceLength > 1) {
            return totalRepeats.totalRepeats + 1;
        } else {
            return totalRepeats.totalRepeats;
        }
    }

    static double normalizedMean(Stream<Integer> stream) {
        final Stream<Mean> meanStream = stream.map(x -> new Mean(Double.NaN, Double.NaN, 0, 0, x));

        final Mean sum = meanStream.reduce((x, y) -> new Mean(x.max, x.min, x.sum, x.count, y.max))
            .orElse(new Mean(0,0,0,0,0));

        return sum.normal();
    }


}
