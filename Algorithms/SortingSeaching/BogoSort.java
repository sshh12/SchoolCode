
import java.util.Arrays;

public class BogoSort {

    private static boolean isSorted(int[] nums) {

        for (int i = 1; i < nums.length; i++) {

            if (nums[i - 1] > nums[i]) {

                return false;

            }

        }

        return true;

    }

    private static void shuffle(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            int randIndex = (int) (Math.random() * nums.length), temp = nums[i];

            nums[i] = nums[randIndex];
            nums[randIndex] = temp;

        }

    }

    public static void bogoSort(int[] nums) {

        while (!isSorted(nums)) {

            shuffle(nums);

        }

    }

    public static void main(String[] args) {

        int[] nums = new int[]{7, 3, 1, 10, 5, 2, 9, 4, 6, 8};

        System.out.println(Arrays.toString(nums));

        bogoSort(nums);

        System.out.println(Arrays.toString(nums));

    }

}
