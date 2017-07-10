
public class PerfectChange {

    public static int getNumCoins(int[] values, int amt) {

        int coins = 0;

        for (int v : values) {

            while (amt >= v) {

                amt -= v;
                coins++;

            }

        }

        return coins;

    }

    public static void main(String[] args) {

        int[] values = new int[]{10, 5, 1};

        System.out.println(getNumCoins(values, 28));

    }

}
