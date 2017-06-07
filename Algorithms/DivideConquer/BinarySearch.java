
import java.util.Arrays;

public class BinarySeach {

    private static int binarySearch(int[] nums, int x) {

        int bottom = 0, top = nums.length - 1;

        while (bottom <= top) {

            int middle = (top + bottom) / 2;

            if (nums[middle] == x) {
                return middle;
            } else if (nums[middle] < x) {
                bottom = middle + 1;
            } else {
                top = middle - 1;
            }

        }

        return -1;

    }

    private static int binarySearch2(int[] nums, int x) {

        return recur(nums, 0, nums.length - 1, x);

    }

    private static int recur(int[] nums, int bottom, int top, int x) {

        if (top >= bottom) {

            int middle = (bottom + top) / 2;

            if (nums[middle] == x) {
                return middle;
            } else if (nums[middle] < x) {
                return recur(nums, middle + 1, top, x);
            }

            return recur(nums, bottom, middle - 1, x);

        }

        return -1;

    }

    public static void main(String[] args) {

        int[] nums = new int[]{3, 5, 657, 23, 5, 9, 2, 54, 22, 10, 14, 20, 42, 32, 15, 11};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        System.out.println(binarySearch(nums, 10));

        System.out.println("------");

        System.out.println(binarySearch(nums, 10));

    }

}
