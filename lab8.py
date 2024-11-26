import os
import struct
import sys

import math 

# Функція для запису результату в текстовий файл
# fName: Ім'я файлу для запису
# result: Результат, який буде записаний (перетворюється на рядок)
def writeResTxt(fName, result):
    # Відкриття файлу в режимі запису і запис результату
    with open(fName, 'w') as f:
        f.write(str(result))

# Функція для зчитування результату з текстового файлу
# fName: Ім'я файлу для зчитування
# Повертає вміст файлу у вигляді числа з плаваючою точкою
def readResTxt(fName):
    result = 0.0
    try:
        # Перевірка, чи існує файл
        if os.path.exists(fName):
            # Відкриття файлу в режимі читання і зчитування вмісту
            with open(fName, 'r') as f:
                result = f.read()
        else:
            # Генерується виключення, якщо файл не знайдено
            raise FileNotFoundError(f"Файл {fName} не знайдено.")
    except FileNotFoundError as e:
        # Обробка виключення, виведення повідомлення про помилку
        print(e)
    return result

# Функція для запису результату в бінарний файл
# fName: Ім'я файлу для запису
# result: Результат, який буде записаний у бінарному форматі
def writeResBin(fName, result):
    # Відкриття файлу в бінарному режимі і запис результату у форматі 'f' (float)
    with open(fName, 'wb') as f:
        f.write(struct.pack('f', result))

# Функція для зчитування результату з бінарного файлу
# fName: Ім'я файлу для зчитування
# Повертає результат як число з плаваючою точкою
def readResBin(fName):
    result = 0.0
    try:
        # Перевірка, чи існує файл
        if os.path.exists(fName):
            # Відкриття файлу в бінарному режимі і зчитування вмісту
            with open(fName, 'rb') as f:
                result = struct.unpack('f', f.read())[0]
        else:
            # Генерується виключення, якщо файл не знайдено
            raise FileNotFoundError(f"Файл {fName} не знайдено.")
    except FileNotFoundError as e:
        # Обробка виключення, виведення повідомлення про помилку
        print(e)
    return result

# Функція для обчислення 1 / sin(x)
# x: Вхідне число
# Повертає результат
def calculate(x):
    return (1 / math.sin(x))

# Основна частина програми
if __name__ == "__main__":
    # Отримання даних від користувача
    data = float(input("Введіть число: "))
    
    # Обчислення результату
    result = calculate(data)
    print(f"Результат: {result}")
    
    try:
        # Запис результату в текстовий і бінарний файли
        writeResTxt("textRes.txt", result)
        writeResBin("binRes.bin", result)
        
        # Зчитування та виведення результатів із файлів
        print(f"Результат з бінарного файлу: {readResBin("binRes.bin")}")
        print(f"Результат з текстового файлу: {readResTxt("textRes.txt")}")
    except FileNotFoundError as e:
        # Обробка виключень, якщо файли не знайдено
        print(e)
        sys.exit(1)
