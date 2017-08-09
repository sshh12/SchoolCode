
import java.util.Arrays;

public class TimSort {

    public static final int RUN = 4;

    private static void insertionSort(int[] nums, int leftIndex, int rightIndex) {

        for (int i = leftIndex + 1; i <= rightIndex; i++) {

            int n = nums[i], j = i - 1;

            while (j >= leftIndex && nums[j] > n) {

                nums[j + 1] = nums[j];

                j--;

            }

            nums[j + 1] = n;

        }

    }

    private static void merge(int[] nums, int leftIndex, int middleIndex, int rightIndex) {

        int leftSize = middleIndex - leftIndex + 1;
        int rightSize = rightIndex - middleIndex;

        int leftElements[] = Arrays.copyOfRange(nums, leftIndex, leftIndex + leftSize);
        int rightElements[] = Arrays.copyOfRange(nums, middleIndex + 1, middleIndex + rightSize + 1);

        int left = 0, right = 0, index = leftIndex;

        while (left < leftSize && right < rightSize) {

            if (leftElements[left] <= rightElements[right]) {

                nums[index++] = leftElements[left++];

            } else {

                nums[index++] = rightElements[right++];

            }

        }

        while (left < leftSize) {

            nums[index++] = leftElements[left++];

        }

        while (right < rightSize) {

            nums[index++] = rightElements[right++];

        }

    }

    public static void timSort(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n; i += RUN) {

            insertionSort(nums, i, Math.min(i + RUN - 1, n - 1));

        }

        for (int size = RUN; size < n; size *= 2) {

            for (int leftIndex = 0; leftIndex < n; leftIndex += 2 * size) {

                int rightIndex = Math.min(leftIndex + 2 * size - 1, n - 1),
                    middleIndex = Math.min(leftIndex + size - 1, rightIndex);

                merge(nums, leftIndex, middleIndex, rightIndex);

            }

        }

    }

    public static void main(String[] args) {

        int[] nums = new int[]{1, 3, 88, 12, 3432, 32, 10, 5, 99, 111, 85, 939, 4, 0, 8, 101};

        System.out.println(Arrays.toString(nums));

        timSort(nums);

        System.out.println(Arrays.toString(nums));

    }

}
