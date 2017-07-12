
import java.util.Arrays;

public class InsertionSort {

    public static void insertionSort(int[] nums) {

        for (int i = 1; i < nums.length; i++) {

            int n = nums[i], j = i - 1;

            while (j >= 0 && nums[j] > n) {

                nums[j + 1] = nums[j];

                j--;

            }

            nums[j + 1] = n;

        }

    }

    public static void main(String[] args) {

        int[] nums = new int[]{12, 45, 1, 76, 23, 25, 33, 99, 65, 46};

        System.out.println(Arrays.toString(nums));

        insertionSort(nums);

        System.out.println(Arrays.toString(nums));

    }

}
