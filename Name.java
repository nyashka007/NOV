public class Name {
    private int hours;
    private int minutes;
    private int seconds;

    public Name() {
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
    }

    public Name(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int minutesToMidnight() {
        int totalMinutes = (24 - hours) * 60 - minutes;
        return totalMinutes;
    }

    public void addMinutes(int minutesToAdd) {
        this.minutes += minutesToAdd;
        if (this.minutes >= 60) {
            this.hours += this.minutes / 60;
            this.minutes = this.minutes % 60;
        }
        if (this.hours >= 24) {
            this.hours = this.hours % 24;
        }
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }


    public static void main(String[] args) {
        Name time1 = new Name(10, 30, 0);
        System.out.println("Время: " + time1);
        System.out.println("Минут до полуночи: " + time1.minutesToMidnight());

        time1.addMinutes(100);
        System.out.println("Время после добавления 100 минут: " + time1);

        Name time2 = new Name();
        time2.hours = 12;
        time2.minutes = 45;
        System.out.println("Время: " + time2);
        System.out.println("Минут до полуночи: " + time2.minutesToMidnight());

        time2.addMinutes(100);
        System.out.println("Время после добавления 100 минут: " + time2);
    }
}