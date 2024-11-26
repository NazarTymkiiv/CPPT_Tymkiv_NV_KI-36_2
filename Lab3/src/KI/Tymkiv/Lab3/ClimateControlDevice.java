package KI.Tymkiv.Lab3;

import java.io.IOException;

/**
 * Клас {@code ClimateControlDevice} представляє пристрій для кліматконтролю.
 * Він розширює функціональність базового кондиціонера та реалізує інтерфейс {@link EnergySaving}.
 * Підтримує режими енергозбереження та автоматичне регулювання температури.
 */
public class ClimateControlDevice extends Conditioner implements EnergySaving {
    private boolean energySavingMode;

    /**
     * Конструктор для створення пристрою кліматконтролю.
     *
     * @throws IOException якщо виникає помилка при створенні або записі у файл логів
     */
    public ClimateControlDevice() throws IOException {
        super();
        this.energySavingMode = false;
    }

    /**
     * Вмикає режим енергозбереження.
     *
     * @throws IOException якщо виникає помилка при записі у файл логів
     */
    @Override
    public void enableEnergySavingMode() throws IOException {
        this.energySavingMode = true;
        logger.log("Режим енергозбереження увімкнено.");
        System.out.println("Режим енергозбереження увімкнено.");
    }

    /**
     * Вимикає режим енергозбереження.
     *
     * @throws IOException якщо виникає помилка при записі у файл логів
     */
    @Override
    public void disableEnergySavingMode() throws IOException {
        this.energySavingMode = false;
        logger.log("Режим енергозбереження вимкнено.");
        System.out.println("Режим енергозбереження вимкнено.");
    }

    /**
     * Перевіряє, чи увімкнено режим енергозбереження.
     *
     * @return {@code true}, якщо режим енергозбереження увімкнено, інакше {@code false}
     */
    @Override
    public boolean isEnergySavingModeEnabled() {
        return this.energySavingMode;
    }

    /**
     * Виконує специфічне обслуговування пристрою кліматконтролю.
     *
     * @throws IOException якщо виникає помилка при записі у файл логів
     */
    @Override
    public void performSpecificMaintenance() throws IOException {
        logger.log("Виконується специфічне обслуговування пристрою кліматконтролю.");
        System.out.println("Виконується специфічне обслуговування пристрою кліматконтролю.");
    }

    /**
     * Автоматично регулює температуру на основі зовнішніх умов.
     *
     * @param outdoorTemperature зовнішня температура
     * @throws IOException якщо виникає помилка при записі у файл логів
     */
    public void autoAdjustTemperature(double outdoorTemperature) throws IOException {
        if (isOn) {
            double targetTemperature;
            if (energySavingMode) {
                targetTemperature = outdoorTemperature + 2; // Менша різниця для економії енергії
            } else {
                targetTemperature = outdoorTemperature - 2; // Більша різниця для комфорту
            }
            changeTemperature(targetTemperature);
            logger.log(String.format("Автоматично встановлено температуру на %s градусів.", targetTemperature));
            System.out.printf("Автоматично встановлено температуру на %s градусів.\n", targetTemperature);
        } else {
            logger.log("Неможливо автоматично регулювати температуру. Пристрій вимкнено.");
            System.out.println("Неможливо автоматично регулювати температуру. Пристрій вимкнено.");
        }
    }
}
