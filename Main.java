import java.util.*;
public class Main {

    public static void main(String[] args) {
        Item item1 = new Item("apple" , 0.50);
        Item item2 = new Item("pear", .75);
        Item item3 = new Item("pineapple", .75);
        //Item item4 = new Item("refrigerator", 800.71);
        ArrayList<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        //items.add(item4);
        String itemList = "";
        int count = 1;
        for(Item i : items){
            itemList += "item " + count + ": " + i.toString() + "\n";
            count++;
        }
        System.out.print(itemList);
        Transaction t1 = new Transaction(items);
        t1.computeSubtotal();
        t1.computeTax();
        t1.computeTotal();
        System.out.println("Total: " + t1.getTotal());
        t1.takePayment();
        Receipt r1 = new Receipt(t1);
        System.out.println(r1.getReceiptString());
        
    }
}
