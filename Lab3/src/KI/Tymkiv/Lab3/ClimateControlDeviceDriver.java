package KI.Tymkiv.Lab3;

import java.io.IOException;

/**
 * Клас {@code ConditionerDriver} демонструє використання класу {@code Conditioner}.
 */
public class ClimateControlDeviceDriver {
    /**
     * Головний метод.
     *
     * @param args аргументи командного рядка (не використовуються).
     */
    public static void main(String[] args) {
        try {
            ClimateControlDevice device = new ClimateControlDevice();

            device.turnOn();
            device.changeTemperature(22);
            device.switchMode("Cool");
            device.increaseFanSpeed();
            device.enableEnergySavingMode();
            device.autoAdjustTemperature(30);
            device.performSpecificMaintenance();
            device.getStatus();
            device.disableEnergySavingMode();
            device.turnOff();

            device.closeLogger();
        } catch (IOException e) {
            // Обробка помилок, що виникають під час запису в файл
            throw new RuntimeException("Сталася помилка при записі в файл: " + e.getMessage());
        }
    }
}
