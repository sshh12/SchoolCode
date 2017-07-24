
public class StairSteps {

    public static int countWays(int steps) {

        if (steps <= 1) {

            return steps;

        } else {

            int sum = 0;

            for (int i = 1; i <= Math.min(steps, 3); i++) {

                sum += countWays(steps - i);

            }

            return sum;

        }

    }

    public static int countWays2(int steps) {

        if (steps == 1) {

            return 1;

        } else {

            int[] db = new int[steps + 1];

            db[1] = 1;
            db[2] = 2;
            db[3] = 4;

            for (int i = 4; i <= steps; i++) {

                db[i] = db[i - 1] + db[i - 2] + db[i - 3];

            }

            return db[steps];

        }

    }

    public static void main(String[] args) {

        System.out.println(countWays(22 + 1));

        System.out.println("------");

        System.out.println(countWays2(22));

    }

}
