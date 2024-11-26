package KI.Tymkiv.Lab6;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Клас, що представляє параметризоване сховище товарів.
 * @param <T> Тип об'єктів, що зберігаються в сховищі.
 */
public class Storage<T extends Comparable<T>> {
    private List<T> items;

    /**
     * Конструктор, що ініціалізує порожнє сховище товарів.
     */
    public Storage() {
        this.items = new ArrayList<>();
    }

    /**
     * Додає елемент до сховища.
     * @param item Елемент, що додається.
     */
    public void addItem(T item) {
        items.add(item);
    }

    /**
     * Видаляє елемент зі сховища.
     * @param item Елемент, що видаляється.
     */
    public void removeItem(T item) {
        if(!items.remove(item)) {
            throw new NoSuchElementException("Елемент не знайдено!");
        }
    }

    /**
     * Перевіряє наявність елемента в сховищі.
     * @param item Елемент для перевірки.
     * @return true якщо елемент є в сховищі, інакше false.
     */
    public boolean containsItem(T item) {
        return items.contains(item);
    }

    /**
     * Очищає всі елементи зі сховища.
     */
    public void clear() {
        items.clear();
    }

    /**
     * Повертає кількість елементів у сховищі.
     * @return Кількість елементів.
     */
    public int getItemCount() {
        return items.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < items.size(); i++) {
            sb.append(items.get(i));
            if(i != items.size()-1) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }

    /**
     * Повертає максимальний елемент у сховищі.
     * @return Максимальний елемент.
     */
    public T findMaxItem() {
        if (items.isEmpty()) {
            System.out.println("Сховище порожнє.");
            return null;
        }
        T maxItem = items.get(0);
        for (T item : items) {
            if (item.compareTo(maxItem) > 0) {
                maxItem = item;
            }
        }
        return maxItem;
    }
}