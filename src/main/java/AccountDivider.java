import java.util.InputMismatchException;
import java.util.Scanner;

public class AccountDivider {
    public void start() {
        Scanner scanner = new Scanner(System.in);

        // Запрашиваю кол-во гостей
        int kGuests;
        while (true) {
            try {
                System.out.print("Введите количество гостей: ");
                kGuests = scanner.nextInt();
                if (kGuests < 1) {
                    System.out.println("Некорректное количество гостей. Гостей не может быть 0.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод. Введите целое положительное число.");
                scanner.nextLine(); // Очистка буфера
            }
        }


        // Добавление товаров
        Calculator calculator = new Calculator();
        int itemsCount = calculator.getItems().size();
        while (true) {
            System.out.print("Введите название товара или 'Завершить', чтобы закончить: ");
            String productName = scanner.next();
            if (productName.equalsIgnoreCase("завершить")) {
                break;
            }
            System.out.print("Введите стоимость товара: ");
            double productPrice;
            while (true) {
                try {
                    productPrice = Double.parseDouble(scanner.next());
                    if (productPrice <= 0) {
                        throw new NumberFormatException();
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: стоимость товара должна быть положительным числом. Повторите ввод.");
                }
            }
            calculator.addItem(productName, productPrice);
            if (calculator.getItems().size() > itemsCount) {
                System.out.println("Товар успешно добавлен.");
                itemsCount++;
            }
        }




        // Вывод результатов
        System.out.println("Добавленные товары:");
        for (Calculator.Item item : calculator.getItems()) {
            System.out.println(item.getName() + ": " + String.format("%.2f", item.getPrice()) + " руб.");
        }

        calculator.splitBill(kGuests);
    }
}
