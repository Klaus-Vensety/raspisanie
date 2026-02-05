public class WeekDay {
    private String name;
    private String[] slotList = new String[7];

    public enum DAYS {
        MONDAY("Понедельник"),
        TUESDAY("Вторник"),
        WEDNESDAY("Среда"),
        THURSDAY("Четверг"),
        FRIDAY("Пятница"),
        SATURDAY("Суббота"),
        SUNDAY("Воскресенье");

        public String title;

        DAYS(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }

    public WeekDay(int dayNumber) throws Exception {
        if (dayNumber > 7 || dayNumber < 1) {
            throw new Exception("Некорректный день недели!");
        }
        this.name = DAYS.values()[dayNumber - 1].getTitle();
    }

    public WeekDay(DAYS day) {
        this.name = day.getTitle();
    }

    public void add(int slotNumber, String title) throws Exception {
        if (slotNumber < 0 || slotNumber >= slotList.length) {
            throw new Exception("Некорректный номер слота! Допустимые значения: 0-" + (slotList.length - 1));
        }
        slotList[slotNumber] = title;
    }

    public void remove(int slotNumber) throws Exception {
        if (slotNumber < 0 || slotNumber >= slotList.length) {
            throw new Exception("Некорректный номер слота! Допустимые значения: 0-" + (slotList.length - 1));
        }
        if (slotList[slotNumber] == null) {
            throw new Exception("Слот уже пуст!");
        }
        slotList[slotNumber] = null;
    }

    public void print() {
        System.out.println("=================" + name + "===============");
        for (int i = 0; i < slotList.length; i++) {
            if (slotList[i] != null) {
                System.out.print(i + ") ");
                System.out.println(slotList[i]);
            }
        }
        System.out.println("==========================================");
    }

    public boolean isEmpty() {
        for (String subject : slotList) {
            if (subject != null) {
                return false;
            }
        }
        return true;
    }

    public int findSlotByTitle(String title) {
        for (int i = 0; i < slotList.length; i++) {
            if (slotList[i] != null && slotList[i].equalsIgnoreCase(title)) {
                return i;
            }
        }
        return -1;
    }

    public int getSubjectCount() {
        int count = 0;
        for (String subject : slotList) {
            if (subject != null) {
                count++;
            }
        }
        return count;
    }

    public String getName() {
        return name;
    }
}
