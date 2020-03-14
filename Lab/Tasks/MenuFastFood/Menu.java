import java.util.ArrayList;
import java.util.List;

public class Menu {
    ArrayList<String> order = new ArrayList<>();
    ArrayList<Food> foodList = new ArrayList<>();
    int register = 0;
    Menu(){}

    public void add(String type, String name, int price) {
        if(!order.contains(type)) {
            order.add(type);
        }
        Food food = new Food(register, type, name, price);
        foodList.add(food);
        System.out.println(food);
        register++;
    }

    
    
    public void add(String comboType, String name, List<Integer> meals) {
        Combo combo = new Combo(register, comboType, name);
        
        for(Integer reg: meals) {
            combo.add(this.get(reg));
        }
        System.out.println(combo);
        for(Integer reg:meals) {
            System.out.println("    " + this.get(reg));
        }
        foodList.add(combo);
        register++;
        
    }

    
    
    
    
    
    
    public void print() {
        order.add("Combo");
        for(String types: order) {
            for(Food food: foodList) {
                if(food.getType() == types && food.getType() == "Combo"){
                    System.out.println(food);
                    ((Combo) food).items();
                } else if (food.getType() == types) {
                    System.out.println(food);
                }
            }
        }
        order.remove("Combo");
    }

    public Food get(int pos) {
        return this.foodList.get(pos);
    }
}
