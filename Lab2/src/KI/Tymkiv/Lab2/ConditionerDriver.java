package KI.Tymkiv.Lab2;

import java.io.IOException;


/**
 * Клас {@code ConditionerDriver} демонструє використання класу {@code Conditioner}.
 */
public class ConditionerDriver {
    /**
     * Головний метод.
     *
     * @param args аргументи командного рядка (не використовуються).
     */
    public static void main(String[] args) {
        try {
            Conditioner conditioner = new Conditioner();

            conditioner.turnOn();
            conditioner.changeTemperature(23);
            conditioner.switchMode("Heat");
            conditioner.increaseFanSpeed();
            conditioner.decreaseFanSpeed();
            conditioner.cleanFilter();
            conditioner.checkFilterStatus();
            conditioner.performMaintenance();
            conditioner.getStatus();
            conditioner.turnOff();

            conditioner.closeLogger();
        } catch (IOException e) {
            // Обробка помилок, що виникають під час запису в файл
            throw new RuntimeException("Сталася помилка при записі в файл: " + e.getMessage());
        }
    }
}