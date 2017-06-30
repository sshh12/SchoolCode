
public class StairSteps {

    public static int countWays(int steps) {

        return steps < 1 ? 0
                           : 1 + countWays(steps - 1) + countWays(steps - 2) + countWays(steps - 3);

    }

    public static int countWays2(int steps) {

        int[] db = new int[steps];

        db[0] = db[1] = 1;

        for (int i = 1; i < steps; i++) {

            for (int k = 1; k <= 3 && k <= i; k++) {

                db[i] += db[i - k];

            }

        }

        return db[steps - 1];

    }

    public static void main(String[] args) {

        System.out.println(countWays(3));

        System.out.println("------");

        System.out.println(countWays(3));

    }

}
