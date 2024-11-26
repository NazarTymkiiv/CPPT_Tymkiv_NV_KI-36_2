class Thermostat:
    """Клас Thermostat представляє термостат, який зберігає та управляє температурою."""
    
    def __init__(self, temperature=0):
        """Створює новий термостат із заданою температурою.
        
        Аргументи:
            temperature (float): температура термостата (за замовчуванням: 0)
        """
        self.temperature = temperature
    
    def get_temperature(self):
        """Повертає поточну температуру термостата.
        
        Повертає:
            float: температура термостата
        """
        return self.temperature
    
    def set_temperature(self, temperature):
        """Встановлює нову температуру термостата.
        
        Аргументи:
            temperature (float): нова температура термостата
        """
        self.temperature = temperature

