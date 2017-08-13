
import java.util.Arrays;

public class BinaryInsertionSort {

    public static void binaryInsertionSort(int[] nums) {

        for (int i = 1; i < nums.length; i++) {

            int n = nums[i], j = i - 1;

            int correctIndex = -Arrays.binarySearch(nums, 0, i, n) - 1;

            while (j >= correctIndex) {

                nums[j + 1] = nums[j--];

            }

            nums[j + 1] = n;

        }

    }

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 0, 8, 22, 189, 221, 10, 88, 67, 45, 34};

        System.out.println(Arrays.toString(nums));

        binaryInsertionSort(nums);

        System.out.println(Arrays.toString(nums));

    }

}
