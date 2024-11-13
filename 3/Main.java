import repo.InMemoryNumberRepositoryImpl;
import repo.NumberRepository;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NumberRepository repository = new InMemoryNumberRepositoryImpl();

        // Ввод массива
        System.out.print("Введите количество элементов в массиве: ");
        int n = scanner.nextInt();
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            repository.add(scanner.nextInt());
        }

        // Вывод отсортированного массива
        System.out.println("Отсортированный массив:");
        int[] arr = repository.getAll();
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Меню операций
        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Добавить элемент");
            System.out.println("2. Показать все элементы");
            System.out.println("3. Обновить элемент");
            System.out.println("4. Удалить элемент");
            System.out.println("0. Выйти");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Добавить элемент
                    System.out.print("Введите элемент: ");
                    repository.add(scanner.nextInt());
                    break;

                case 2: // Показать все элементы
                    int[] allNumbers = repository.getAll();
                    System.out.println("Элементы: ");
                    for (int num : allNumbers) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                    break;

                case 3: // Обновить элемент
                    System.out.print("Введите старый элемент: ");
                    int oldNumber = scanner.nextInt();
                    System.out.print("Введите новый элемент: ");
                    int newNumber = scanner.nextInt();
                    repository.update(oldNumber, newNumber);
                    break;

                case 4: // Удалить элемент
                    System.out.print("Введите элемент для удаления: ");
                    repository.delete(scanner.nextInt());
                    break;

                case 0: // Выйти
                    System.out.println("Выход из программы.");
                    return;

                default:
                    System.out.println("Неверный выбор, попробуйте снова.");
            }

            // Вывод отсортированного массива после операций
            System.out.println("Текущий отсортированный массив:");
            int[] currentNumbers = repository.getAll();
            for (int num : currentNumbers) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}