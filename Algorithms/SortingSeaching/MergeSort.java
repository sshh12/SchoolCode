
import java.util.Arrays;

public class MergeSort {

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

    public static void mergeSort(int[] nums, int leftIndex, int rightIndex) {

        if (leftIndex < rightIndex) {

            int middleIndex = (leftIndex + rightIndex) / 2;

            mergeSort(nums, leftIndex, middleIndex);
            mergeSort(nums, middleIndex + 1, rightIndex);

            merge(nums, leftIndex, middleIndex, rightIndex);

        }

    }

    public static void main(String[] args) {

        int[] nums = new int[]{1, 32, 33, 5, 99, 23, 12, 4, 100, 26, 24};

        System.out.println(Arrays.toString(nums));

        mergeSort(nums, 0, nums.length - 1);

        System.out.println(Arrays.toString(nums));

    }

}
