
import java.util.*;

public class BitonicSort {

    private static void swap(int[] nums, int a, int b) {

        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;

    }

    private static void merge(int[] nums, int index, int length, boolean increasing) {

        if (length > 1) {

            int half = length / 2;

            for (int i = index; i < index + half; i++) {

                if ((nums[i] > nums[i + half] && increasing) ||
                    (nums[i] < nums[i + half] && !increasing)) {

                    swap(nums, i, i + half);

                }
            }

            merge(nums, index, half, increasing);
            merge(nums, index + half, half, increasing);

        }

    }

    public static void bitonicSort(int[] nums, int index, int length, boolean increasing) {

        if (length > 1) {

            int half = length / 2;

            bitonicSort(nums, index, half, true);
            bitonicSort(nums, index + half, half, false);

            merge(nums, index, length, increasing);

        }

    }

    public static void main(String[] args) {

        int[] nums = new int[]{1, 5, 77, 34, 2, 18, 19, 20, 21, 10, 43, 99, 101, 77, 75, 71}; // Must be pow of 2

        System.out.println(Arrays.toString(nums));

        bitonicSort(nums, 0, nums.length, true);

        System.out.println(Arrays.toString(nums));

    }

}
