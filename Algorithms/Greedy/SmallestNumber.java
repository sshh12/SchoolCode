
public class SmallestNumber {

    public static long getSmallestNum(int digitSum, int ndigits) {

        if (digitSum <= 0 || digitSum > 9 * ndigits) {
            return -1;
        }

        int[] result = new int[ndigits];

        digitSum -= 1;

        for (int i = ndigits - 1; i > 0; i--) {

            if (digitSum > 9) {

                result[i] = 9;
                digitSum -= 9;

            } else {

                result[i] = digitSum;
                digitSum = 0;

            }

        }

        result[0] = digitSum + 1;

        long n = 0;

        for (int i = ndigits - 1, pow = 1; i >= 0; i--, pow *= 10) {

            n += pow * result[i];

        }

        return n;

    }

    public static void main(String[] args) {

        System.out.println(getSmallestNum(10, 3));

    }

}
