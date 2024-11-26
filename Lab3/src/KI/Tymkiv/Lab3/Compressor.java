package KI.Tymkiv.Lab3;

/**
 * Клас, що моделює роботу компресора кондиціонера.
 * Компресор може бути увімкнений або вимкнений.
 */
public class Compressor {
    private boolean running;

    /**
     * Конструктор за замовчуванням. Створює компресор у вимкненому стані.
     */
    public Compressor() {
        running = false;
    }

    /**
     * Увімкнення компресора. Змінює стан компресора на "увімкнено".
     */
    public void start() {
        running = true;
    }

    /**
     * Вимкнення компресора. Змінює стан компресора на "вимкнено".
     */
    public void stop() {
        running = false;
    }

    /**
     * Перевіряє, чи працює компресор.
     *
     * @return {@code true}, якщо компресор увімкнено, і {@code false}, якщо вимкнено.
     */
    public boolean isRunning() {
        return running;
    }
}
