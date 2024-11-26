# Запитуємо у користувача розмір квадрата
n_rows = int(input("Введіть розмір квадрата: "))

# Запитуємо у користувача символ для заповнення квадрата
symbol = input("Введіть символ для заповнення: ")

if len(symbol) == 0:
    print("Некорректний символ. Відсутній символ.")
    exit()
elif len(symbol) > 1:
    print("Некорректний ввід. Забагато символів.")
    exit()

symbol = symbol[0]

# Створюємо двовимірний масив для зберігання символів квадрата
arr = []
for i in range(n_rows):
    if i < n_rows // 2:
        arr.append([symbol] * (n_rows - 2 * i))
    else:
        arr.append([symbol] * (n_rows - (2 * (n_rows - i-1))))

# Заповнюємо квадрат символами
for i in range(n_rows):
    if(i < n_rows // 2):
        print(" " * i, end = '')
        print(symbol * (n_rows - 2 * i), end = '')
    else:
        print(" " * (n_rows - i-1), end = '')
        print(symbol * (n_rows - (2 * (n_rows - i-1))), end = '')
    # Додаємо новий рядок на екран
    print()
