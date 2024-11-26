package KI.Tymkiv.Lab2;

import java.io.IOException;

/**
 * Клас для моделювання роботи кондиціонера.
 * Він включає в себе такі компоненти, як компресор, фільтр, термостат, і дозволяє керувати станом кондиціонера.
 * Також ведеться логування дій кондиціонера.
 */
public class Conditioner {
    private Compressor compressor;
    private Filter filter;
    private Thermostat thermostat;
    private Logger logger;
    private boolean isOn;
    private String mode;
    private int fanSpeed;

    /**
     * Конструктор за замовчуванням. Створює новий об'єкт кондиціонера з початковими налаштуваннями.
     * Логування початкового стану записується у файл.
     *
     * @throws IOException якщо виникає помилка при створенні або запису у файл логів
     */
    public Conditioner() throws IOException {
        this.compressor = new Compressor();
        this.filter = new Filter();
        this.thermostat = new Thermostat();
        this.isOn = false;
        this.mode = "Cool";
        this.fanSpeed = 1;

        this.logger = new Logger("conditioner_log.txt");
        logger.log(String.format("Кондиціонер %s створено.", this.toString()));
    }

    /**
     * Конструктор з параметрами. Дозволяє створити кондиціонер з заданими компонентами.
     * Логування початкового стану записується у файл.
     *
     * @param compressor об'єкт компресора
     * @param filter об'єкт фільтра
     * @param thermostat об'єкт термостата
     * @throws IOException якщо виникає помилка при створенні або запису у файл логів
     */
    public Conditioner(Compressor compressor, Filter filter, Thermostat thermostat) throws IOException {
        this.compressor = compressor;
        this.filter = filter;
        this.thermostat = thermostat;
        this.isOn = false;
        this.mode = "Cool";
        this.fanSpeed = 1;

        this.logger = new Logger("conditioner_log.txt");
        logger.log(String.format("Кондиціонер %s створено.", this.toString()));
    }

    /**
     * Увімкнення кондиціонера. Запускає компресор, змінює стан кондиціонера на "увімкнено" та записує це у лог.
     *
     * @throws IOException якщо виникає помилка при записі у файл логів
     */
    public void turnOn() throws IOException {
        if (!isOn) {
            compressor.start();
            isOn = true;
            logger.log("Кондиціонер увімкнено.");
            System.out.println("Кондиціонер увімкнено.");
        } else {
            logger.log("Кондиціонер вже увімкнено.");
            System.out.println("Кондиціонер вже увімкнено.");
        }
    }

    /**
     * Вимкнення кондиціонера. Зупиняє компресор, змінює стан кондиціонера на "вимкнено" та записує це у лог.
     *
     * @throws IOException якщо виникає помилка при записі у файл логів
     */
    public void turnOff() throws IOException {
        if (isOn) {
            compressor.stop();
            isOn = false;
            logger.log("Кондиціонер вимкнено.");
            System.out.println("Кондиціонер вимкнено.");
        } else {
            logger.log("Кондиціонер вже вимкнено.");
            System.out.println("Кондиціонер вже вимкнено.");
        }
    }

    /**
     * Зміна температури кондиціонера. Змінює налаштування термостата, якщо кондиціонер увімкнено.
     *
     * @param temperature нова температура
     * @throws IOException якщо виникає помилка при записі у файл логів
     */
    public void changeTemperature(double temperature) throws IOException {
        if (isOn) {
            thermostat.setTemperature(temperature);
            logger.log(String.format("Температуру встановлено на %s градусів.", temperature));
            System.out.printf("Температуру встановлено на %s градусів.\n", temperature);
        } else {
            logger.log("Неможливо змінити температуру. Кондиціонер вимкнено.");
            System.out.println("Неможливо змінити температуру. Кондиціонер вимкнено.");
        }
    }

    /**
     * Перемикає режим роботи кондиціонера.
     *
     * @param newMode новий режим роботи (наприклад, "Cool", "Heat")
     * @throws IOException якщо виникає помилка при записі у файл логів
     */
    public void switchMode(String newMode) throws IOException {
        if (isOn) {
            this.mode = newMode;
            logger.log(String.format("Режим змінено на %s.", newMode));
            System.out.printf("Режим змінено на %s.\n", newMode);
        } else {
            logger.log("Неможливо змінити режим. Кондиціонер вимкнено.");
            System.out.println("Неможливо змінити режим. Кондиціонер вимкнено.");
        }
    }

    /**
     * Збільшує швидкість вентилятора на 1, якщо вона ще не досягла максимуму.
     *
     * @throws IOException якщо виникає помилка при записі у файл логів
     */
    public void increaseFanSpeed() throws IOException {
        if (isOn) {
            if (fanSpeed < 3) {
                fanSpeed++;
                logger.log(String.format("Швидкість вентилятора збільшено до %d.", fanSpeed));
                System.out.printf("Швидкість вентилятора збільшено до %d.\n", fanSpeed);
            } else {
                logger.log("Досягнуто максимальну швидкість вентилятора.");
                System.out.println("Досягнуто максимальну швидкість вентилятора.");
            }
        } else {
            logger.log("Неможливо змінити швидкість вентилятора. Кондиціонер вимкнено.");
            System.out.println("Неможливо змінити швидкість вентилятора. Кондиціонер вимкнено.");
        }
    }

    /**
     * Зменшує швидкість вентилятора на 1, якщо вона ще не досягла мінімуму.
     *
     * @throws IOException якщо виникає помилка при записі у файл логів
     */
    public void decreaseFanSpeed() throws IOException {
        if (isOn) {
            if (fanSpeed > 1) {
                fanSpeed--;
                logger.log(String.format("Швидкість вентилятора зменшено до %d.", fanSpeed));
                System.out.printf("Швидкість вентилятора зменшено до %d.\n", fanSpeed);
            } else {
                logger.log("Досягнуто мінімальну швидкість вентилятора.");
                System.out.println("Досягнуто мінімальну швидкість вентилятора.");
            }
        } else {
            logger.log("Неможливо змінити швидкість вентилятора. Кондиціонер вимкнено.");
            System.out.println("Неможливо змінити швидкість вентилятора. Кондиціонер вимкнено.");
        }
    }

    /**
     * Очищує фільтр кондиціонера та веде запис у лог.
     *
     * @throws IOException якщо виникає помилка при записі у файл логів
     */
    public void cleanFilter() throws IOException {
        filter.clean();
        logger.log("Фільтр очищено.");
        System.out.println("Фільтр очищено.");
    }

    /**
     * Перевіряє стан фільтра (чистий або забруднений).
     *
     * @throws IOException якщо виникає помилка при записі у файл логів
     */
    public void checkFilterStatus() throws IOException {
        boolean isClean = filter.isClean();
        logger.log(String.format("Стан фільтра: %s", isClean ? "чистий" : "забруднений"));
        System.out.printf("Стан фільтра: %s\n", isClean ? "чистий" : "забруднений");
    }

    /**
     * Виконує технічне обслуговування кондиціонера, включаючи очищення фільтра та перезапуск компресора.
     *
     * @throws IOException якщо виникає помилка при записі у файл логів
     */
    public void performMaintenance() throws IOException {
        cleanFilter();
        compressor.stop();
        compressor.start();
        logger.log("Виконано технічне обслуговування кондиціонера.");
        System.out.println("Виконано технічне обслуговування кондиціонера.");
    }

    /**
     * Виводить поточний статус кондиціонера, включаючи стан, режим, температуру та швидкість вентилятора.
     *
     * @throws IOException якщо виникає помилка при записі у файл логів
     */
    public void getStatus() throws IOException {
        logger.log(String.format("Статус кондиціонера: %s, Режим: %s, Температура: %s, Швидкість вентилятора: %d",
                isOn ? "увімкнено" : "вимкнено", mode, thermostat.getTemperature(), fanSpeed));
        System.out.printf("Статус кондиціонера: %s, Режим: %s, Температура: %s, Швидкість вентилятора: %d\n",
                isOn ? "увімкнено" : "вимкнено", mode, thermostat.getTemperature(), fanSpeed);
    }

    /**
     * Закриває логер для збереження даних у файл.
     *
     * @throws IOException якщо виникає помилка під час закриття логера
     */
    public void closeLogger() throws IOException {
        logger.close();
    }
}
