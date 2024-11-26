package KI.Tymkiv.Lab6;

/**
 * Клас для тестування параметризованого сховища товарів.
 */
public class StorageDriver {
    public static void main(String[] args) {
        Storage<Product> productStorage = new Storage<>();

        // Створення та додавання товарів
        productStorage.addItem(new Product("Телефон", 299));
        productStorage.addItem(new Product("Ноутбук",599));
        productStorage.addItem(new Product("Навушники",199));
        productStorage.addItem(new Product( "Планшет", 899));

        // Пошук найдорожчого товару
        System.out.println("Найдорожчий товар: " + productStorage.findMaxItem());

        // Перевірка роботи інших методів
        Product laptopProduct = new Product("Ноутбук",599);
        System.out.println("Чи є ноутбук у сховищі? " + productStorage.containsItem(laptopProduct));
        productStorage.addItem(laptopProduct);

        // Виведення всіх товарів
        System.out.println("Всі товари у сховищі: ");
        System.out.println(productStorage);

        // Видалення товару
        productStorage.removeItem(laptopProduct);
        System.out.println("Список товарів після видалення ноутбука: ");
        System.out.println(productStorage);

        // Додавання нового товару
        productStorage.addItem(new Product("Смарт-годинник", 799));
        System.out.println("Оновлений список товарів: ");
        System.out.println(productStorage);

        // Очищення сховища
        productStorage.clear();
        System.out.println("Кількість товарів після очищення: " + productStorage.getItemCount());
    }
}
