
import java.util.*;

public class UniqueSummands {

    public static List<Integer> getUniqueSummands(int num) {

        List<Integer> summands = new ArrayList<>();

        if (num <= 2) {

            summands.add(num);

        } else {

            int k = 1;

            while (num > 2 * k) {

                num -= k;

                summands.add(k++);

            }

            summands.add(num);

        }

        return summands;

    }

    public static void main(String[] args) {

        for (int n : getUniqueSummands(8)) {

            System.out.println(n);

        }

    }

}
