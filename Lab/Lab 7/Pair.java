public class Pair {
    public final int numerator;
    public final int remainder;

    Pair(int first, int second) {
        if(first < second) {
            this.numerator = second;
            this.remainder = first;
        } else {

            this.numerator = first;
            this.remainder = second;
        }
    }
}
