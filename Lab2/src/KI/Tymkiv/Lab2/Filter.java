package KI.Tymkiv.Lab2;

/**
 * Клас Filter моделює фільтр кондиціонера.
 * Фільтр може бути чистим або забрудненим.
 */
public class Filter {
    private boolean clean;

    /**
     * Конструктор з параметром, який дозволяє встановити стан фільтра (чистий або забруднений).
     *
     * @param clean стан фільтра: {@code true} для чистого фільтра, {@code false} для забрудненого
     */
    public Filter(boolean clean) {
        this.clean = clean;
    }

    /**
     * Конструктор за замовчуванням, який створює чистий фільтр.
     */
    public Filter() {
        this.clean = true;
    }

    /**
     * Перевіряє, чи є фільтр чистим.
     *
     * @return {@code true}, якщо фільтр чистий, і {@code false}, якщо він забруднений
     */
    public boolean isClean() {
        return clean;
    }

    /**
     * Очищає фільтр, встановлюючи його стан як чистий.
     */
    public void clean() {
        clean = true;
    }

    /**
     * Забруднює фільтр, встановлюючи його стан як забруднений.
     */
    public void soil() {
        clean = false;
    }
}