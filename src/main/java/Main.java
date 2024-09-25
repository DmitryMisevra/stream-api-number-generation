import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("Laptop", 1200.0),
                new Order("Smartphone", 800.0),
                new Order("Laptop", 1500.0),
                new Order("Tablet", 500.0),
                new Order("Smartphone", 900.0)
        );

        // группировка заказов по продуктам и суммирование общей стоимости
        Map<String, Double> groupedProduct = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getProduct,
                        Collectors.summingDouble(Order::getCost)
                ));

        // Сортировка по убыванию суммы quantity и выбор 3 самых дорогих продукта
        List<Map.Entry<String, Double>> sortedProducts = groupedProduct.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(3) // Выбор 3 самых качественных продуктов
                .toList();

        // вывод на экран
        System.out.println("Три самых дорогих продукта и их общая стоимость:");
        sortedProducts.forEach(entry ->
                System.out.println("Продукт: " + entry.getKey() + ", Общая стоимость: " + entry.getValue())
        );
    }
}
