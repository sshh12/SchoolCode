
import java.util.Arrays;


public class ShellSort {

    public static void shellSort(int[] nums){

        for(int gap = nums.length / 2; gap > 0; gap /= 2){

            for(int i = gap; i < nums.length; i++){

                int j = i, temp = nums[i];

                while(j >= gap && nums[j - gap] > temp){

                    nums[j] = nums[j - gap];

                    j -= gap;

                }

                nums[j] = temp;

            }

        }

    }

    public static void main(String[] args) {

        int[] nums = new int[]{1, 52, 2, 25, 6, 10, 25, 200, 15, 12, 8, 2};

        System.out.println(Arrays.toString(nums));

        shellSort(nums);

        System.out.println(Arrays.toString(nums));

    }

}
