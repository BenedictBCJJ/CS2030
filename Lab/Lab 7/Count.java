public class Count {
    public final int sequenceLength;
    public final int totalRepeats;
    public final int currentNumber;

    Count(int sequenceLength, int currentNumber, int nextNumber, int totalRepeats) {
        if(currentNumber == nextNumber) {
            this.sequenceLength = sequenceLength + 1;
            this.totalRepeats = totalRepeats;
        } else if(sequenceLength > 1) {
            this.totalRepeats = totalRepeats + 1;
            this.sequenceLength = 1;
        } else {
            this.totalRepeats = totalRepeats;
            this.sequenceLength = 1;
        }

        this.currentNumber = nextNumber;
    }

}
