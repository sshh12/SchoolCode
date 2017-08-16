
public class CubicRoot {

    private static double calcError(double n, double guess) {

        return guess * guess * guess - n;

    }

    public static double cubicRoot(double n, double prec) {

        double start = 0, end = n;

        while (true) {

            double guess = (start + end) / 2, error = calcError(n, guess);

            if (Math.abs(error) < prec) {

                return guess;

            } else if (error > 0) {

                end = guess;

            } else {

                start = guess;

            }

        }

    }

    public static void main(String[] args) {

        System.out.println(cubicRoot(3, 1e-7));

    }

}
