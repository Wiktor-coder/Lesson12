import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Map<Address, Integer> costPerAddress = new HashMap<>();

        costPerAddress.put(new Address("Россия", "Москва"), 200);
        costPerAddress.put(new Address("Россия", "Казань"), 200);
        costPerAddress.put(new Address("Россия", "Екатеринбург"), 200);
        costPerAddress.put(new Address("Россия", "Челябинск"), 200);
        costPerAddress.put(new Address("Россия", "Уфа"), 200);
        costPerAddress.put(new Address("Россия", "Самара"), 200);
        costPerAddress.put(new Address("Россия", "Санкт-Петербург"), 200);
        costPerAddress.put(new Address("США", "Нью-Йорк"), 500);
        costPerAddress.put(new Address("США", "Чикаго"), 500);
        costPerAddress.put(new Address("США", "Хьюстон"), 500);
        costPerAddress.put(new Address("США", "Финикс"), 500);
        costPerAddress.put(new Address("Германия", "Берлин"), 300);
        costPerAddress.put(new Address("Германия", "Гамбург"), 300);
        costPerAddress.put(new Address("Германия", "Мюнхен"), 300);

        int totalCost = 0;
        Set<String> uniqueCountries = new HashSet<>();

        while (true) {
            System.out.println("\nЗаполнение нового заказа.");

            String country;
            while (true) {
                System.out.print("Введите страну: ");
                country = scanner.nextLine().trim();
                if (country.equalsIgnoreCase("end")) {
                    scanner.close();
                    return;
                }
                if (country.isEmpty()) {
                    System.out.println("Ошибка: страна не может быть пустой. Попробуйте снова.");
                } else {
                    break;
                }
            }

            String city;
            while (true) {
                System.out.print("Введите город: ");
                city = scanner.nextLine().trim();
                if (city.isEmpty()) {
                    System.out.println("Ошибка: город не может быть пустым. Попробуйте снова.");
                } else {
                    break;
                }
            }

            Address address = new Address(country, city);
            if (!costPerAddress.containsKey(address)) {
                System.out.println("Доставки по адресу " + country + ", " + city + " нет. Попробуйте другой адрес.");
                continue;
            }

            int weight;
            while (true) {
                System.out.print("Введите вес (кг): ");
                String weightInput = scanner.nextLine().trim();
                try {
                    weight = Integer.parseInt(weightInput);
                    if (weight <= 0) {
                        System.out.println("Ошибка: вес должен быть положительным числом. Попробуйте снова.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: введите целое число для веса. Попробуйте снова.");
                }
            }

            int deliveryCost = costPerAddress.get(address) * weight;
            totalCost += deliveryCost;
            uniqueCountries.add(country);

            System.out.println("Стоимость доставки составит: " + deliveryCost + " руб.");
            System.out.println("Общая стоимость всех доставок: " + totalCost + " руб.");
            System.out.println("Количество уникальных стран доставки: " + uniqueCountries.size());
            System.out.println("Введите end для завершения");

        }
    }
}
