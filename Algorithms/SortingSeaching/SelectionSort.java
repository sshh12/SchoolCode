
import java.util.Arrays;


public class SelectionSort {

    private static void swap(int[] nums, int a, int b) {

        int temp = nums[a];

        nums[a] = nums[b];
        nums[b] = temp;

    }

    public static void selectionSort(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            int minIndex = i;

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[j] < nums[minIndex]) {

                    minIndex = j;

                }

            }

            swap(nums, i, minIndex);

        }

    }

    public static void main(String[] args) {

        int[] nums = new int[]{12, 45, 1, 76, 23, 25, 33, 99, 65, 46};

        System.out.println(Arrays.toString(nums));

        selectionSort(nums);

        System.out.println(Arrays.toString(nums));

    }

}
