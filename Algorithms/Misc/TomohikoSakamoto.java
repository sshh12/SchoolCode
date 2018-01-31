
public class TomohikoSakamoto {

    private static int[] offsets = new int[]{0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};

    public static int getDayOfWeek(int year, int month, int day) {

        if (month < 3) {
            year--;
        }

        return (year + year / 4 - year / 100 + year / 400 + offsets[month - 1] + day) % 7;

    }

    public static void main(String[] args) {

        System.out.println(getDayOfWeek(2000, 1, 1));

    }

}
