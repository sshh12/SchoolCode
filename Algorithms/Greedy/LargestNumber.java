
import java.util.*;

public class LargestNumber {

    public static long getLargestNumber(int[] nums) {

        String[] values = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {

            values[i] = Integer.toString(nums[i]);

        }

        Arrays.sort(values, (String a, String b) -> {

            return (b + a).compareTo(a + b);

        });

        String result = "";

        for (String val : values) {

            result += val;

        }

        return Long.parseLong(result);

    }

    public static void main(String[] args) {

        int[] nums = new int[]{22, 225, 53, 19, 100};

        System.out.println(getLargestNumber(nums));

    }

}
