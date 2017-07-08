
import java.util.*;

public class MaxDotProduct {

    public static int getMaxDotProduct(int[] a, int[] b) {

        Arrays.sort(a);
        Arrays.sort(b);

        int sum = 0;

        for (int i = 0; i < a.length; i++) {

            sum += a[i] * b[i];

        }

        return sum;

    }

    public static void main(String[] args) {

        int[] a = new int[]{1, 3, -5};

        int[] b = new int[]{-2, 4, 1};

        System.out.println(getMaxDotProduct(a, b));

    }

}
