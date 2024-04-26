import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    private List<Item> items;

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

    public List<Item> getItems() {
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
        if (part % 10 == 1 &&part % 100 != 11) {
            suffix = "рубль";
        } else if (part % 10 >= 2 &&part % 10 <= 4 && (part % 100 < 10 ||part % 100 >= 20)) {
            suffix = "рубля";
        } else {
            suffix = "рублей";
        }

        System.out.println("Общая сумма счета: " + String.format("%.2f", totalBill) + " " + suffix + ".");
        System.out.println("Каждый гость должен заплатить по: " + String.format("%.2f", perPerson) + " " + suffix + ".");
    }


    static class Item {
        private String name;
        private double price;

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
