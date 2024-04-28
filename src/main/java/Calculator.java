import java.util.ArrayList;
import java.util.List;


public class Calculator {

    List<Item> items;

    public Calculator() {
        this.items = new ArrayList<>();
    }

    public void addItem(String name, double price) {
        items.add(new Item(name, price));
    }

    public double getTotalBill() {
        double total = 0.0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }

     List<Item> getItems() {
        return items;
    }

    public void splitBill(int  kGuests) {
        double totalBill = getTotalBill();
        double perPerson;
        if ( kGuests > 1) {
            perPerson = totalBill /  kGuests;
        } else {
            perPerson = totalBill;
        }

        // Определение окончания для "рубль"
        String suffix;
        int part = (int) totalBill;
        int finalNumbers = part % 100;
        if (part % 10 == 1 && finalNumbers != 11) {
            suffix = "рубль";
        } else if (part % 10 >= 2 && part % 10 <= 4 && !(finalNumbers >= 12 && finalNumbers <= 14)) {
            suffix = "рубля";
        } else {
            suffix = "рублей";
        }


        System.out.println("Общая сумма счета: " + String.format("%.2f", totalBill) + " " + suffix + ".");
        System.out.println("Каждый гость должен заплатить по: " + String.format("%.2f", perPerson) + " " + suffix + ".");
    }


    static class Item {
        String name;
        double price;

        public Item(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }
}
