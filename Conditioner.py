from Compressor import Compressor
from Filter import Filter
from Thermostat import Thermostat

class Conditioner:
    """Клас для моделювання роботи кондиціонера.
    Він включає в себе такі компоненти, як компресор, фільтр, термостат,
    і дозволяє керувати станом кондиціонера."""
    
    def __init__(self, compressor=None, filter_obj=None, thermostat=None):
        """Конструктор за замовчуванням. Створює новий об'єкт кондиціонера з початковими налаштуваннями.
        
        Аргументи:
            compressor (Compressor, необов'язковий): об'єкт компресора
            filter_obj (Filter, необов'язковий): об'єкт фільтра
            thermostat (Thermostat, необов'язковий): об'єкт термостата
        """
        self.compressor = compressor if compressor else Compressor()
        self.filter = filter_obj if filter_obj else Filter()
        self.thermostat = thermostat if thermostat else Thermostat()
        self.is_on = False
        self.mode = "Cool"
        self.fan_speed = 1
        
    def perform_specific_maintenance(self):
        """Абстрактний метод для виконання специфічного обслуговування.
        Повинен бути реалізований у підкласах."""
        raise NotImplementedError("Цей метод повинен бути реалізований у підкласах")
        
    def turn_on(self):
        """Вмикає кондиціонер. Запускає компресор та змінює стан на "увімкнено"."""
        if not self.is_on:
            self.compressor.start()
            self.is_on = True
            print("Кондиціонер увімкнено.")
        else:
            print("Кондиціонер вже увімкнено.")
    
    def turn_off(self):
        """Вимикає кондиціонер. Зупиняє компресор та змінює стан на "вимкнено"."""
        if self.is_on:
            self.compressor.stop()
            self.is_on = False
            print("Кондиціонер вимкнено.")
        else:
            print("Кондиціонер вже вимкнено.")
    
    def change_temperature(self, temperature):
        """Змінює температуру кондиціонера. Змінює налаштування термостата, якщо кондиціонер увімкнено.
        
        Аргументи:
            temperature (float): нова температура
        """
        if self.is_on:
            self.thermostat.set_temperature(temperature)
            print(f"Температуру встановлено на {temperature} градусів.")
        else:
            print("Неможливо змінити температуру. Кондиціонер вимкнено.")
    
    def switch_mode(self, new_mode):
        """Перемикає режим роботи кондиціонера.
        
        Аргументи:
            new_mode (str): новий режим роботи (наприклад, "Cool", "Heat")
        """
        if self.is_on:
            self.mode = new_mode
            print(f"Режим змінено на {new_mode}.")
        else:
            print("Неможливо змінити режим. Кондиціонер вимкнено.")
    
    def increase_fan_speed(self):
        """Збільшує швидкість вентилятора на 1, якщо вона ще не досягла максимуму."""
        if self.is_on:
            if self.fan_speed < 3:
                self.fan_speed += 1
                print(f"Швидкість вентилятора збільшено до {self.fan_speed}.")
            else:
                print("Досягнуто максимальну швидкість вентилятора.")
        else:
            print("Неможливо змінити швидкість вентилятора. Кондиціонер вимкнено.")
    
    def decrease_fan_speed(self):
        """Зменшує швидкість вентилятора на 1, якщо вона ще не досягла мінімуму."""
        if self.is_on:
            if self.fan_speed > 1:
                self.fan_speed -= 1
                print(f"Швидкість вентилятора зменшено до {self.fan_speed}.")
            else:
                print("Досягнуто мінімальну швидкість вентилятора.")
        else:
            print("Неможливо змінити швидкість вентилятора. Кондиціонер вимкнено.")
    
    def clean_filter(self):
        """Очищує фільтр кондиціонера."""
        self.filter.clean_filter()
        print("Фільтр очищено.")
    
    def check_filter_status(self):
        """Перевіряє стан фільтра (чистий або забруднений)."""
        is_clean = self.filter.is_clean()
        print(f"Стан фільтра: {'чистий' if is_clean else 'забруднений'}")
    
    def perform_maintenance(self):
        """Виконує технічне обслуговування кондиціонера, включаючи очищення фільтра та перезапуск компресора."""
        self.clean_filter()
        self.compressor.stop()
        self.compressor.start()
        print("Виконано технічне обслуговування кондиціонера.")
    
    def get_status(self):
        """Виводить поточний статус кондиціонера, включаючи стан, режим, температуру та швидкість вентилятора."""
        print(f"Статус кондиціонера: {'увімкнено' if self.is_on else 'вимкнено'}, "
              f"Режим: {self.mode}, Температура: {self.thermostat.get_temperature()}, "
              f"Швидкість вентилятора: {self.fan_speed}")