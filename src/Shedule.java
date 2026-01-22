public class Shedule {
    private WeekDay[] dayList = new WeekDay[7];

    public Shedule() {
        WeekDay.DAYS[] weekDayList = WeekDay.DAYS.values();

        for (int i = 0; i < weekDayList.length; i++) {
            dayList[i] = new WeekDay(weekDayList[i]);
        }
    }

    public void add(int dayNumber, int slot, String title) throws Exception {
        if(dayNumber > 6 || dayNumber < 1) {
            throw(new Exception("Некорректный день недели! Должен быть 1-7"));
        }
        dayList[dayNumber].add(slot, title);
    }

    // НОВЫЙ МЕТОД: удаление пары
    public void remove(int dayNumber, int slot) throws Exception {
        if(dayNumber > 6 || dayNumber < 1) {
            throw(new Exception("Некорректный день недели! Должен быть 1-7"));
        }

        // Проверяем, есть ли что удалять
        if(!dayList[dayNumber].hasLesson(slot)) {
            throw new Exception("В указанном слоте нет пары!");
        }

        dayList[dayNumber].remove(slot);
    }

    public void printDay(int dayNumber) throws Exception {
        if(dayNumber > 6 || dayNumber < 1) {
            throw(new Exception("Некорректный день недели! Должен быть 1-7"));
        }
        dayList[dayNumber].print();
    }
}