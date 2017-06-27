
public class RodCutting {

    public static int getMaxPrice(int[] prices, int index) {

        if (index < 0) {
            return 0;
        }

        int max = 0;

        for (int i = 0; i <= index; i++) {

            max = Math.max(max, prices[i] + getMaxPrice(prices, index - i - 1));

        }

        return max;

    }

    public static int getMaxPrice2(int[] prices) {

        int[] db = new int[prices.length + 1];

        for (int i = 1; i <= prices.length; i++) {

            int max = 0;

            for (int j = 0; j < i; j++) {

                max = Math.max(max, prices[j] + db[i - j - 1]);

            }

            db[i] = max;

        }

        return db[prices.length];

    }

    public static void main(String[] args) {

        int[] prices = new int[]{1, 5, 8, 9, 10, 17, 17, 20};

        System.out.println(getMaxPrice(prices, prices.length - 1));

        System.out.println("------");

        System.out.println(getMaxPrice2(prices));

    }

}
