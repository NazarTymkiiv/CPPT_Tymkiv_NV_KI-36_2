from Conditioner import Conditioner

class ClimateControlDevice(Conditioner):
    """Клас ClimateControlDevice представляє пристрій для кліматконтролю.
    Він розширює функціональність базового кондиціонера та підтримує
    режими енергозбереження та автоматичне регулювання температури."""
    
    def __init__(self):
        """Конструктор для створення пристрою кліматконтролю."""
        super().__init__()
        self.energy_saving_mode = False
    
    def enable_energy_saving_mode(self):
        """Вмикає режим енергозбереження."""
        self.energy_saving_mode = True
        print("Режим енергозбереження увімкнено.")
    
    def disable_energy_saving_mode(self):
        """Вимикає режим енергозбереження."""
        self.energy_saving_mode = False
        print("Режим енергозбереження вимкнено.")
    
    def is_energy_saving_mode_enabled(self):
        """Перевіряє, чи увімкнено режим енергозбереження.
        
        Повертає:
            bool: True, якщо режим енергозбереження увімкнено, інакше False
        """
        return self.energy_saving_mode
    
    def perform_specific_maintenance(self):
        """Виконує специфічне обслуговування пристрою кліматконтролю."""
        print("Виконується специфічне обслуговування пристрою кліматконтролю.")
    
    def auto_adjust_temperature(self, outdoor_temperature):
        """Автоматично регулює температуру на основі зовнішніх умов.
        
        Аргументи:
            outdoor_temperature (float): зовнішня температура
        """
        if self.is_on:
            if self.energy_saving_mode:
                target_temperature = outdoor_temperature + 2  # Менша різниця для економії енергії
            else:
                target_temperature = outdoor_temperature - 2  # Більша різниця для комфорту
            self.change_temperature(target_temperature)
            print(f"Автоматично встановлено температуру на {target_temperature} градусів.")
        else:
            print("Неможливо автоматично регулювати температуру. Пристрій вимкнено.")