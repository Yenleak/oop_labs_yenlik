public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time(int h, int m, int s) {
        setTime(h, m, s);
    }

    // Деректерді тексеру 
    public void setTime(int h, int m, int s) {
        this.hour = (h >= 0 && h < 24) ? h : 0;
        this.minute = (m >= 0 && m < 60) ? m : 0;
        this.second = (s >= 0 && s < 60) ? s : 0;
    }

    // универсал: 23:05:06
    public String toUniversal() {
        // %02d - екі таңбалы сан, жетпесе алдына 0 қояды
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    // стандарт: 11:05:06 рм
    public String toStandard() {
        int h = ((hour == 0 || hour == 12) ? 12 : hour % 12);
        String unit = (hour < 12) ? "AM" : "PM";
        return String.format("%02d:%02d:%02d %s", h, minute, second, unit);
    }

    // add әдісі (t.add(t2))
    public void add(Time t2) {
        this.second += t2.second;
        if (this.second >= 60) {
            this.second -= 60;
            this.minute++;
        }

        this.minute += t2.minute;
        if (this.minute >= 60) {
            this.minute -= 60;
            this.hour++;
        }

        this.hour = (this.hour + t2.hour) % 24;
    }

    public static void main(String[] args) {
        Time t = new Time(23, 5, 6);
        System.out.println("Universal: " + t.toUniversal()); 
        System.out.println( "Standard: " +t.toStandard());  

        Time t2 = new Time(4, 24, 33);
        t.add(t2); 
        
        System.out.println("After addition: " + t.toUniversal()); // 03:29:39
    }
}