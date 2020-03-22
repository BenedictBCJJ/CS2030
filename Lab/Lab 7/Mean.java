public class Mean {
    public final double max;
    public final double min;
    public final double count;
    public final double sum;

    Mean(double max, double min, double sum, double count, double nextNumber) {
        if(Double.isNaN(max) && Double.isNaN(min)) {
            this.max = nextNumber;
            this.min = nextNumber;
        } else {

            if (nextNumber > max) {
                this.max = nextNumber;
            } else {
                this.max = max;
            }

            if (nextNumber < min) {
                this.min = nextNumber;
            } else {
                this.min = min;
            }
        }
        this.sum = sum + nextNumber;
        this.count = count + 1;
    }

    public double normal() {
        if (this.sum == 0 || Double.isNaN(this.max) || Double.isNaN(this.min) || this.min == this.max) {
            return 0;
        } else {
            return ((this.sum / this.count) - this.min) / (this.max - this.min);
        }
    }

}


