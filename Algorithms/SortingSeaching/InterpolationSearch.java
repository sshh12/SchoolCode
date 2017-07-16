
import java.util.Arrays;

public class InterpolationSearch {

    public static int interpolationSearch(int[] nums, int x) {

        int bottom = 0, top = nums.length - 1;

        while (bottom <= top && x >= nums[bottom] && x <= nums[top]) {

            int position = bottom + (top - bottom) / (nums[top] - nums[bottom]) * (x - nums[bottom]);

            if (nums[position] == x) {

                return position;

            } else if (nums[position] < x) {

                bottom = position + 1;

            } else {

                top = position - 1;

            }

        }

        return -1;

    }

    public static void main(String[] args) {

        int[] nums = new int[]{2, 15, 28, 34, 44, 51, 67, 79, 87, 93, 105};

        Arrays.sort(nums);

        System.out.println(Arrays.toString(nums));

        System.out.println(interpolationSearch(nums, 15));

    }

}
