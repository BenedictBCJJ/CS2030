import java.util.ArrayList;
public class Combo extends Food {
    ArrayList<Food> comboList = new ArrayList<>();
    private int price = -50;
    
    Combo(int register, String type, String name){
        this.register = register;
        this.type = type;
        this.name = name;
    }

    public void add(Food food) {
        comboList.add(food);
        this.price += food.getPrice();
    }

    @Override
    public String toString() {
        return this.combo.toString();
    }
    
    public void items() {
        for(Food food : comboList) {
            System.out.println("    " + food);
        }
    }
}
