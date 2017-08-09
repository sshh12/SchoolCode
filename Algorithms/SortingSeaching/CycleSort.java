
import java.util.Arrays;

public class CycleSort {

    public static void cycleSort(int[] nums) {

        int n = nums.length;

        for (int cycleIndex = 0; cycleIndex <= n - 2; cycleIndex++) {

            int item = nums[cycleIndex], index = cycleIndex;

            for (int i = cycleIndex + 1; i < n; i++) {

                if (nums[i] < item) {

                    index++;

                }

            }

            if (index == cycleIndex) {
                continue;
            }

            while (item == nums[index]) {
                index++;
            }

            int temp = nums[index];
            nums[index] = item;
            item = temp;

            while (index != cycleIndex) {

                index = cycleIndex;

                for (int i = cycleIndex + 1; i < n; i++) {

                    if (nums[i] < item) {

                        index++;

                    }

                }

                while (item == nums[index]) {
                    index++;
                }

                temp = nums[index];
                nums[index] = item;
                item = temp;

            }

        }

    }

    public static void main(String[] args) {

        int[] nums = new int[]{3, 654, 3, 33, 10, 8, 2, 99, 101, 94, 60};

        System.out.println(Arrays.toString(nums));

        cycleSort(nums);

        System.out.println(Arrays.toString(nums));

    }

}
