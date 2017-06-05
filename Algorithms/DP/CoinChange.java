

public class CoinChange {

    public static int getNumCoins(int[] coins, int i, int balance) {

        if (balance == 0) {
            return 1;
        }

        if ((balance < 0) || (i <= 0 && balance >= 1)) {
            return 0;
        }

        return getNumCoins(coins, i - 1, balance)
                + getNumCoins(coins, i, balance - coins[i - 1]);

    }

    public static int getNumCoins2(int[] coins, int i, int balance) {

        int[] db = new int[balance + 1];

        db[0] = 1;

        for (int k = 0; k < i; k++) {

            for (int j = coins[k]; j <= balance; j++) {

                db[j] += db[j - coins[k]];

            }

        }

        return db[balance];

    }

    public static void main(String[] args) {

        int[] coins = new int[]{1, 2, 8, 12};

        System.out.println(getNumCoins(coins, coins.length, 25));

        System.out.println("------");

        System.out.println(getNumCoins2(coins, coins.length, 25));

    }

}
