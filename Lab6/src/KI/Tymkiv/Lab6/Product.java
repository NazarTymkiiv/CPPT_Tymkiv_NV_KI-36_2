package KI.Tymkiv.Lab6;

/**
 * Клас, що представляє товар.
 * Реалізує інтерфейс Comparable для можливості порівняння товарів за ціною.
 */
public class Product implements Comparable<Product> {
    private String name;
    private int price;


    /**
     * Конструктор для створення товару.
     * @param price ціна товару
     * @param name назва товару
     */
    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Повертає назву товару.
     * @return назва товару
     */
    public String getName() {
        return name;
    }

    /**
     * Встановлює назву товару.
     * @param name нова назва товару
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Повертає ціну товару.
     * @return ціна товару
     */
    public int getPrice() {
        return price;
    }

    /**
     * Встановлює ціну товару.
     * @param price нова ціна товару
     */
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int compareTo(Product other) {
        // Порівнюємо товари за ціною
        return Integer.compare(this.price, other.price);
    }

    @Override
    public String toString() {
        return "Product{name='" + name + '\'' + ", price=" + price + '}';
    }
}