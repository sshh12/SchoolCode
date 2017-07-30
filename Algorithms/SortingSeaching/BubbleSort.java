
import java.util.Arrays;

public class BubbleSort {

    private static void swap(int[] nums, int a, int b) {

        int temp = nums[a];

        nums[a] = nums[b];
        nums[b] = temp;

    }

    public static void bubbleSort(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {

            for(int j = 0; j < n - i - 1; j++){

                if(nums[j] > nums[j + 1]){

                    swap(nums, j, j + 1);

                }

            }

        }

    }

    public static void main(String[] args) {

        int[] nums = new int[]{1, 43, 12, 3, 4, 99, 65, 66, 32, 8};

        System.out.println(Arrays.toString(nums));

        bubbleSort(nums);

        System.out.println(Arrays.toString(nums));

    }

}
