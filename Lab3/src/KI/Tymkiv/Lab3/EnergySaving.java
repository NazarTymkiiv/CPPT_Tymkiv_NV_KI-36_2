package KI.Tymkiv.Lab3;

import java.io.IOException;

/**
 * Інтерфейс {@code EnergySaving} визначає функціональність для пристроїв, що підтримують режим енергозбереження.
 * Він описує методи для ввімкнення, вимкнення та перевірки стану режиму енергозбереження.
 */
public interface EnergySaving {

    /**
     * Вмикає режим енергозбереження.
     *
     * @throws IOException якщо виникають помилки при логуванні
     */
    void enableEnergySavingMode() throws IOException;

    /**
     * Вимикає режим енергозбереження.
     *
     * @throws IOException якщо виникають помилки при логуванні
     */
    void disableEnergySavingMode() throws IOException;

    /**
     * Перевіряє, чи увімкнено режим енергозбереження.
     *
     * @return {@code true}, якщо режим енергозбереження увімкнено, інакше {@code false}
     * @throws IOException якщо виникають помилки при логуванні
     */
    boolean isEnergySavingModeEnabled() throws IOException;
}
