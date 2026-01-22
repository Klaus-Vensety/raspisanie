import java.util.Scanner;

public class Main {
    public static void main(String[] args) {  // ИСПРАВЛЕНО: добавили String[] args
        Shedule shedule = new Shedule();

        while (true) {
            int command = printMenu();

            switch (command) {
                case 0:  // НОВАЯ КОМАНДА - ВЫХОД
                    System.out.println("Выход из программы...");
                    return;  // Выходим из main

                case 1:
                    String addLine = getAdd();
                    String[] addArray = addLine.split(" ");
                    try{
                        // Пользователь вводит день 1-7, слот 0-6
                        shedule.add(Integer.parseInt(addArray[0]),
                                Integer.parseInt(addArray[1]),
                                addArray[2]);
                        System.out.println("Предмет добавлен!");
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;

                case 2:
                    String printLine = getPrint();
                    try{
                        shedule.printDay(Integer.parseInt(printLine));
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;

                case 3:  // НОВАЯ КОМАНДА - УДАЛЕНИЕ
                    String deleteLine = getDelete();
                    String[] deleteArray = deleteLine.split(" ");
                    if(deleteArray.length < 2) {
                        System.out.println("Ошибка: нужно ввести день и номер пары!");
                        break;
                    }
                    try {
                        int dayNum = Integer.parseInt(deleteArray[0]);
                        int slotNum = Integer.parseInt(deleteArray[1]);
                        shedule.remove(dayNum, slotNum);
                        System.out.println("Предмет удален!");
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;

                default:
                    System.out.println("Неизвестная команда.");
            }
            System.out.println();  // Пустая строка для читаемости
        }
    }

    public static int printMenu() {
        Scanner scaner = new Scanner(System.in);

        System.out.println("""
                0) Выход
                1) Добавить предмет в расписание
                2) Вывести расписание за день
                3) Удалить предмет из расписания
                """);
        System.out.print("Введите команду: ");

        return scaner.nextInt();
    }

    public static String getAdd() {
        Scanner scaner = new Scanner(System.in);
        System.out.print("Введите через пробел: [день(1-7)] [номер пары(0-6)] [предмет]: ");
        return scaner.nextLine();
    }

    public static String getPrint() {
        Scanner scaner = new Scanner(System.in);
        System.out.print("Введите номер дня недели (1-7): ");
        return scaner.nextLine();
    }

    // НОВЫЙ МЕТОД для удаления
    public static String getDelete() {
        Scanner scaner = new Scanner(System.in);
        System.out.print("Введите через пробел: [день(1-7)] [номер пары(0-6)]: ");
        return scaner.nextLine();
    }
}