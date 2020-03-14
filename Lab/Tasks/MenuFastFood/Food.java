public class Food {
    private final String type;
    private final String food;
    private final int price;
    private final int register;

    Food (int reg, String type, String food, int price){
        this.type = type;
        this.food = food;
        this.price = price;
        this.register = reg;
    }

    public String getType() {
        return this.type;
    }

    public int getPrice() {
        return this.price;
    }

    public Food setPrice(int price) {
        return new Food(this.register, this.type, this.food, price);
    }

    @Override
    public String toString() {
        return "#" + this.register + " " + this.type + ": " + this.food + " (" + price + ")";
    }
}
