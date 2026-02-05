import java.util.Scanner;

public class Main {
    static Shedule shedule = new Shedule();

    public static void main(String[] args) {
        while (true) {
            int command = printMenu();

            switch (command) {
                case 1:
                    String addLine = getAdd();
                    String[] addArray = addLine.split(" ");
                    try {
                        shedule.add(Integer.parseInt(addArray[0]), Integer.parseInt(addArray[1]), addArray[2]);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    String printLine = getPrint();
                    try {
                        shedule.printDay(Integer.parseInt(printLine));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    String removeLine = getRemove();
                    String[] removeArray = removeLine.split(" ");
                    try {
                        shedule.remove(Integer.parseInt(removeArray[0]), Integer.parseInt(removeArray[1]));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    shedule.printAll();
                    break;
                case 5:
                    String searchTitle = getSearchTitle();
                    shedule.findTitle(searchTitle);
                    break;
                case 6:
                    shedule.printStats();
                    break;
                default:
                    System.out.println("Неизвестная команда.");
            }
        }
    }

    public static int printMenu() {
        Scanner scaner = new Scanner(System.in);

        System.out.println("""
                1) Добавить предмет в расписание
                2) Вывести расписание за день
                3) Удалить предмет из расписания
                4) Вывести расписание на всю неделю
                5) Найти предмет по названию
                6) Статистика за неделю
                """);
        System.out.print("Введите команду: ");

        return scaner.nextInt();
    }

    public static String getAdd() {
        Scanner scaner = new Scanner(System.in);
        System.out.print("Введите через пробел номер дня недели (1-7), номер пары и предмет: ");
        return scaner.nextLine();
    }

    public static String getPrint() {
        Scanner scaner = new Scanner(System.in);
        System.out.print("Введите номер дня недели (1-7): ");
        return scaner.nextLine();
    }

    public static String getRemove() {
        Scanner scaner = new Scanner(System.in);
        System.out.print("Введите через пробел номер дня недели (1-7) и номер пары для удаления: ");
        return scaner.nextLine();
    }

    public static String getSearchTitle() {
        Scanner scaner = new Scanner(System.in);
        System.out.print("Введите название предмета для поиска: ");
        return scaner.nextLine();
    }
}
