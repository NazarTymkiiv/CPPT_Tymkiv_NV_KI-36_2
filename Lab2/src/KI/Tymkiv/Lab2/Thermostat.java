package KI.Tymkiv.Lab2;

/**
 * Клас {@code Thermostat} представляє термостат, який зберігає та управляє температурою.
 */
public class Thermostat {
    private double temperature;

    /**
     * Створює новий термостат з заданою температурою.
     *
     * @param temperature температура термостата
     */
    public Thermostat(double temperature) {
        this.temperature = temperature;
    }

    /**
     * Створює новий термостат з початковою температурою 0 градусів.
     */
    public Thermostat() {
        this.temperature = 0;
    }

    /**
     * Повертає поточну температуру термостата.
     *
     * @return температура термостата
     */
    public double getTemperature() {
        return temperature;
    }

    /**
     * Встановлює нову температуру термостата.
     *
     * @param temperature нова температура термостата
     */
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}