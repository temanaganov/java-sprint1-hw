import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        while (true) {
            printMenu();
            int command = scanner.nextInt();

            switch (command) {
                case 1 -> saveSteps(stepTracker, scanner);
                case 2 -> getStatistics(stepTracker, scanner);
                case 3 -> changeAim(stepTracker, scanner);
                case 0 -> {
                    System.out.println("Программа завершена\n");
                    return;
                }
                default -> System.out.println("Такой команды нет\n");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
    }

    public static void saveSteps(StepTracker stepTracker, Scanner scanner) {
        System.out.print("Введите месяц (1 – 12): ");
        int month = scanner.nextInt();
        while (month < 1 || month > 12) {
            System.out.println("Допустимые значения месяца: 1 – 12\n");
            System.out.print("Введите месяц (1 – 12): ");
            month = scanner.nextInt();
        }
        System.out.print("Введите день (1 – 30): ");
        int day = scanner.nextInt();
        while (day < 1 || day > 30) {
            System.out.println("Допустимые значения дня: 1 – 30\n");
            System.out.print("Введите день (1 – 30): ");
            day = scanner.nextInt();
        }
        System.out.print("Введите кол-во шагов: ");
        int steps = scanner.nextInt();
        while (steps < 0) {
            System.out.println("Кол-во шагов не может быть отрицательным\n");
            System.out.print("Введите кол-во шагов: ");
            steps = scanner.nextInt();
        }
        stepTracker.saveSteps(month - 1, day - 1, steps);
        System.out.println("Шаги сохранены\n");
    }

    public static void getStatistics(StepTracker stepTracker, Scanner scanner) {
        System.out.print("Введите месяц (1 – 12): ");
        int month = scanner.nextInt();
        while (month < 1 || month > 12) {
            System.out.println("Допустимые значения месяца: 1 – 12\n");
            System.out.print("Введите месяц (1 – 12): ");
            month = scanner.nextInt();
        }
        stepTracker.getStatistics(month - 1);
    }

    public static void changeAim(StepTracker stepTracker, Scanner scanner) {
        System.out.print("Новая цель: ");
        int steps = scanner.nextInt();
        while (steps < 0) {
            System.out.println("Значение не может быть отрицательным\n");
            System.out.print("Новая цель: ");
            steps = scanner.nextInt();
        }
        stepTracker.changeAim(steps);
    }
}
