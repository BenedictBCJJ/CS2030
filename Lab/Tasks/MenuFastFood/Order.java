class Order {
    private final Menu menu;

    Order (Menu menu) {
        this.menu = menu;
    }

    public void add(int[] orders) {
        int totalPrice = 0;
        for(int order: orders) {
            Food currentOrder = this.menu.get(order);
            System.out.println(currentOrder);
            totalPrice += currentOrder.getPrice();
        }
        System.out.println("Total: " + totalPrice);
    }
    @Override
    public String toString() {
        return"";
    }

}

