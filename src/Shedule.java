public class Shedule {
    private WeekDay[] dayList = new WeekDay[7];

    public Shedule() {
        WeekDay.DAYS[] weekDayList = WeekDay.DAYS.values();

        for (int i = 0; i < weekDayList.length; i++) {
            dayList[i] = new WeekDay(weekDayList[i]);
        }
    }

    public void add(int dayNumber, int slot, String title) throws Exception {
        if (dayNumber > 7 || dayNumber < 1) {
            throw new Exception("Некорректный день недели! Введите число от 1 до 7.");
        }
        dayList[dayNumber - 1].add(slot, title);
    }

    public void printDay(int dayNumber) throws Exception {
        if (dayNumber > 7 || dayNumber < 1) {
            throw new Exception("Некорректный день недели! Введите число от 1 до 7.");
        }
        dayList[dayNumber - 1].print();
    }

    public void remove(int dayNumber, int slot) throws Exception {
        if (dayNumber > 7 || dayNumber < 1) {
            throw new Exception("Некорректный день недели! Введите число от 1 до 7.");
        }
        dayList[dayNumber - 1].remove(slot);
    }

    public void printAll() {
        System.out.println("\n=== РАСПИСАНИЕ НА ВСЮ НЕДЕЛЮ ===");
        for (int i = 0; i < dayList.length; i++) {
            System.out.println("\nДень " + (i + 1) + ":");
            if (dayList[i].isEmpty()) {
                System.out.println("В этот день занятий нет.");
            } else {
                dayList[i].print();
            }
        }
        System.out.println("===============================\n");
    }

    public void findTitle(String title) {
        boolean found = false;
        System.out.println("\n=== РЕЗУЛЬТАТЫ ПОИСКА: " + title + " ===");
        
        for (int i = 0; i < dayList.length; i++) {
            int slot = dayList[i].findSlotByTitle(title);
            if (slot != -1) {
                System.out.println("День: " + dayList[i].getName() + ", Пара: " + slot);
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("Предмет не найден в расписании.");
        }
        System.out.println("================================\n");
    }

    public void printStats() {
        System.out.println("\n=== СТАТИСТИКА ЗА НЕДЕЛЮ ===");
        
        int totalSubjects = 0;
        int maxSubjects = 0;
        
        for (WeekDay day : dayList) {
            int count = day.getSubjectCount();
            totalSubjects += count;
            if (count > maxSubjects) {
                maxSubjects = count;
            }
        }
        
        System.out.println("Всего предметов за неделю: " + totalSubjects);
        
        if (maxSubjects == 0) {
            System.out.println("На этой неделе нет занятий.");
        } else {
            System.out.println("День(и) с наибольшим количеством предметов (" + maxSubjects + "):");
            for (WeekDay day : dayList) {
                if (day.getSubjectCount() == maxSubjects) {
                    System.out.println("- " + day.getName());
                }
            }
        }
        System.out.println("============================\n");
    }
}
