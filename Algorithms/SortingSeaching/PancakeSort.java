
import java.util.Arrays;

public class PancakeSort {

    private static void flip(int[] nums, int endIndex) {

        int startIndex = 0;

        while (startIndex < endIndex) {

            int temp = nums[startIndex];

            nums[startIndex++] = nums[endIndex];
            nums[endIndex--] = temp;

        }

    }

    private static int findMaxIndex(int[] nums, int endIndex) {

        int maxIndex = 0;

        for (int i = 0; i < endIndex; i++) {

            if (nums[i] > nums[maxIndex]) {

                maxIndex = i;

            }

        }

        return maxIndex;

    }

    public static void pancakeSort(int[] nums) {

        for (int size = nums.length; size > 1; size--) {

            int maxIndex = findMaxIndex(nums, size);

            if (maxIndex != size - 1) {

                flip(nums, maxIndex);
                flip(nums, size - 1);

            }

        }

    }

    public static void main(String[] args) {

        int[] nums = new int[]{12, 3, 33, 1, 88, 100, 50, 40, 60, 25, 2, 4, 6, 22};

        System.out.println(Arrays.toString(nums));

        pancakeSort(nums);

        System.out.println(Arrays.toString(nums));

    }

}
