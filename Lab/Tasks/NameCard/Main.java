import java.util.Scanner;
import java.util.ArrayList;
class Main{
    public static void main(String[] vargs) {
        Scanner sc = new Scanner(System.in);
        int input = 0;
        int position;
        NameCard newCard;
        ArrayList<NameCard> cardList = new ArrayList<>();


        while(input != 5) {
            if (input == 1) {
                newCard = new NameCard(sc.next(), sc.next());
                cardList.add(newCard);
                System.out.println("Namecard " + newCard + " has been successfully added.");
            } else if (input == 2) {
                int count = 1;
                for(NameCard card: cardList) {
                    System.out.println(count + ": " + card);
                    count++;
                }
            } else if (input == 3) {
                position = sc.nextInt();
                newCard = new NameCard(sc.next(), sc.next());
                cardList.set(position - 1, newCard);
                System.out.println("Namecard has been successfully updated to " + newCard + ".");
            } else if (input == 4) {
                position = sc.nextInt();
                System.out.println("Namecard " + cardList.get(position - 1) + " has been successfully deleted.");
                cardList.remove(position - 1);
            }
            
            System.out.println("Enter your operation");
            System.out.println("1 - Add namecard");
            System.out.println("2 - Show all namecards");
            System.out.println("3 - Update namecard");
            System.out.println("4 - Delete namecard");
            System.out.println("5 - Exit");

            input = sc.nextInt();
        }

    }
}
