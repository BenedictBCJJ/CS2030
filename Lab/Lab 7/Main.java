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
        if(m > n) {
            return Stream.iterate(new int[]{m,n}, x -> x[1] != 0, x -> new int[]{x[1],x[0] % x[1]})
                .map(x -> x[1]).reduce((x,y) -> y).get();
        } else {
            return Stream.iterate(new int[]{n,m}, x -> x[1] != 0, x -> new int[]{x[1],x[0] % x[1]})
                .map(x -> x[1]).reduce((x,y) -> y).get();


        }
    }

    static long countRepeats(int... array) {
        IntStream stream = Arrays.stream(array);

        int[] arr = new int[] {1, 0};

        stream.reduce((x, y) -> { if(x == y) {
            arr[0] += 1;
        } else if (x!=y && arr[0] > 1) {
            arr[1] += 1;
            arr[0] = 1;
        }
        return y;});

        if(arr[0] > 1) {
            arr[1] += 1;
        }

        return arr[1];
    }

    static double normalizedMean(Stream<Integer> stream) {
        DoubleStream doubleStream = stream.mapToDouble(x->x);
        double[] arr = new double[]{0, 0.1, 0};

        double sum = doubleStream.reduce(0,(x, y) ->{
            arr[0] += 1;
            if(arr[1] == 0.1) {
                arr[1] = y;
            }
            if(y < arr[1]) {
                arr[1] = y;
            }
            if (y > arr[2]) {
                arr[2] = y;
            }
            return x + y;});
        
        if(arr[2] == arr[1] || sum == 0) {
            return 0;
        }else{

            return ((sum / arr[0]) - arr[1]) / (arr[2] - arr[1]);
        }


    }


}
