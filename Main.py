from ClimateControlDevice import ClimateControlDevice
from Conditioner import Conditioner

if __name__ == "__main__":
    """Головна функція, що демонструє використання ClimateControlDevice."""
    try:
        device = ClimateControlDevice()
        
        device.turn_on()
        device.change_temperature(22)
        device.switch_mode("Cool")
        device.increase_fan_speed()
        device.enable_energy_saving_mode()
        device.auto_adjust_temperature(30)
        device.perform_specific_maintenance()
        device.get_status()
        device.disable_energy_saving_mode()
        device.turn_off()
        
    except Exception as e:
        raise RuntimeError(f"Сталася помилка: {str(e)}")
