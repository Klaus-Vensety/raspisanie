public class WeekDay {
    private String name;
    private String[] slotList = new String[7];

    public enum DAYS {
        SUNDAY ("Воскресение"),
        MONDAY ("Понедельник"),
        TUESDAY ("Вторник"),
        WEDNESDAY ("Среда"),
        THURSDAY ("Четверг"),
        FRIDAY ("Пятница"),
        SATURDAY("Суббота");

        public String title;

        DAYS(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }

    public WeekDay(int dayNumber) throws Exception {
        if(dayNumber > 6 || dayNumber < 1) {
            throw(new Exception("Некорректный день недели!"));
        }
        this.name = DAYS.values()[dayNumber].getTitle();
    }

    public WeekDay(DAYS day) {
        this.name = day.getTitle();
    }

    public void add(int slotNumber, String title) throws Exception {
        if(slotNumber < 0 || slotNumber >= slotList.length) {
            throw new Exception("Некорректный номер слота! Должен быть 0-6");
        }

        // Проверка: может слот уже занят?
        if(slotList[slotNumber] != null) {
            throw new Exception("Этот слот уже занят предметом: " + slotList[slotNumber]);
        }

        slotList[slotNumber] = title;
    }

    // НОВЫЙ МЕТОД: удаление из слота
    public void remove(int slotNumber) throws Exception {
        if(slotNumber < 0 || slotNumber >= slotList.length) {
            throw new Exception("Некорректный номер слота! Должен быть 0-6");
        }

        if(slotList[slotNumber] == null) {
            throw new Exception("В этом слоте нет пары!");
        }

        slotList[slotNumber] = null;
    }

    // НОВЫЙ МЕТОД: проверка наличия пары
    public boolean hasLesson(int slotNumber) {
        if(slotNumber < 0 || slotNumber >= slotList.length) {
            return false;
        }
        return slotList[slotNumber] != null;
    }

    public void print() {
        System.out.println("================="+ name +"===============");
        boolean hasLessons = false;
        for(int i=0; i < slotList.length; i++) {
            if(slotList[i] != null) {
                System.out.print(i + ") ");
                System.out.println(slotList[i]);
                hasLessons = true;
            }
        }
        if(!hasLessons) {
            System.out.println("   (нет пар)");
        }
        System.out.println("==========================================");
    }
}