import java.util.Scanner;

public class AccountDivider {
    public void start() {
        Scanner scanner = new Scanner(System.in);

        // Запрашиваю кол-во гостей
        int kGuests;
        while (true) {
            System.out.print("Введите количество гостей: ");
            kGuests = scanner.nextInt();
            if (kGuests < 1) {
                System.out.println("Некорректное количество гостей. Гостей не может быть 0.");
            } else {
                break;
            }
        }

        // Добавляю товар
        Calculator calculator = new Calculator();
        while (true) {
            System.out.print("Введите название товара или 'Завершить', чтобы закончить: ");
            String productName = scanner.next();
            if (productName.equalsIgnoreCase("завершить")) {
                break;
            }
            System.out.print("Введите стоимость товара: ");
            double productPrice = scanner.nextDouble();
            calculator.addItem(productName, productPrice);
            System.out.println("Товар успешно добавлен.");
        }

        // Вывод результатов
        System.out.println("Добавленные товары:");
        for (Calculator.Item item : calculator.getItems()) {
            System.out.println(item.getName() + ": " + String.format("%.2f", item.getPrice()) + " руб.");
        }


        calculator.splitBill(kGuests);
    }
}
